package bonc.demopractice_allkinsoff.rx_java;

import android.content.Context;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by chen1 on 2017/8/31.
 */

public class retrofitProvider {
    private static final String BaseUrl = "https://api.douban.com/";

    public static Retrofit createSend(){
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.connectTimeout(10, TimeUnit.SECONDS);
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);

        return new Retrofit.Builder().baseUrl(BaseUrl).client(builder.build())
                                .addConverterFactory(GsonConverterFactory.create())
                                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
    }


    public static void sendRequest(final Context mContext){
        Retrofit retrofit = createSend();
        final HttpApi api = retrofit.create(HttpApi.class);
        api.login(new LoginRequest()).subscribeOn(Schedulers.io())//在IO线程进行网络请求
           .observeOn(AndroidSchedulers.mainThread())//回到主线程去处理请求结果
                .subscribe(new Observer<LoginResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginResponse value) {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, "Login Opration Failed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(mContext, "Login Opration Successed", Toast.LENGTH_SHORT).show();
                    }
                }
        );

        api.login(new LoginRequest()).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LoginResponse>() {
                    @Override
                    public void accept(LoginResponse loginResponse) throws Exception {
                        Toast.makeText(mContext, "egister Opration Successed", Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, "egister Opration Failed", Toast.LENGTH_SHORT).show();
                    }
                });

        api.resgister(new RegisterRequest()).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<RegisterResponse>() {
                    @Override
                    public void accept(RegisterResponse registerResponse) throws Exception {
                        Toast.makeText(mContext, "egister Opration Successed", Toast.LENGTH_SHORT).show();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(mContext, "egister Opration Failed", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
