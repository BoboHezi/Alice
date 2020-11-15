package com.eli.ali;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.leaf.library.StatusBarUtil;

public class OrderDetailAct extends AppCompatActivity {

    private ImageView shopIcon;
    private TextView shopName;
    private ImageView goodsIcon;
    private TextView goodsTitle;
    private TextView goodsExtra;
    private TextView goodsPrice;
    private TextView goodsCount;
    private TextView orderPrice;
    private TextView orderPayamount;
    private TextView orderId;
    private TextView zfbOrderId;
    private TextView createDate;
    private TextView payDate;
    private TextView deliverDate;
    private TextView submissionDate;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        StatusBarUtil.setTransparentForWindow(this);

        Order order = getIntent().getExtras().getParcelable("order");
        if (order != null) {
            shopIcon = findViewById(R.id.shop_icon);
            shopName = findViewById(R.id.shop_name);
            goodsIcon = findViewById(R.id.goods_icon);
            goodsTitle = findViewById(R.id.goods_title);
            goodsExtra = findViewById(R.id.goods_extra);
            goodsPrice = findViewById(R.id.goods_price);
            goodsCount = findViewById(R.id.goods_count);
            orderPrice = findViewById(R.id.order_price);
            orderPayamount = findViewById(R.id.order_pay_amount);
            orderId = findViewById(R.id.order_id);
            zfbOrderId = findViewById(R.id.zfb_order_id);
            createDate = findViewById(R.id.create_date);
            payDate = findViewById(R.id.pay_date);
            deliverDate = findViewById(R.id.deliver_date);
            submissionDate = findViewById(R.id.submission_date);

            if (!TextUtils.isEmpty(order.getShopIcon())) {
                shopIcon.setImageBitmap(Utils.getBitmap(this, order.getShopIcon()));
            } else {
                shopIcon.setImageResource(R.drawable.order_type_tm);
            }

            if (!TextUtils.isEmpty(order.getGoodsIcon())) {
                goodsIcon.setImageBitmap(Utils.getBitmap(this, order.getGoodsIcon()));
            } else {
                goodsIcon.setImageResource(R.drawable.goods_shortcut_bg);
            }

            shopName.setText(order.getShopName());
            goodsTitle.setText(order.getGoodsDetail());
            goodsExtra.setText(order.getGoodsExtra());
            goodsPrice.setText("¥" + order.getGoodsPrice());
            goodsCount.setText("x" + order.getGoodsCount());
            orderPrice.setText("¥" + order.getOrderPrice());
            orderPayamount.setText("¥" + order.getPay());
            orderId.setText(order.getOrderId());
            zfbOrderId.setText(order.getZfbOrderId());
            createDate.setText(order.getCreateTime());

            if (!TextUtils.isEmpty(order.getSubmissionTime())) {
                submissionDate.setText(order.getSubmissionTime());
            } else {
                findViewById(R.id.submission_date_container).setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(order.getPayTime())) {
                payDate.setText(order.getPayTime());
            } else {
                findViewById(R.id.pay_date_container).setVisibility(View.GONE);
            }

            if (!TextUtils.isEmpty(order.getDeliverTime())) {
                deliverDate.setText(order.getDeliverTime());
            } else {
                findViewById(R.id.deliver_date_container).setVisibility(View.GONE);
            }

            findViewById(R.id.goods_container).setOnClickListener(v -> {
                startActivity(new Intent(OrderDetailAct.this, OverdueGoodsAct.class));
            });
        }
    }

    public void onClick(View view) {
        startActivity(new Intent(OrderDetailAct.this, OverdueGoodsAct.class));
    }
}
