package couponapp.onetech.vn.couponapp.ui.screen.coupon.data.local;

import java.util.List;

import javax.inject.Inject;

import couponapp.onetech.vn.couponapp.data.model.BaseEntity;
import couponapp.onetech.vn.couponapp.data.model.Coupon;
import couponapp.onetech.vn.couponapp.ui.screen.coupon.data.CouponDataSource;
import io.reactivex.Observable;

/**
 * Created by igneel on 3/7/2018.
 */

public class CouponLocal implements CouponDataSource {

    // ORM (realm, GreenDAO, RoomData...)


    @Inject
    public CouponLocal() {
    }

    @Override
    public Observable<BaseEntity<List<Coupon>>> getCoupons() {
        throw new UnsupportedOperationException("getCoupons is not used in local now");
    }
}
