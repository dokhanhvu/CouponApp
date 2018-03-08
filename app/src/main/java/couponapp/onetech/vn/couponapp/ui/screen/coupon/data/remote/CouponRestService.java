package couponapp.onetech.vn.couponapp.ui.screen.coupon.data.remote;

import java.util.List;

import couponapp.onetech.vn.couponapp.data.model.BaseEntity;
import couponapp.onetech.vn.couponapp.data.model.Coupon;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by igneel on 3/7/2018.
 */

public interface CouponRestService {

    @GET("getCoupons.json")
    Observable<BaseEntity<List<Coupon>>> getCoupons();
}
