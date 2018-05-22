package bonc.demopractice_allkinsoff.rx_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

import static bonc.demopractice_allkinsoff.R.id.btRxThread;

public class RxJavaActivity extends AppCompatActivity {

    @BindView(R.id.btRxJava)
    Button mBtRxJava;
    @BindView(R.id.btRxAndroid)
    Button mBtRxAndroid;
    @BindView(btRxThread)
    Button mBtRxThread;
    @BindView(R.id.btRxFlatMap)
    Button mBtRxFlatMap;
    @BindView(R.id.btRxZip)
    Button mBtRxZip;
    @BindView(R.id.btRxOOM)
    Button mBtRxOOM;
    @BindView(R.id.llParent)
    LinearLayout mLlParent;
    @BindView(R.id.btRxFlowable)
    Button mBtRxFlowable;
    @BindView(R.id.btRxInterval)
    Button mBtRxInterval;
    @BindView(R.id.btRxFlowableRequest)
    Button mBtRxFlowableRequest;
    @BindView(R.id.tvRxJavaResult)
    TextView mTvRxJavaResult;
    @BindView(R.id.btRxDistinct)
    Button mBtRxDistinct;
    @BindView(R.id.btRxBuffer)
    Button mBtRxBuffer;
    @BindView(R.id.btRxTime)
    Button mBtRxTime;
    @BindView(R.id.btRxThread2)
    Button mBtRxThread2;

    private int oldValue = 0;
    private int newValue = 0;
    private StringBuffer mBuffer = new StringBuffer();
    private Observable<Integer> observable;
    private Observer<Integer> observer;
    private boolean flag = false;
    private int i = 0;
    private Disposable mDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        ButterKnife.bind(this);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @OnClick({R.id.btRxJava, R.id.btRxAndroid, btRxThread, R.id.btRxFlatMap,
            R.id.btRxZip, R.id.btRxOOM, R.id.btRxFlowable, R.id.btRxInterval,
            R.id.tvRxJavaResult, R.id.btRxFlowableRequest, R.id.btRxDistinct,
            R.id.btRxBuffer, R.id.btRxTime, R.id.btRxThread2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvRxJavaResult:
                onBackPressed();
                finish();
                break;
            case R.id.btRxThread2:
                btRxThread();
                break;
            case R.id.btRxTime:
                btRxTime();
                break;
            case R.id.btRxBuffer:
                btRxBuffer();
                break;
            case R.id.btRxDistinct:
                btRxDistinct();
                break;
            case R.id.btRxJava:
                mBuffer.append("start  \n");
                theRxJava();
                break;
            case R.id.btRxAndroid:
                theRxAndroid();
//                observable.subscribe(observer);
                break;
            case btRxThread:
                //可观察对象（被观察者）通常运行在子线程（默认主线程）subscribeOn（Schedulers.newThread()）或subscribeOn(Schedulers.io())
                //观察者运行在主线程observeOn(AndroidSchedulers.mainThread())
                observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
                observable.subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
                break;
            case R.id.btRxFlatMap:
                i++;
                int position = i % 3;
                checkesRx(position);
                break;
            case R.id.btRxZip:
                rxJavaZip();
                break;
            case R.id.btRxOOM:
                rxJavaOOM();
                break;
            case R.id.btRxFlowable:
                rxJavaFlowable();
                break;
            case R.id.btRxInterval:
                rxFlowableInterval();
                break;
            case R.id.btRxFlowableRequest:
                /**
                 * 同步的时候（在同一个线程中，不加subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())）
                 * 下游（observe）调用request(n)就会直接改变上游（observable）中的requested的值，多次调用便会叠加这个值，
                 * 而上游每发送一个事件之后便会去减少这个值，当这个值减少至0的时候，如果继续发送事件便会抛异常。
                 * 也就是说正常应用的时候下游（observe）调用request决定上游（observable）发送onNext多少事件。
                 *
                 * 异步的时候（加subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())），因为缓存的缘故，
                 * 下游在一开始就在内部调用了request(128)去设置了上游中的值，因此即使下游没有调用request()，上游也能发送128个事件
                 * 下游每消费完缓存中的128个事件便会自动触发内部的request()去设置上游的requested的值
                 */
                rxJavaFlowableRequest();
                break;
        }
    }

    private void btRxThread(){
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                logTag("观察对象所在的线程：" + Thread.currentThread().getName());
                e.onNext(1);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.newThread()).subscribeOn(Schedulers.io())
//        .observeOn(Schedulers.io()).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                logTag("After observeOn(io)，Current thread is " + Thread.currentThread().getName() +
//                        "\n" + "integer ===" + integer);
//            }
//        })
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                logTag("After observeOn(mainThread)，Current thread is " + Thread.currentThread().getName() +
                        "\n" + "integer ===" + integer);
            }
        })
        .observeOn(Schedulers.newThread()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                logTag("After observeOn(newThread)，Current thread is " + Thread.currentThread().getName() +
                        "\n" + "integer ===" + integer);
            }
        })

        ;
    }

    private void btRxTime() {
        Observable.timer(1, TimeUnit.SECONDS)
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        logTag("timer :" + aLong + "  at  " + getDate() + "\n");
                    }
                });
    }

    private String getDate() {
        /**
         * yyyy年MM月dd日 HH:mm:ss → 2017年09月05日 15:47:27。    yyyy-MM-dd HH:mm:ss → 2017-09-05 15:48:55
         * yyyy年MM月dd日 HH时mm分ss秒 → 2017年09月05日 15时52分22秒      yyyy年MM月 → 2017年09月
         * MM月dd日 → 09月05日        HH时mm分ss秒 → 15时57分14秒
         */
        String str = new SimpleDateFormat("HH时mm分ss秒").format(new Date(System.currentTimeMillis()));
        return str;
    }

    private void btRxBuffer() {
        Observable.just(1, 2, 3, 1, 4, 5, 6, 9, 15, 22).buffer(4, 3).subscribe(new Consumer<List<Integer>>() {
            @Override
            public void accept(List<Integer> integers) throws Exception {
                int a = integers.size();
                logTag("integers.size() =============" + a);
                for (int j = 0; j < a; j++) {
                    logTag("integers.get(" + j + "):" + integers.get(j));
                }
            }
        });
    }

    private void btRxDistinct() {//去重复
        Observable.just(1, 2, 6, 3, 2, 1, 4, 5, 7).distinct()
                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        logTag("btRxDistinct←  →integer ===" + integer);
                    }
                });
    }

    private void rxJavaFlowableRequest() {
        Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
//                for (int j = 0; j < 10; j++) {
//                    e.onNext(j);
//                    logTag("发送第  " + j + "  个数据");
//                }
                logTag("Current requestCount ===" + e.requested());

            }
        }, BackpressureStrategy.DROP)
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        sub = s;
                        logTag("onSubscribe");
                        s.request(1000);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        logTag("onNext←  →" + integer);
                    }

                    @Override
                    public void onError(Throwable t) {
                        logTag("onError");
                    }

                    @Override
                    public void onComplete() {
                        logTag("onComplete");
                    }
                });
    }

    Subscription sub;

    private void rxFlowableInterval() {
        Flowable.interval(200, TimeUnit.MILLISECONDS).onBackpressureDrop()
                .observeOn(AndroidSchedulers.mainThread()).subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Long>() {
                    @Override
                    public void onSubscribe(Subscription s) {
                        sub = s;
                        logTag("onSubscribe");
                        s.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Long aLong) {
                        logTag("onNext ===" + aLong);
                        if (aLong > 100) {
                            sub.cancel();
                            logTag("interval is cancel ===" + aLong);
                        }
                    }

                    @Override
                    public void onError(Throwable t) {
                        logTag("onError ===" + t);
                    }

                    @Override
                    public void onComplete() {
                        logTag("onComplete");
                    }
                });
    }

    private void rxJavaFlowable() {//BackpressureStrategy
        Flowable<Integer> send = Flowable.create(new FlowableOnSubscribe<Integer>() {
            @Override
            public void subscribe(FlowableEmitter<Integer> e) throws Exception {
                for (int j = 0; j < 1000; j++) {
                    e.onNext(j);
                    logTag("循环发送的第： " + j + "  个");
                }
                logTag(Thread.currentThread().getName());
                e.onComplete();
            }
            /**BackpressureStrategy参数是用来选择背压,也就是出现上下游流速不均衡的时候应该怎么处理的办法,相当于一个缓存
             * BackpressureStrategy.BUFFER:缓冲，相当于一个无限大的缓存，不调用request，这时和Observable一模一样，注意OOM。
             *                              若是调用request，则只处理request指定的数量，超过的，被丢弃了。
             * BackpressureStrategy.DROP:下降，系统默认缓存128个事件，把0-127这128个事件保存起来, 然后丢弃掉其余的事件。
             *                              当我们request(int)的时候,下游便会处理掉这int个事件, 那么上游水缸中又会重新装满128个事件
             * BackpressureStrategy.ERROR:错误，直接抛出异常：MissingBackpressureException
             * BackpressureStrategy.LATEST:最新的，当request(int)处理完int个事件的时候，直接获取最新的事件，上游之前发生的统统丢掉。
             */
        }, BackpressureStrategy.BUFFER)
                .subscribeOn(Schedulers.newThread())//可观察的（被观察对象）
                .observeOn(AndroidSchedulers.mainThread());//观察者
        //Subscriber：订阅者
        Subscriber receive = new Subscriber<Integer>() {//默认主线程
            @Override
            public void onSubscribe(Subscription s) {
                logTag(Thread.currentThread().getName());
                logTag("onSubscribe");
                /**
                 * 没有下面这行代码，就会抛MissingBackpressureException异常。
                 * 原因：s.request(long)为响应式拉去数据，告诉上游要拉取多少个数据，Long.MAX_VALUE可以理解为无限多个数据，
                 *      这里我们给了数据5，表示，只拉取5个，超出的就抛异常了：MissingBackpressureException。
                 * 但是他有大陷阱大坑：只有当上游正确的实现了如何根据下游的处理能力来发送事件的时候, 才能达到这种效果,
                 *      如果上游根本不管下游的处理能力, 一股脑的瞎他妈发事件, 仍然会产生上下游流速不均衡的问题。就如这里，
                 *      下游只拉取5个，上游无视这个要求，直接给10个，尼玛，这下好了，把下游给撑死了。所以，s.request(long)
                 *      中long值绝对不能小于上游事件发送的数量（能力）
                 *      s.request(5);
                 */
                s.request(180);
                /**
                 * 下游没有调用request, 上游就认为下游没有处理事件的能力, 而这又是一个同步的订阅, 既然下游处理不了,
                 * 那上游不可能一直等待吧, 如果是这样, 万一这两根水管工作在主线程里, 界面不就卡死了吗, 因此只能抛个异常
                 */
            }

            @Override
            public void onNext(Integer integer) {
                logTag("onNext" + "←----→" + integer);
            }

            @Override
            public void onError(Throwable t) {
                logTag("onError ===" + t);
            }

            @Override
            public void onComplete() {
                logTag("onComplete");
            }
        };
        send.subscribe(receive);

    }

    private void rxJavaOOM() {
        Observable observable1 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                /**
                 * 这个操作，分分钟撑爆内存，报警OOM;解决方式有两个
                 * 一是，每发送一个事件后就休眠一下，这样从速度上减少发送事件,包括：
                 *      线程休眠Thread.sleep(int)，sample(int, TimeUnit.SECONDS)。前者效果比后者好。
                 * 二是，满足某种条件后才允许发送，从数量上空时发送事件，包括：
                 *      filter(new Predicate<Integer>()...)
                 */
                for (int j = 1; ; j++) {
                    e.onNext("无限循环发送的第： " + j + "  个");
//                    Thread.sleep(1000);
                }
            }
        }).subscribeOn(Schedulers.newThread())
//                .sample(2, TimeUnit.SECONDS)
                ;
        Observable observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(123);
            }
        }).subscribeOn(Schedulers.newThread());

        Observable.zip(observable1, observable2, new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer i) throws Exception {
                return s + "←----→" + i;
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer o) throws Exception {
                        return o % 100 == 0;
                    }
                })
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        logTag(s);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        logTag("throwable:  " + throwable);
                    }
                });
    }

    private void rxJavaZip() {
        Observable observe01 = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("one");
                e.onNext("two");
                e.onNext("three");
                e.onNext("four");
                e.onNext("five");
                e.onComplete();
            }
        }).observeOn(Schedulers.newThread());

        Observable observe02 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onNext(5);
                e.onComplete();
            }
        }).observeOn(Schedulers.newThread());

        Observable.zip(observe01, observe02, new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) throws Exception {
                return s + "←----→" + integer;
            }
        }).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer() {
            @Override
            public void onSubscribe(Disposable d) {
                logTag("onSubscribe");
            }

            @Override
            public void onNext(Object value) {
                logTag("onNext :  " + value);
            }

            @Override
            public void onError(Throwable e) {
                logTag("onError");
            }

            @Override
            public void onComplete() {
                logTag("onComplete");
            }
        });
    }

    private void checkesRx(int i) {
        switch (i) {
            case 0:
                logTag(i + "----→rxJavaConcatMap");
                rxJavaConcatMap();
                break;
            case 1:
                logTag(i + "----→rxJavaMap");
                rxJavaMap();
                break;
            case 2:
                logTag(i + "----→rxJavaFlatMap");
                rxJavaFlatMap();
                break;
        }
    }

    private void rxJavaConcatMap() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("获取到的value是" + integer);
                }
                return Observable.fromIterable(list).delay(16, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                logTag("输入结果是" + s);
            }
        });
    }

    private void rxJavaFlatMap() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
            }
        }).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                final List<String> list = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    list.add("获取到的value是" + integer);
                }
                return Observable.fromIterable(list).delay(16, TimeUnit.MILLISECONDS);
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                logTag("输入结果是" + s);
            }
        });
    }

    private void rxJavaMap() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e) throws Exception {
                e.onNext("01");
                e.onNext("05");
                e.onNext("08");
                e.onNext("10");
                e.onNext("16");
            }
        }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s.trim());
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                newValue = new Integer(integer).intValue();
                if (oldValue == 0) {
                    Log.i("TAG", "logTag: newValue===" + newValue);
                } else {
                    Log.i("TAG", "logTag: newValue ===" + newValue);
                    Log.i("TAG", "logTag: oldValue ===" + oldValue);
                    Log.i("TAG", "logTag: newValue / oldValue ===" + (float) newValue / (float) oldValue);
                }
                oldValue = newValue;
            }
        });
    }

    private void theRxAndroid() {
        //创建一个上游被观察对象Observable：
        observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onNext(4);
                emitter.onNext(5);
                emitter.onComplete();
                logTag("create的onSubscribe执行了5个onNext");
                logTag(Thread.currentThread().getName());
            }
        });
        //创建一个下游观察者 Observer:
        observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                logTag(Thread.currentThread().getName());
                logTag("onSubscribe");
            }

            @Override
            public void onNext(Integer value) {
                logTag("onNext value === " + value);
            }

            @Override
            public void onError(Throwable e) {
                logTag("onError");
            }

            @Override
            public void onComplete() {
                logTag("onComplete");
            }
        };
        observable.subscribe(observer);
    }


    private void theRxJava() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(1);
                mBuffer.append("Observable emit 1" + "\n");
                mTvRxJavaResult.setText(mBuffer.toString());
                logTag(mBuffer.toString());

                e.onNext(2);
                mBuffer.append("Observable emit 2" + "\n");
                mTvRxJavaResult.setText(mBuffer.toString());
                logTag(mBuffer.toString());

//                e.onComplete();

                e.onNext(3);
                mBuffer.append("Observable emit 3" + "\n");
                mTvRxJavaResult.setText(mBuffer.toString());
                logTag(mBuffer.toString());

                e.onNext(4);
                mBuffer.append("Observable emit 4" + "\n");
                mTvRxJavaResult.setText(mBuffer.toString());
                logTag(mBuffer.toString());

            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;
                mBuffer.append("onSubscribe 是否被拦截: " + d.isDisposed() + "\n");
                mTvRxJavaResult.setText(mBuffer.toString());
                logTag(mBuffer.toString());
            }

            @Override
            public void onNext(Integer value) {
                mBuffer.append("onNext : value : " + value + "\n");
                mTvRxJavaResult.setText(mBuffer.toString());
                logTag(mBuffer.toString());
                i++;
                if (i == 2) {
                    // 在RxJava 2.x 中，新增的Disposable可以做到切断的操作，让Observer观察者不再接收上游事件
                    mDisposable.dispose();
                    mTvRxJavaResult.setText(mBuffer.toString());
                    mBuffer.append("onNext : isDisposable : " + mDisposable.isDisposed() + "\n");
                    logTag(mBuffer.toString());
                }
            }

            @Override
            public void onError(Throwable e) {
                mBuffer.append("onError : value : " + e.getMessage() + "\n");
                mTvRxJavaResult.setText(mBuffer.toString());
                logTag(mBuffer.toString());
            }

            @Override
            public void onComplete() {
                mBuffer.append("onComplete" + "\n");
                mTvRxJavaResult.setText(mBuffer.toString());
                logTag(mBuffer.toString());
            }
        });
    }

    private void logTag(String string) {
        Log.i("TAG", "logTag: string===" + string);
    }

}
