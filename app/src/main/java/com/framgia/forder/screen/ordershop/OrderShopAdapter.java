package com.framgia.forder.screen.ordershop;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import com.android.databinding.library.baseAdapters.BR;
import com.framgia.forder.R;
import com.framgia.forder.data.model.Order;
import com.framgia.forder.data.model.OrderDetail;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by levutantuan on 6/1/17.
 */

@SuppressWarnings("DefaultFileTemplate")
public class OrderShopAdapter extends BaseExpandableListAdapter {

    private final Context mContext;
    private List<Order> mOrders = new ArrayList<>();

    public OrderShopAdapter(@NonNull Context context) {
        mContext = context;
        mOrders = new ArrayList<>();
    }

    @Override
    public int getGroupCount() {
        return mOrders == null ? 0 : mOrders.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return getGroup(groupPosition).getOrderDetails().size();
    }

    @Override
    public Order getGroup(int groupPosition) {
        return mOrders.get(groupPosition);
    }

    @Override
    public OrderDetail getChild(int groupPosition, int childPosition) {
        return getGroup(groupPosition).getOrderDetails().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return getGroup(groupPosition).getId();
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return getChild(groupPosition, childPosition).getId();
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
            ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_user_order, null);
        }
        ViewDataBinding mBinding = DataBindingUtil.bind(convertView);
        mBinding.setVariable(BR.viewModel, new ItemGroupOrderViewModel(getGroup(groupPosition)));
        mBinding.executePendingBindings();
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
            View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater layoutInflater =
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.item_product_order, null);
        }
        ViewDataBinding mBinding = DataBindingUtil.bind(convertView);
        mBinding.setVariable(BR.viewModel,
                new ItemChildOrderViewModel(getChild(groupPosition, childPosition)));
        mBinding.executePendingBindings();
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    public void updateData(List<Order> orders) {
        if (orders == null) {
            return;
        }
        mOrders.clear();
        mOrders.addAll(orders);
        notifyDataSetChanged();
    }
}
