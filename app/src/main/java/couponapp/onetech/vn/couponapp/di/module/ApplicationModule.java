package couponapp.onetech.vn.couponapp.di.module;

import android.app.Application;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import couponapp.onetech.vn.couponapp.di.qualifier.ApplicationContext;
import couponapp.onetech.vn.couponapp.provider.network.DefaultNetworkProvider;
import couponapp.onetech.vn.couponapp.ultis.ApiConst;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by igneel on 3/7/2018.
 */

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    public Gson provideGson() {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson;
    }

    @Provides
    OkHttpClient provideDefaultOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //Set timeout
        builder.connectTimeout(ApiConst.DEFAULT_TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        builder.readTimeout(ApiConst.DEFAULT_TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        builder.writeTimeout(ApiConst.DEFAULT_TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);

        //Enable log
        //Enable log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(interceptor);

        return builder.build();
    }

    @Provides
    DefaultNetworkProvider provideDefaultNetworkProvider(@ApplicationContext Context context,
                                                         OkHttpClient okHttpClient,
                                                         Gson gson) {
        return new DefaultNetworkProvider(context, okHttpClient, gson);
    }
}
