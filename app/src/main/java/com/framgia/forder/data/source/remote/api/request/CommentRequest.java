package com.framgia.forder.data.source.remote.api.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by levutantuan on 4/27/17.
 */

public class CommentRequest extends BaseRequest {
    @SerializedName("product_id")
    @Expose
    private int mIdProduct;
    @SerializedName("user_id")
    @Expose
    private int mIdUser;
    @SerializedName("name_user")
    @Expose
    private String mNameUser;
    @SerializedName("comment")
    @Expose
    private String mComment;

    public CommentRequest(int idProduct, int idUser, String nameUser, String comment) {
        mIdProduct = idProduct;
        mIdUser = idUser;
        mNameUser = nameUser;
        mComment = comment;
    }

    public CommentRequest() {
    }

    public int getIdProduct() {
        return mIdProduct;
    }

    public void setIdProduct(int idProduct) {
        mIdProduct = idProduct;
    }

    public int getIdUser() {
        return mIdUser;
    }

    public void setIdUser(int idUser) {
        mIdUser = idUser;
    }

    public String getNameUser() {
        return mNameUser;
    }

    public void setNameUser(String nameUser) {
        mNameUser = nameUser;
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }
}
