package couponapp.onetech.vn.couponapp.ui.screen.coupon.data;

import java.util.List;

import javax.inject.Inject;

import couponapp.onetech.vn.couponapp.data.model.BaseEntity;
import couponapp.onetech.vn.couponapp.data.model.Coupon;
import couponapp.onetech.vn.couponapp.ui.screen.coupon.data.local.CouponLocal;
import couponapp.onetech.vn.couponapp.ui.screen.coupon.data.remote.CouponRemote;
import io.reactivex.Observable;

/**
 * Created by igneel on 3/7/2018.
 */

public class CouponRepositoryImpl implements CouponDataSource {

    CouponDataSource couponDataSourceRemote;
    CouponDataSource couponDataSourceLocal;

    @Inject
    public CouponRepositoryImpl(CouponRemote couponDataSourceRemote, CouponLocal couponDataSourceLocal) {
        this.couponDataSourceRemote = couponDataSourceRemote;
        this.couponDataSourceLocal = couponDataSourceLocal;
    }

    @Override
    public Observable<BaseEntity<List<Coupon>>> getCoupons() {
        return couponDataSourceRemote.getCoupons();
    }

}
