package couponapp.onetech.vn.couponapp.ui.screen.coupon;

import java.util.List;

import couponapp.onetech.vn.couponapp.data.model.Coupon;

/**
 * Created by igneel on 3/7/2018.
 */

public interface ICouponContract {

    interface ICouponView {

        void getCouponSuccessfully(List<Coupon> coupons);

        void getCouponFailed(Throwable throwable);

        void noInternet();

        void showProgressBar();

        void stopProgressBar();

    }

    interface IOCouponPresenter {

        void getCoupons();
    }
}
