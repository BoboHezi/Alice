package com.eli.ali;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.OrderHolder> {

    private Context mContext;

    private List<Order> mOrders;

    public OrdersAdapter(Context context, List<Order> orders) {
        mContext = context;
        mOrders = orders;
    }

    @NonNull
    @Override
    public OrderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new OrderHolder(LayoutInflater.from(mContext).
                inflate(R.layout.order_item_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull OrderHolder holder, int position) {
        Order order = mOrders.get(position);
        if (order == null) {
            return;
        }
        if (!TextUtils.isEmpty(order.getShopIcon())) {
            holder.orderTypeIcon.setImageBitmap(Utils.getBitmap(mContext, order.getShopIcon()));
        } else {
            holder.orderTypeIcon.setImageResource(R.drawable.order_type_tm);
        }

        if (!TextUtils.isEmpty(order.getGoodsIcon())) {
            holder.goodsIcon.setImageBitmap(Utils.getBitmap(mContext, order.getGoodsIcon()));
        } else {
            holder.goodsIcon.setImageResource(R.drawable.goods_shortcut_bg);
        }

        holder.itemView.setOnClickListener(!order.isHasDetail() ? null : view -> {
            Intent intent = new Intent(mContext, OrderDetailAct.class);

            Bundle bundle = new Bundle();
            bundle.putParcelable("order", order);
            intent.putExtras(bundle);

            mContext.startActivity(intent);
        });

        holder.shopName.setText(order.getShopName());
        holder.goodsTitle.setText(order.getGoodsDetail());
        holder.goodsExtra.setText(order.getGoodsExtra());
        holder.goodsPrices.setText("¥" + order.getGoodsPrice());
        holder.goodsCount.setText("x" + order.getGoodsCount());
        holder.amountInfo.setText(order.getAmountInfo());
        holder.payInfo.setText(order.getPayInfo());
    }

    @Override
    public int getItemCount() {
        return mOrders != null ? mOrders.size() : 0;
    }

    class OrderHolder extends RecyclerView.ViewHolder {

        ImageView orderTypeIcon;
        TextView shopName;
        ImageView goodsIcon;
        TextView goodsTitle;
        TextView goodsExtra;
        TextView goodsPrices;
        TextView goodsCount;
        TextView amountInfo;
        TextView payInfo;

        public OrderHolder(@NonNull View itemView) {
            super(itemView);
            orderTypeIcon = itemView.findViewById(R.id.icon_order_type);
            shopName = itemView.findViewById(R.id.shop_name);
            goodsIcon = itemView.findViewById(R.id.goods_icon);
            goodsTitle = itemView.findViewById(R.id.goods_title);
            goodsExtra = itemView.findViewById(R.id.goods_extra);
            goodsPrices = itemView.findViewById(R.id.goods_price);
            goodsCount = itemView.findViewById(R.id.goods_count);
            amountInfo = itemView.findViewById(R.id.order_amount_info);
            payInfo = itemView.findViewById(R.id.order_pay_info);
        }
    }
}
