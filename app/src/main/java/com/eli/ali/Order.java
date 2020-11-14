package com.eli.ali;

import android.os.Parcel;
import android.os.Parcelable;

public class Order implements Parcelable {

    public static final Creator<Order> CREATOR = new Creator<Order>() {
        @Override
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        @Override
        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
    private String shopIcon;
    private String shopName;
    private String goodsIcon;
    private String goodsDetail;
    private String goodsExtra;
    private float goodsPrice;
    private int goodsCount;
    /*总价XXX,优惠XXX*/
    private String amountInfo;
    /*实付款XXX*/
    private String payInfo;
    private String orderId;
    private String zfbOrderId;
    private String createTime;
    private String submissionTime;
    private boolean hasDetail;
    private float orderPrice;
    private float pay;

    protected Order(Parcel in) {
        shopIcon = in.readString();
        shopName = in.readString();
        goodsIcon = in.readString();
        goodsDetail = in.readString();
        goodsExtra = in.readString();
        goodsPrice = in.readFloat();
        goodsCount = in.readInt();
        amountInfo = in.readString();
        payInfo = in.readString();
        orderId = in.readString();
        zfbOrderId = in.readString();
        createTime = in.readString();
        submissionTime = in.readString();
        hasDetail = in.readByte() != 0;
        orderPrice = in.readFloat();
        pay = in.readFloat();
    }

    public String getShopIcon() {
        return shopIcon;
    }

    public void setShopIcon(String shopIcon) {
        this.shopIcon = shopIcon;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getGoodsIcon() {
        return goodsIcon;
    }

    public void setGoodsIcon(String goodsIcon) {
        this.goodsIcon = goodsIcon;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getGoodsExtra() {
        return goodsExtra;
    }

    public void setGoodsExtra(String goodsExtra) {
        this.goodsExtra = goodsExtra;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getAmountInfo() {
        return amountInfo;
    }

    public void setAmountInfo(String amountInfo) {
        this.amountInfo = amountInfo;
    }

    public String getPayInfo() {
        return payInfo;
    }

    public void setPayInfo(String payInfo) {
        this.payInfo = payInfo;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getZfbOrderId() {
        return zfbOrderId;
    }

    public void setZfbOrderId(String zfbOrderId) {
        this.zfbOrderId = zfbOrderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSubmissionTime() {
        return submissionTime;
    }

    public void setSubmissionTime(String submissionTime) {
        this.submissionTime = submissionTime;
    }

    public boolean isHasDetail() {
        return hasDetail;
    }

    public void setHasDetail(boolean hasDetail) {
        this.hasDetail = hasDetail;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public float getPay() {
        return pay;
    }

    public void setPay(float pay) {
        this.pay = pay;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shopIcon);
        dest.writeString(shopName);
        dest.writeString(goodsIcon);
        dest.writeString(goodsDetail);
        dest.writeString(goodsExtra);
        dest.writeFloat(goodsPrice);
        dest.writeInt(goodsCount);
        dest.writeString(amountInfo);
        dest.writeString(payInfo);
        dest.writeString(orderId);
        dest.writeString(zfbOrderId);
        dest.writeString(createTime);
        dest.writeString(submissionTime);
        dest.writeByte((byte) (hasDetail ? 1 : 0));
        dest.writeFloat(orderPrice);
        dest.writeFloat(pay);
    }

    @Override
    public String toString() {
        return "Order{" +
                "shopIcon='" + shopIcon + '\'' +
                ", shopName='" + shopName + '\'' +
                ", goodsIcon='" + goodsIcon + '\'' +
                ", goodsDetail='" + goodsDetail + '\'' +
                ", goodsExtra='" + goodsExtra + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsCount=" + goodsCount +
                ", amountInfo='" + amountInfo + '\'' +
                ", payInfo='" + payInfo + '\'' +
                ", orderId='" + orderId + '\'' +
                ", zfbOrderId='" + zfbOrderId + '\'' +
                ", createTime='" + createTime + '\'' +
                ", submissionTime='" + submissionTime + '\'' +
                '}';
    }
}
