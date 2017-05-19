package com.framgia.forder.screen.shopupdate;

import android.databinding.BaseObservable;
import com.framgia.forder.data.model.ShopManagement;
import com.framgia.forder.utils.navigator.Navigator;

/**
 * Exposes the data to be used in the ShopUpdate screen.
 */

public class ShopUpdateViewModel extends BaseObservable implements ShopUpdateContract.ViewModel {

    private final Navigator mNavigator;
    private ShopUpdateContract.Presenter mPresenter;
    private final ShopManagement mShopManagement;

    ShopUpdateViewModel(Navigator navigator, ShopManagement shopManagement) {
        mNavigator = navigator;
        mShopManagement = shopManagement;
    }

    @Override
    public void onStart() {
        mPresenter.onStart();
    }

    @Override
    public void onStop() {
        mPresenter.onStop();
    }

    @Override
    public void setPresenter(ShopUpdateContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public String getShopName() {
        if (mShopManagement.getShop() != null) {
            return mShopManagement.getShop().getName();
        }
        return "";
    }

    public String getShopDescription() {
        if (mShopManagement.getShop() != null) {
            mShopManagement.getShop().getDescription();
        }
        return "";
    }

    public String getTimeAutoClose() {
        if (mShopManagement.getShop() != null) {
            mShopManagement.getShop().getTimeAutoClose();
        }
        return "";
    }

    public String getTimeAutoReject() {
        if (mShopManagement.getShop() != null) {
            mShopManagement.getShop().getTimeAutoReject();
        }
        return "";
    }

    public String getShopImage() {
        if (mShopManagement.getShop() != null
                && mShopManagement.getShop().getCoverImage() != null
                && mShopManagement.getShop().getCoverImage().getImage() != null) {
            return mShopManagement.getShop().getCoverImage().getImage().getUrl();
        }
        return "";
    }

    public String getTimeOpenShop() {
        if (mShopManagement.getShop() != null) {
            return mShopManagement.getShop().getTimeOpenShop();
        }
        return "";
    }

    public String getShopAvatar() {
        if (mShopManagement.getShop() != null
                && mShopManagement.getShop().getCollectionAvatar() != null
                && mShopManagement.getShop().getCollectionAvatar().getImage() != null) {
            return mShopManagement.getShop().getCollectionAvatar().getImage().getUrl();
        }
        return "";
    }
}
