package couponapp.onetech.vn.couponapp.ui.screen.coupon.data;

import java.util.List;

import couponapp.onetech.vn.couponapp.data.model.BaseEntity;
import couponapp.onetech.vn.couponapp.data.model.Coupon;
import io.reactivex.Observable;

/**
 * Created by igneel on 3/7/2018.
 */

public interface CouponDataSource {

    Observable<BaseEntity<List<Coupon>>> getCoupons();
}
