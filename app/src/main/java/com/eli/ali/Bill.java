package com.eli.ali;

public class Bill {

    private String shopName;

    private String shopIconPath;

    private float amount;

    private String createTime;

    private String category;

    private boolean hasDetail;

    private String id;

    private String status;

    private String payMethod;

    private String score;

    private String goodsDetail;

    public Bill(String shopName, String shopIconPath,
                float amount, String createTime, String category) {
        this.shopName = shopName;
        this.shopIconPath = shopIconPath;
        this.amount = amount;
        this.createTime = createTime;
        this.category = category;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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
}
