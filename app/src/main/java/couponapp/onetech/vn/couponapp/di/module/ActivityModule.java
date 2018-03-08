package couponapp.onetech.vn.couponapp.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import couponapp.onetech.vn.couponapp.di.qualifier.ActivityContext;
import dagger.Module;
import dagger.Provides;

/**
 * Created by igneel on 3/7/2018.
 */

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }
}
