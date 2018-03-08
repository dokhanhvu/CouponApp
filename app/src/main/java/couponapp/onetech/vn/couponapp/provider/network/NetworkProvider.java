package couponapp.onetech.vn.couponapp.provider.network;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;

/**
 * Created by igneel on 3/6/2018.
 */

public interface NetworkProvider {

    boolean isNetworkAvailable();

    NetworkProvider setTimeOut(int time, TimeUnit timeUnit);

    <T> T provideApi(String url, Class<T> service);

    <Response> Observable<Response> makeRequest(Observable<Response> observable);
}
