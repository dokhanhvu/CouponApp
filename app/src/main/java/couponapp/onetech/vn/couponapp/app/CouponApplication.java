package couponapp.onetech.vn.couponapp.app;

import android.app.Application;

import couponapp.onetech.vn.couponapp.R;
import couponapp.onetech.vn.couponapp.di.component.ApplicationComponent;
import couponapp.onetech.vn.couponapp.di.component.DaggerApplicationComponent;
import couponapp.onetech.vn.couponapp.di.module.ApplicationModule;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by igneel on 3/6/2018.
 */

public class CouponApplication extends Application{

    private static CouponApplication instance;

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        setupFontSize();
    }

    public ApplicationComponent getApplicationComponent() {
        if (mApplicationComponent == null) {
            setupApplicationComponent();
        }
        return mApplicationComponent;
    }

    public static CouponApplication getInstance() {
        return instance;
    }

    protected void setupApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    private void setupFontSize() {
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Roboto-Light.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }

}
