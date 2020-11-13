package com.eli.ali;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BillsAdapter extends RecyclerView.Adapter<BillsAdapter.BillViewHolder> {

    private List<Bill> mBills;

    private Context mContext;

    private AssetManager mAssetManager;

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
            Bitmap iconBitmap = getBitmap(bill.getShopIconPath());
            if (iconBitmap != null) {
                holder.shopIcon.setImageBitmap(iconBitmap);
            }
        }
        holder.shopName.setText(bill.getShopName());
        holder.category.setText(bill.getCategory());
        holder.date.setText(bill.getCreateTime());
        holder.amount.setText(bill.getAmount() + "");
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

    private Bitmap getBitmap(String path) {
        if (mAssetManager == null) {
            mAssetManager = mContext.getAssets();
        }
        InputStream inputStream = null;
        try {
            inputStream = mAssetManager.open(path);
        } catch (IOException e) {
        }
        if (inputStream != null) {
            return BitmapFactory.decodeStream(inputStream);
        }

        return null;
    }
}
