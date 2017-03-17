package com.example.duong.android_forder_01.ui.home.product;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.duong.android_forder_01.data.model.Product;
import com.example.duong.android_forder_01.data.model.Shop;
import com.example.duong.android_forder_01.data.source.DataSource;
import com.example.duong.android_forder_01.data.source.GetDataCallback;
import com.example.duong.android_forder_01.data.source.ShoppingCardDataSource;

import java.util.List;

import static com.example.duong.android_forder_01.utils.SharedPreferencesUtils.getCurrentDomain;

public class ProductPresenter implements ProductContract.Presenter {
    private ProductContract.View mProductView;
    private DataSource mDataRepository;
    private ShoppingCardDataSource mShoppingCardDataSource;
    private Context mContext;

    public ProductPresenter(@NonNull ProductContract.View productView,
                            DataSource dataRepository, ShoppingCardDataSource
                                shoppingCardDataSource, Context context) {
        mProductView = productView;
        mProductView.setPresenter(this);
        mDataRepository = dataRepository;
        mShoppingCardDataSource = shoppingCardDataSource;
        mContext = context;
    }

    @Override
    public void start() {
        mProductView.start();
    }

    @Override
    public void openShopDetail(Shop shop) {
    }

    @Override
    public void openProductDetail(Product product) {
        mProductView.showProductDetail(product);
    }

    @Override
    public void addShoppingCard(Product product) {
        mShoppingCardDataSource.addShoppingCardItem(product, getCurrentDomain(mContext).getId());
    }

    @Override
    public void getAllProduct(int idDOmain) {
        mDataRepository.getDatas(idDOmain, new GetDataCallback<Product>() {
            @Override
            public void onLoaded(List<Product> datas) {
                mProductView.showAllProduct(datas);
            }

            @Override
            public void onNotAvailable() {
                mProductView.showGetDataError();
            }
        });
    }

    @Override
    public void getCategoryById(int idCategory) {
        mDataRepository.getCategoryById(idCategory, new GetDataCallback<Product>() {
            @Override
            public void onLoaded(List<Product> datas) {
                mProductView.showAllProduct(datas);
            }

            @Override
            public void onNotAvailable() {
                mProductView.showGetDataError();
            }
        });
    }
}