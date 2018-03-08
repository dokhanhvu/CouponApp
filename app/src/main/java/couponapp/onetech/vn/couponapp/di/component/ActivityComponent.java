package couponapp.onetech.vn.couponapp.di.component;

import couponapp.onetech.vn.couponapp.di.module.ActivityModule;
import couponapp.onetech.vn.couponapp.di.scope.ActivityScope;
import couponapp.onetech.vn.couponapp.ui.screen.coupon.CouponListActivity;
import dagger.Component;

/**
 * Created by igneel on 3/7/2018.
 */

@ActivityScope
@Component(dependencies = {ApplicationComponent.class}, modules = {ActivityModule.class})
public interface ActivityComponent {

    void inject(CouponListActivity couponListActivity);
}
