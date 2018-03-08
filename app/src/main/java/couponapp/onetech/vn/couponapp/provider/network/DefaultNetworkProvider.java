package couponapp.onetech.vn.couponapp.provider.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import couponapp.onetech.vn.couponapp.di.qualifier.ApplicationContext;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by igneel on 3/6/2018.
 */

public class DefaultNetworkProvider implements NetworkProvider{

    private static final String TAG = "DefaultNetworkProvider";

    private Context context;
    private Gson gson;
    private OkHttpClient okHttpClient;

    public DefaultNetworkProvider(Context context, OkHttpClient okHttpClient, Gson gson) {
        this.context = context;
        this.okHttpClient = okHttpClient;
        this.gson = gson;
    }

    @Override
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public NetworkProvider setTimeOut(int time, TimeUnit timeUnit) {
        return this;
    }

    @Override
    public <T> T provideApi(String url, Class<T> service) {

        //Set interceptor
        okHttpClient = okHttpClient.newBuilder().addInterceptor(chain -> {
            Request.Builder requestBuilder = chain.request().newBuilder();

            requestBuilder.addHeader("Content-Type", "application/json");

            return chain.proceed(requestBuilder.build());
        }).build();

        Retrofit restAdapter = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // tell to Retrofit need to use RxJava2
                .client(okHttpClient)
                .build();

        return restAdapter.create(service);
    }

    @Override
    public <Response> Observable<Response> makeRequest(Observable<Response> observable) {
        return observable
                .observeOn(Schedulers.computation())
                .onErrorResumeNext(throwable -> {
                    if (!isNetworkAvailable()) {
                        return Observable.error(new Exception("Network is not available"));
                    }
                    return Observable.error(new Exception("error"));
                });
    }
}
