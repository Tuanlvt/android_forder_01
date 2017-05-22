package com.framgia.forder.screen.shopupdate;

import android.app.TimePickerDialog;
import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.widget.TimePicker;
import com.framgia.forder.BR;
import com.framgia.forder.R;
import com.framgia.forder.data.model.ShopManagement;
import com.framgia.forder.utils.navigator.Navigator;
import java.util.Calendar;

/**
 * Exposes the data to be used in the ShopUpdate screen.
 */

public class ShopUpdateViewModel extends BaseObservable
        implements ShopUpdateContract.ViewModel, TimePickerDialog.OnTimeSetListener {
    private static final int FLAG_OPEN_TIME = 1;
    private static final int FLAG_REJECT_TIME = 2;

    private final Navigator mNavigator;
    private final Context mContext;
    private ShopUpdateContract.Presenter mPresenter;
    private final ShopManagement mShopManagement;
    private final Calendar mCalendar;
    private boolean isChecked;
    private String mOpenTime;
    private String mAutoRejectTime;
    private boolean isOpenDaily;
    private int mFlag;

    ShopUpdateViewModel(Navigator navigator, Context context, ShopManagement shopManagement) {
        this.mContext = context;
        mNavigator = navigator;
        mShopManagement = shopManagement;
        mCalendar = Calendar.getInstance();
        isChecked = true;
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
@Bindable
    public String getOpenTime() {
        if (mShopManagement.getShop() != null) {
            return mShopManagement.getShop().getTimeOpenShop();
        }
        return "";
    }
@Bindable
    public String getAutoRejectTime() {
        if (mShopManagement.getShop() != null) {
            mShopManagement.getShop().getTimeAutoReject();
        }
        return "";
    }

    @Bindable
    public void setOpenTime(String openTime) {
        mOpenTime = openTime;
    }

    @Bindable
    public void setAutoRejectTime(String autoRejectTime) {
        mAutoRejectTime = autoRejectTime;
    }

    public String getShopImage() {
        if (mShopManagement.getShop() != null
                && mShopManagement.getShop().getCoverImage() != null
                && mShopManagement.getShop().getCoverImage().getImage() != null) {
            return mShopManagement.getShop().getCoverImage().getImage().getUrl();
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

    public void onClickChooseOpenTime() {
        mFlag = FLAG_OPEN_TIME;
        TimePickerDialog time =
                new TimePickerDialog(mContext, this, mCalendar.get(Calendar.HOUR_OF_DAY),
                        mCalendar.get(Calendar.MINUTE), true);
        time.show();
    }

    public void onClickChooseTimeRefused() {
        mFlag = FLAG_REJECT_TIME;
        TimePickerDialog time =
                new TimePickerDialog(mContext, this, mCalendar.get(Calendar.HOUR_OF_DAY),
                        mCalendar.get(Calendar.MINUTE), true);
        time.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        String hourString =
                hourOfDay < 10 ? mContext.getString(R.string.zero) + hourOfDay : "" + hourOfDay;
        String minuteString =
                minute < 10 ? mContext.getString(R.string.zero) + minute : "" + minute;
        if (mFlag == FLAG_OPEN_TIME) {
            mOpenTime = hourString + mContext.getString(R.string.two_dot) + minuteString;
            notifyPropertyChanged(BR.openTime);
        } else {
            mAutoRejectTime = hourString + mContext.getString(R.string.two_dot) + minuteString;
            notifyPropertyChanged(BR.autoRejectTime);
        }
    }
}
