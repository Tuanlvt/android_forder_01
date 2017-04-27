package com.framgia.forder.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.framgia.forder.utils.Utils;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by levutantuan on 4/17/17.
 */

public class User implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer mId;
    @SerializedName("name")
    @Expose
    private String mName;
    @SerializedName("email")
    @Expose
    private String mEmail;
    @SerializedName("avatar")
    @Expose
    private CollectionAvatar mAvatar;
    @SerializedName("authentication_token")
    @Expose
    private String mToken;
    @SerializedName("created_at")
    @Expose
    private String mCreatedAt;
    @SerializedName("updated_at")
    @Expose
    private String mUpdatedAt;

    @SerializedName("chatwork_id")
    @Expose
    private String mChatworkId;

    @SerializedName("description")
    @Expose
    private String mDescription;

    @SerializedName("comment")
    @Expose
    private String mComment;
    @Expose
    @SerializedName("product_id")
    private int mProductId;
    protected User(Parcel in) {
        mName = in.readString();
        mEmail = in.readString();
        mAvatar = in.readParcelable(Image.class.getClassLoader());
        mToken = in.readString();
        mCreatedAt = in.readString();
        mUpdatedAt = in.readString();
        mChatworkId = in.readString();
        mDescription = in.readString();
        mProductId = in.readInt();
    }

    public User(Integer id, String name, String email) {
        mId = id;
        mName = name;
        mEmail = email;
    }

    public User(String name, String comment) {
        mName = name;
        mComment = comment;
    }

    public User(Integer id, String name, String comment, int productId) {
        mId = id;
        mName = name;
        mComment = comment;
        mProductId = productId;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mName);
        dest.writeString(mEmail);
        dest.writeParcelable(mAvatar, flags);
        dest.writeString(mToken);
        dest.writeString(mCreatedAt);
        dest.writeString(mUpdatedAt);
        dest.writeString(mChatworkId);
        dest.writeString(mDescription);
        dest.writeInt(mProductId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public Integer getId() {
        return mId;
    }

    public void setId(Integer id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public CollectionAvatar getAvatar() {
        return mAvatar;
    }

    public void setAvatar(CollectionAvatar avatar) {
        mAvatar = avatar;
    }

    public String getToken() {
        return mToken;
    }

    public void setToken(String token) {
        mToken = token;
    }

    public String getCreatedAt() {
        return mCreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        mCreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return mUpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        mUpdatedAt = updatedAt;
    }

    public String getChatworkId() {
        return mChatworkId;
    }

    public void setChatworkId(String chatworkId) {
        mChatworkId = chatworkId;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getFormatDate() {
        return Utils.DateTimeUntils.convertUiFormatToDataFormat(mCreatedAt, Utils.INPUT_TIME_FORMAT,
                Utils.OUTPUT_DATE_FORMAT);
    }

    public String getComment() {
        return mComment;
    }

    public void setComment(String comment) {
        mComment = comment;
    }

    public int getProductId() {
        return mProductId;
    }

    public void setProductId(int productId) {
        mProductId = productId;
    }
}
