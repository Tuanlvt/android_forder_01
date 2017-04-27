package com.framgia.forder.screen.productdetail.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.framgia.forder.R;
import com.framgia.forder.data.model.User;
import com.framgia.forder.databinding.ItemCommentProductBinding;
import com.framgia.forder.screen.BaseRecyclerViewAdapter;
import com.framgia.forder.screen.mainpage.product.OrderListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by levutantuan on 4/26/17.
 */

public class CommentAdapter extends BaseRecyclerViewAdapter<CommentAdapter.ItemViewHolder> {

    private List<User> mUsers;
    private BaseRecyclerViewAdapter.OnRecyclerViewItemClickListener<User> mItemClickListener;
    private OrderListener mOrderListener;

    public CommentAdapter(@NonNull Context context, List<User> users) {
        super(context);
        mUsers = new ArrayList<>();
        mUsers = users;
    }

    @Override
    public CommentAdapter.ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCommentProductBinding binding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                        R.layout.item_comment_product, parent, false);
        return new CommentAdapter.ItemViewHolder(binding, mItemClickListener, mOrderListener);
    }

    @Override
    public void onBindViewHolder(CommentAdapter.ItemViewHolder holder, int position) {
        holder.bind(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setOrderListener(OrderListener listener) {
        mOrderListener = listener;
    }

    public void setItemClickListener(OnRecyclerViewItemClickListener<User> itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    public void updateData(List<User> users) {
        if (users == null) {
            return;
        }
        mUsers.clear();
        mUsers.addAll(users);
        notifyDataSetChanged();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private final OrderListener mOrderListener;
        private ItemCommentProductBinding mBinding;
        private OnRecyclerViewItemClickListener<User> mItemClickListener;

        ItemViewHolder(ItemCommentProductBinding binding,
                OnRecyclerViewItemClickListener<User> listener, OrderListener orderListener) {
            super(binding.getRoot());
            mBinding = binding;
            mItemClickListener = listener;
            mOrderListener = orderListener;
        }

        void bind(User user) {
            mBinding.setViewModel(new ItemUserViewModel(user, mItemClickListener, mOrderListener));
            mBinding.executePendingBindings();
        }
    }
}
