package com.eli.ali;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BillDetailAct extends AppCompatActivity {

    private static final String TAG = "BillDetailAct";

    private CircleImageView mShopIcon;
    private TextView mShopName;
    private TextView mAmount;
    private TextView mStatus;
    private TextView mPayMethod;
    private TextView mScoreInfo;
    private TextView mDetail;
    private TextView mAddress;
    private TextView mLogistics;
    private TextView mDate;
    private TextView mCateGory;
    private TextView mBillId;
    private TextView mOrderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_detail);

        Bill bill = getIntent().getExtras().getParcelable("bill");

        findViewById(R.id.back_container).setOnClickListener(v -> finish());

        if (bill != null) {
            mShopIcon = findViewById(R.id.shop_icon);
            if (!TextUtils.isEmpty(bill.getShopIconPath())) {
                mShopIcon.setImageBitmap(Utils.getBitmap(this, bill.getShopIconPath()));
            }

            mShopName = findViewById(R.id.shop_name);
            mShopName.setText(bill.getShopName());

            mAmount = findViewById(R.id.amount);
            mAmount.setText(bill.getAmount() + "");

            mStatus = findViewById(R.id.status);
            mStatus.setText(bill.getStatus());

            mPayMethod = findViewById(R.id.pay_method);
            mPayMethod.setText(bill.getPayMethod());

            mDetail = findViewById(R.id.bill_detail);
            mDetail.setText(bill.getGoodsDetail());

            mDate = findViewById(R.id.date);
            mDate.setText(bill.getLongDate());

            mCateGory = findViewById(R.id.category);
            mCateGory.setText(bill.getCategory());

            mBillId = findViewById(R.id.bill_id);
            mBillId.setText(bill.getId());

            mOrderId = findViewById(R.id.order_id);
            mOrderId.setText(bill.getOrderId());

            mScoreInfo = findViewById(R.id.score);
            mAddress = findViewById(R.id.address);
            mLogistics = findViewById(R.id.logistics);

            if (!TextUtils.isEmpty(bill.getScore())) {
                mScoreInfo.setText(bill.getScore());
            } else {
                findViewById(R.id.score_container).setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(bill.getAddress())) {
                mAddress.setText(bill.getAddress());
            } else {
                findViewById(R.id.address_container).setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(bill.getLogistics())) {
                mLogistics.setText(bill.getLogistics());
            } else {
                findViewById(R.id.logistics_container).setVisibility(View.GONE);
            }
        }
    }

    public void onClick(View view) {
        view.setVisibility(View.GONE);
        findViewById(R.id.bill_id_container).setVisibility(View.VISIBLE);
        findViewById(R.id.order_id_container).setVisibility(View.VISIBLE);
    }
}
