package com.eli.ali;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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

public class BillsAdapter extends RecyclerView.Adapter<BillsAdapter.BillViewHolder> {

    private List<Bill> mBills;

    private Context mContext;

    public BillsAdapter(List<Bill> bills, Context context) {
        mBills = bills;
        mContext = context;
    }

    @NonNull
    @Override
    public BillViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.bill_item_holder, parent, false);
        BillViewHolder holder = new BillViewHolder(view);

        return holder;
    }

    @Override
    public int getItemCount() {
        return mBills != null ? mBills.size() : 0;
    }

    @Override
    public void onBindViewHolder(@NonNull BillViewHolder holder, int position) {
        Bill bill = mBills != null ? mBills.get(position) : null;
        if (bill == null) {
            return;
        }

        if (!TextUtils.isEmpty(bill.getShopIconPath())) {
            Bitmap iconBitmap = Utils.getBitmap(mContext, bill.getShopIconPath());
            if (iconBitmap != null) {
                holder.shopIcon.setImageBitmap(iconBitmap);
            }
        } else {
            holder.shopIcon.setImageResource(R.drawable.def_shop_icon);
        }
        holder.shopName.setText(bill.getShopName());
        holder.category.setText(bill.getCategory());
        holder.date.setText(bill.getShortDate());
        holder.amount.setText(bill.getAmount() + "");

        holder.itemView.setOnClickListener(!bill.isHasDetail() ? null : view -> {
            Intent intent = new Intent(mContext, BillDetailAct.class);

            Bundle bundle = new Bundle();
            bundle.putParcelable("bill", bill);
            intent.putExtras(bundle);

            mContext.startActivity(intent);
        });
    }

    class BillViewHolder extends RecyclerView.ViewHolder {

        View billView;
        ImageView shopIcon;
        TextView shopName;
        TextView category;
        TextView date;
        TextView amount;

        public BillViewHolder(@NonNull View itemView) {
            super(itemView);

            billView = itemView;

            shopIcon = billView.findViewById(R.id.shop_icon);
            shopName = billView.findViewById(R.id.shop_name);
            category = billView.findViewById(R.id.category);
            date = billView.findViewById(R.id.date);
            amount = billView.findViewById(R.id.bill_amount);
        }
    }
}
