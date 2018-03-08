package couponapp.onetech.vn.couponapp.ui.screen.coupon;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import couponapp.onetech.vn.couponapp.R;
import couponapp.onetech.vn.couponapp.data.model.Coupon;
import couponapp.onetech.vn.couponapp.ultis.BundleKeyConst;

/**
 * Created by igneel on 3/7/2018.
 */

public class CouponFragment extends Fragment {

    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.imv_cover)
    ImageView imvCover;
    @BindView(R.id.tv_corner_triangle)
    TextView tvCornerTriangle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.tv_category)
    TextView tvCategory;
    @BindView(R.id.btn_coupon_detail)
    Button btnCouponDetail;

    private static final String TAG = "CouponFragment";

    private Coupon coupon;

    public static CouponFragment newInstance(Coupon coupon) {
        Bundle args = new Bundle();
        args.putSerializable(BundleKeyConst.EXTRA_1, coupon);
        CouponFragment fragment = new CouponFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_coupon, null, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        coupon = (Coupon) getArguments().getSerializable(BundleKeyConst.EXTRA_1);

        Glide.with(this)
                .load(coupon.getCover())
                .into(imvCover);
        tvContent.setText(coupon.getContent());
        tvCornerTriangle.setText("-" + coupon.getDeal() + "%");
        tvName.setText(coupon.getName());
        tvDetail.setText(coupon.getDetail());
        tvCategory.setText(coupon.getCategory());
    }

    @OnClick({R.id.btn_coupon_detail})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_coupon_detail:
                Activity activity = getActivity();
                if (activity instanceof CouponListActivity) {
                    CouponListActivity couponListActivity = (CouponListActivity) activity;
                    couponListActivity.onClickPageItem(coupon);
                }
                break;
        }
    }
}
