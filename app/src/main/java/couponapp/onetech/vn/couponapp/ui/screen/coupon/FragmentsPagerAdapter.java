package couponapp.onetech.vn.couponapp.ui.screen.coupon;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

public class FragmentsPagerAdapter extends FragmentStatePagerAdapter {

    private List<CouponFragment> fragments;

    public FragmentsPagerAdapter(FragmentManager fm, List<CouponFragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public CouponFragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public float getPageWidth(int position) {
        return super.getPageWidth(position);
    }

}
