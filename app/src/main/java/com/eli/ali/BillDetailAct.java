package com.eli.ali;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BillDetailAct extends AppCompatActivity {

    private static final String TAG = "BillDetailAct";

    private CircleImageView mShopIcon;
    private TextView mShopName;
    private TextView mAmount;
    private TextView mStatus;
    private TextView mPayMethod;
    private TextView mDetail;
    private TextView mDate;
    private TextView mCateGory;

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
        }
    }
}
