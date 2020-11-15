package com.eli.ali;

import android.os.Parcel;
import android.os.Parcelable;


public class Bill implements Parcelable {

    public static final Creator<Bill> CREATOR = new Creator<Bill>() {
        @Override
        public Bill createFromParcel(Parcel in) {
            return new Bill(in);
        }

        @Override
        public Bill[] newArray(int size) {
            return new Bill[size];
        }
    };
    private String shopName;
    private String shopIconPath;
    private float amount;
    private String shortDate;
    private String longDate;
    private String category;
    private boolean hasDetail;
    private String id;
    private String status;
    private String payMethod;
    private String score;
    private String goodsDetail;
    private String address;
    private String logistics;
    private String orderId;
    private String extraId;

    protected Bill(Parcel in) {
        shopName = in.readString();
        shopIconPath = in.readString();
        amount = in.readFloat();
        shortDate = in.readString();
        longDate = in.readString();
        category = in.readString();
        hasDetail = in.readByte() != 0;
        id = in.readString();
        status = in.readString();
        payMethod = in.readString();
        score = in.readString();
        goodsDetail = in.readString();
        address = in.readString();
        logistics = in.readString();
        orderId = in.readString();
        extraId = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopIconPath() {
        return shopIconPath;
    }

    public void setShopIconPath(String shopIconPath) {
        this.shopIconPath = shopIconPath;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getGoodsDetail() {
        return goodsDetail;
    }

    public void setGoodsDetail(String goodsDetail) {
        this.goodsDetail = goodsDetail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogistics() {
        return logistics;
    }

    public void setLogistics(String logistics) {
        this.logistics = logistics;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getExtraId() {
        return extraId;
    }

    public void setExtraId(String extraId) {
        this.extraId = extraId;
    }

    public String getShortDate() {
        return shortDate;
    }

    public void setShortDate(String shortDate) {
        this.shortDate = shortDate;
    }

    public String getLongDate() {
        return longDate;
    }

    public void setLongDate(String longDate) {
        this.longDate = longDate;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isHasDetail() {
        return hasDetail;
    }

    public void setHasDetail(boolean hasDetail) {
        this.hasDetail = hasDetail;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(shopName);
        dest.writeString(shopIconPath);
        dest.writeFloat(amount);
        dest.writeString(shortDate);
        dest.writeString(longDate);
        dest.writeString(category);
        dest.writeByte((byte) (hasDetail ? 1 : 0));
        dest.writeString(id);
        dest.writeString(status);
        dest.writeString(payMethod);
        dest.writeString(score);
        dest.writeString(goodsDetail);
        dest.writeString(address);
        dest.writeString(logistics);
        dest.writeString(orderId);
        dest.writeString(extraId);
    }

    @Override
    public String toString() {
        return "Bill{" +
                "shopName='" + shopName + '\'' +
                ", shopIconPath='" + shopIconPath + '\'' +
                ", amount=" + amount +
                ", longDate='" + longDate + '\'' +
                ", category='" + category + '\'' +
                ", hasDetail=" + hasDetail +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", payMethod='" + payMethod + '\'' +
                ", score='" + score + '\'' +
                ", goodsDetail='" + goodsDetail + '\'' +
                '}';
    }
}
