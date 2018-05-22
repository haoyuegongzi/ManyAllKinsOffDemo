package bonc.demopractice_allkinsoff.rxjava_integrate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import bonc.demopractice_allkinsoff.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class RxJavaIntegrateActivity extends AppCompatActivity {

    @BindView(R.id.RxJava)
    Button mRxJava;
    @BindView(R.id.tvHttpResult)
    TextView mTvHttpResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_integrate);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.RxJava, R.id.tvHttpResult})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.RxJava:

                break;
            case R.id.tvHttpResult:

                break;
        }
    }

    private void createObserver(){
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d("tag", "onSubscribe");
            }

            @Override
            public void onNext(String s) {
                Log.d("tag", "Item: " + s);
            }

            @Override
            public void onComplete() {
                Log.d("tag", "onComplete");
            }

            @Override
            public void onError(Throwable e) {
                Log.d("tag", "onError");
            }
        };

        Subscriber sub = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {

            }

            @Override
            public void onNext(String o) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        };

        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter e) throws Exception {
                e.onNext("Hello");
                e.onNext("RxJava");
                e.onComplete();
            }
        });
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(observer);
    }

    private void rxJavaRequest(){
        String Url = "http://api.avatardata.cn/MobilePlace/LookUp?key=ec47b85086be4dc8b5d941f5abd37a4e&mobileNumber=13021671512";
        Observable.create(new ObservableOnSubscribe<Response>() {
            @Override
            public void subscribe(ObservableEmitter<Response> e) throws Exception {

            }
        }).map(new Function<Response, MobileAddress>() {
            @Override
            public MobileAddress apply(Response response) throws Exception {
                return null;
            }
        }).observeOn(AndroidSchedulers.mainThread()).doOnNext(new Consumer<MobileAddress>() {
            @Override
            public void accept(MobileAddress mobileAddress) throws Exception {

            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<MobileAddress>() {
            @Override
            public void accept(MobileAddress mobileAddress) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });
    }
}
