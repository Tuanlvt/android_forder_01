package com.example.duong.android_forder_01.ui.listproduct;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;

import com.example.duong.android_forder_01.R;
import com.example.duong.android_forder_01.data.model.Category;
import com.example.duong.android_forder_01.data.model.Product;
import com.example.duong.android_forder_01.data.source.ProductRepository;
import com.example.duong.android_forder_01.data.source.ShoppingCardRepository;
import com.example.duong.android_forder_01.databinding.ActivityListProductBinding;
import com.example.duong.android_forder_01.ui.adapter.ProductAdapter;
import com.example.duong.android_forder_01.ui.home.product.ProductContract;
import com.example.duong.android_forder_01.ui.home.product.ProductPresenter;
import com.example.duong.android_forder_01.ui.productdetail.ProductDetailActivity;
import com.example.duong.android_forder_01.utils.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static com.example.duong.android_forder_01.utils.Const.ID_DOMAIN;
import static com.example.duong.android_forder_01.utils.Const.KeyIntent.EXTRA_ID_CATEGORY;

public class ListProductActivity extends BaseActivity implements ProductContract.View {
    private ProductContract.Presenter mPresenter;
    private List<Product> mProducts = new ArrayList<>();
    private ActivityListProductBinding mBinding;
    private ObservableField<ProductAdapter> mProductAdapter = new ObservableField<>();
    private Category mCategory;

    public static Intent getListProductIntent(Context context, Category category) {
        Intent intent = new Intent(context, ListProductActivity.class);
        intent.putExtra(EXTRA_ID_CATEGORY, category);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_product);
        setPresenter(new ProductPresenter(this, ProductRepository.getInstance(),
            ShoppingCardRepository.getInstance(this), this));
        mPresenter.start();
    }

    @Override
    public void initRecyclerView() {
        mProductAdapter.set(new ProductAdapter(mProducts, this, mPresenter));
    }

    @Override
    public void showProductDetail(Product product) {
        startActivity(ProductDetailActivity.getProductDetailIntent(this, product));
    }

    @Override
    public void showAllProduct(List<Product> list) {
        if (list == null) return;
        mProducts.addAll(list);
        mProductAdapter.get().notifyDataSetChanged();
    }

    @Override
    public void showGetDataError() {
        // TODO show get data error
    }

    @Override
    public void start() {
        mCategory = (Category) getIntent().getSerializableExtra(EXTRA_ID_CATEGORY);
        mPresenter.getCategoryById(ID_DOMAIN, mCategory.getId());
        mBinding.setListProductActivity(this);
        initRecyclerView();
    }

    @Override
    public void setPresenter(ProductContract.Presenter presenter) {
        mPresenter = presenter;
    }

    public ObservableField<ProductAdapter> getProductAdapter() {
        return mProductAdapter;
    }
}
