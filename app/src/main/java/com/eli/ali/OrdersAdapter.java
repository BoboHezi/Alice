package com.eli.ali;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

        TextView shop = holder.itemView.findViewById(R.id.shop_name);
        shop.setText(mOrders.get(position).getShopName());
    }

    @Override
    public int getItemCount() {
        return mOrders != null ? mOrders.size() : 0;
    }

    class OrderHolder extends RecyclerView.ViewHolder {

        public OrderHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
