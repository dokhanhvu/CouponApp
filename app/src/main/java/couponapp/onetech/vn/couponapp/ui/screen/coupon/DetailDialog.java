package couponapp.onetech.vn.couponapp.ui.screen.coupon;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindColor;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import couponapp.onetech.vn.couponapp.R;
import couponapp.onetech.vn.couponapp.data.model.Coupon;
import couponapp.onetech.vn.couponapp.ui.screen.coupon.CouponListActivity;
import lt.neworld.spanner.Spanner;

import static lt.neworld.spanner.Spans.background;
import static lt.neworld.spanner.Spans.foreground;

/**
 * Created by igneel on 3/7/2018.
 */

public class DetailDialog extends Dialog {

    @BindView(R.id.btn_cancel)
    Button btnCancel;

    @BindView(R.id.btn_back)
    Button btnBack;

    @BindView(R.id.btn_friend)
    Button btnFriend;

    @BindView(R.id.btn_sms)
    Button btnSms;

    @BindView(R.id.btn_chat)
    Button btnChat;

    @BindView(R.id.tv_name)
    TextView tvName;

    @BindView(R.id.tv_shop_name)
    TextView tvShopName;

    @BindView(R.id.tv_content)
    TextView tvContent;

    @BindView(R.id.tv_detail)
    TextView tvDetail;

    @BindView(R.id.tv_campaign)
    TextView tvCampaign;

    @BindView(R.id.tv_deal)
    TextView tvDeal;

    private Coupon coupon;

    public DetailDialog(@NonNull Context context, Coupon coupon) {
        super(context);
        this.coupon = coupon;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_coupon_detail);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = getWindow();
        if (window != null) {
            lp.copyFrom(window.getAttributes());
            lp.width = WindowManager.LayoutParams.MATCH_PARENT;
            lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
            lp.horizontalMargin = 20;
            window.setAttributes(lp);
        }
        bind();
    }

    @BindColor(R.color.colorCinnabar)
    int campaignColor;

    private void bind()
    {
        ButterKnife.bind(this);
        tvName.setText(coupon.getName());
        tvShopName.setText(coupon.getShopName());
        tvContent.setText(coupon.getContent());
        tvDetail.setText(coupon.getDetail());
        tvCampaign.setText(new Spanner()
                .append(coupon.getStartDate() + " - " + coupon.getEndDate(), foreground(campaignColor)));
        tvDeal.setText(new Spanner()
                .append("-" + coupon.getDeal() + "%", foreground(campaignColor)));

    }

    @OnClick({R.id.btn_cancel, R.id.btn_back, R.id.btn_chat, R.id.btn_friend, R.id.btn_sms})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
            case R.id.btn_back:
                dismiss();
                break;
            case R.id.btn_chat:
                Toast.makeText(getContext(),"Send via chat",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_friend:
                Toast.makeText(getContext(),"Send to friend",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_sms:
                Toast.makeText(getContext(),"Send via sms",Toast.LENGTH_SHORT).show();
                break;


        }
    }
}
