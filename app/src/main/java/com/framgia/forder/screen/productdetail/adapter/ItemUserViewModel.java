package com.framgia.forder.screen.productdetail.adapter;

import android.databinding.BaseObservable;
import android.view.View;
import com.framgia.forder.data.model.User;
import com.framgia.forder.screen.BaseRecyclerViewAdapter;
import com.framgia.forder.screen.mainpage.product.OrderListener;

/**
 * Created by levutantuan on 4/27/17.
 */

public class ItemUserViewModel extends BaseObservable {

    private User mUser;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> mItemClickListener;

    public ItemUserViewModel(User user,
            BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> listener,
            OrderListener orderListener) {
        mUser = user;
        mItemClickListener = listener;
    }

    public void onAvatarClicked(View view) {
        if (mItemClickListener == null) {
            return;
        }
        mItemClickListener.onItemRecyclerViewClick(mUser);
    }

    public String getComment() {
        return mUser.getComment();
    }

    public String getName() {
        return mUser.getName();
    }

    public String getUserImage() {
        if (mUser != null && mUser.getAvatar() != null && mUser.getAvatar().getImage() != null) {
            return mUser.getAvatar().getImage().getUrl();
        }
        return "";
    }
}
