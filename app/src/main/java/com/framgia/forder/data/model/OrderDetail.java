package com.framgia.forder.data.model;

import android.annotation.SuppressLint;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import static com.framgia.forder.utils.Constant.FORMAT_PRICE;
import static com.framgia.forder.utils.Constant.UNIT_MONEY;

public class OrderDetail {
    @Expose
    @SerializedName("id")
    private int mId;
    @Expose
    @SerializedName("shop_id")
    private int mShopId;
    @Expose
    @SerializedName("product")
    private Product mProduct;
    @Expose
    @SerializedName("quantity")
    private int mQuantity;
    @Expose
    @SerializedName("price")
    private double mPrice;
    @Expose
    @SerializedName("notes")
    private String mNotes;
    @Expose
    @SerializedName("user_id")
    private int mUserId;
    @Expose
    @SerializedName("product_id")
    private int mProductId;
    @Expose
    @SerializedName("created_at")
    private String mTimeCreateOrder;
    @Expose
    @SerializedName("status")
    private String mStatusOrder;
    //Todo edit later
    private int mStatus;
    //Todo edit later
    private boolean mCheckBoxStatus;

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public void setQuantity(int quantity) {
        mQuantity = quantity;
    }

    public Product getProduct() {
        return mProduct;
    }

    public void setProduct(Product product) {
        mProduct = product;
    }

    //Todo edit later
    public int getStatus() {
        return mStatus;
    }

    //Todo edit later
    public void setStatus(int status) {
        mStatus = status;
    }

    public String getStatusOrder() {
        return mStatusOrder;
    }

    public void setStatusOrder(String statusOrder) {
        mStatusOrder = statusOrder;
    }

    public double getPrice() {
        return mPrice;
    }

    public void setPrice(double price) {
        mPrice = price;
    }

    public String getNotes() {
        return mNotes;
    }

    public void setNotes(String notes) {
        mNotes = notes;
    }

    public int getUserId() {
        return mUserId;
    }

    public void setUserId(int userId) {
        mUserId = userId;
    }

    public String getTimeCreateOrder() {
        return mTimeCreateOrder;
    }

    public int getShopId() {
        return mShopId;
    }

    public void setShopId(int shopId) {
        mShopId = shopId;
    }

    public void setTimeCreateOrder(String timeCreateOrder) {
        mTimeCreateOrder = timeCreateOrder;
    }

    public int getProductId() {
        return mProductId;
    }

    public void setProductId(int productId) {
        mProductId = productId;
    }

    //Todo edit later
    public boolean isCheckBoxStatus() {
        return mCheckBoxStatus;
    }

    @SuppressLint("DefaultLocale")
    public String getFormatTotalPrice() {
        return String.format(FORMAT_PRICE, mPrice) + UNIT_MONEY;
    }
}
