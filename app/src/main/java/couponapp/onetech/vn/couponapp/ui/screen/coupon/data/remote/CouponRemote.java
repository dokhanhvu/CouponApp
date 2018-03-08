package couponapp.onetech.vn.couponapp.ui.screen.coupon.data.remote;

import java.util.List;

import javax.inject.Inject;

import couponapp.onetech.vn.couponapp.data.model.BaseEntity;
import couponapp.onetech.vn.couponapp.data.model.Coupon;
import couponapp.onetech.vn.couponapp.provider.network.DefaultNetworkProvider;
import couponapp.onetech.vn.couponapp.provider.network.NetworkProvider;
import couponapp.onetech.vn.couponapp.ui.screen.coupon.data.CouponDataSource;
import couponapp.onetech.vn.couponapp.ultis.ApiConst;
import io.reactivex.Observable;

/**
 * Created by igneel on 3/7/2018.
 */

public class CouponRemote implements CouponDataSource {

    private NetworkProvider networkProvider;

    @Inject
    public CouponRemote(DefaultNetworkProvider networkProvider) {
        this.networkProvider = networkProvider;
    }

    @Override
    public Observable<BaseEntity<List<Coupon>>> getCoupons() {
        Observable<BaseEntity<List<Coupon>>> baseEntityObservable = networkProvider.makeRequest(
                networkProvider.provideApi(ApiConst.FIREBASE_TEST_URL, CouponRestService.class)
                        .getCoupons());
        return baseEntityObservable;
    }
}
