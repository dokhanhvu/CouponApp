package couponapp.onetech.vn.couponapp.ui.screen.coupon;

import javax.inject.Inject;

import couponapp.onetech.vn.couponapp.provider.scheduler.SchedulerProvider;
import couponapp.onetech.vn.couponapp.provider.scheduler.SchedulerProviderImpl;
import couponapp.onetech.vn.couponapp.ui.screen.coupon.data.CouponDataSource;
import couponapp.onetech.vn.couponapp.ui.screen.coupon.data.CouponRepositoryImpl;

/**
 * Created by igneel on 3/7/2018.
 */

public class CouponListPresenter implements ICouponContract.IOCouponPresenter {

    protected CouponDataSource dataSource;
    protected SchedulerProvider schedulerProvider;

    ICouponContract.ICouponView view;

    @Inject
    public CouponListPresenter(CouponRepositoryImpl couponRepository, SchedulerProviderImpl schedulerProvider) {
        this.dataSource = couponRepository;
        this.schedulerProvider = schedulerProvider;
    }

    public void attachView(ICouponContract.ICouponView view) {
        this.view = view;
    }

    @Override
    public void getCoupons() {
        dataSource.getCoupons()
                .compose(schedulerProvider.observableComputationScheduler())
                .doOnSubscribe(disposable -> {
                    //view.showProgressBar();
                })
                .doOnTerminate(() -> {
                    //view.stopProgressBar();
                })
                .subscribe(listBaseEntity -> {
                    view.getCouponSuccessfully(listBaseEntity.getData());
                }, throwable -> {
                    view.getCouponFailed(throwable);
                });
    }
}
