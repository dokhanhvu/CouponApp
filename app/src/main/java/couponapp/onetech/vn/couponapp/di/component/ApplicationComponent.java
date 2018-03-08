package couponapp.onetech.vn.couponapp.di.component;

import android.app.Application;

import com.google.gson.Gson;

import javax.inject.Singleton;

import couponapp.onetech.vn.couponapp.app.CouponApplication;
import couponapp.onetech.vn.couponapp.di.module.ApplicationModule;
import couponapp.onetech.vn.couponapp.provider.network.DefaultNetworkProvider;
import dagger.Component;
import okhttp3.OkHttpClient;

/**
 * Created by igneel on 3/7/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(CouponApplication myApp);

    Application getApplication();

    OkHttpClient getOkHttpClient();

    DefaultNetworkProvider getDefaultNetworkProvider();

    Gson getGson();

}
