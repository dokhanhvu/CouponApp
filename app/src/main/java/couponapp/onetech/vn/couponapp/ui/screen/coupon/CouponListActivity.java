package couponapp.onetech.vn.couponapp.ui.screen.coupon;

import android.app.Dialog;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import couponapp.onetech.vn.couponapp.R;
import couponapp.onetech.vn.couponapp.app.CouponApplication;
import couponapp.onetech.vn.couponapp.data.model.Coupon;
import couponapp.onetech.vn.couponapp.di.component.ActivityComponent;
import couponapp.onetech.vn.couponapp.di.component.DaggerActivityComponent;
import couponapp.onetech.vn.couponapp.di.module.ActivityModule;
import me.relex.circleindicator.CircleIndicator;

public class CouponListActivity extends AppCompatActivity implements ICouponContract.ICouponView {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.indicator)
    CircleIndicator indicator;

    private static final String TAG = "CouponListActivity";

    private ActivityComponent activityComponent;

    private FragmentsPagerAdapter fragmentsPagerAdapter;

    FragmentManager fragmentManager;

    @Inject
    protected CouponListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coupon_list);
        ButterKnife.bind(this);
        fragmentManager = getSupportFragmentManager();
        activityComponent = getActivityComponent();
        activityComponent.inject(this);
        presenter.attachView((ICouponContract.ICouponView) this);
        presenter.getCoupons();
    }

    public ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            setUpInject();
        }
        return activityComponent;
    }

    private void setUpInject() {
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .applicationComponent(((CouponApplication) getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    public void getCouponSuccessfully(List<Coupon> coupons) {
        List<CouponFragment> fragmentList = new ArrayList<>();
        for (Coupon coupon: coupons) {
            fragmentList.add(CouponFragment.newInstance(coupon));
        }
        //fragmentList.add(CouponFragment.newInstance(coupons.get(0)));
        fragmentsPagerAdapter = new FragmentsPagerAdapter(fragmentManager, fragmentList);
        viewPager.setAdapter(fragmentsPagerAdapter);
        indicator.setViewPager(viewPager);
        Log.d(TAG, "getCouponSuccessfully: ");
    }

    @Override
    public void getCouponFailed(Throwable throwable) {

    }

    @Override
    public void noInternet() {

    }

    @Override
    public void showProgressBar() {

    }

    @Override
    public void stopProgressBar() {

    }

    public void onClickPageItem(Coupon coupon){
        Dialog dialog = new DetailDialog(this, coupon);
        dialog.show();
    }
}
