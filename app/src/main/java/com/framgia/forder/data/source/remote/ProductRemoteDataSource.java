package com.framgia.forder.data.source.remote;

import com.framgia.forder.data.model.Product;
import com.framgia.forder.data.model.User;
import com.framgia.forder.data.source.ProductDataSource;
import com.framgia.forder.data.source.remote.api.request.CommentRequest;
import com.framgia.forder.data.source.remote.api.request.OrderRequest;
import com.framgia.forder.data.source.remote.api.response.OrderResponse;
import com.framgia.forder.data.source.remote.api.response.ProductResponse;
import com.framgia.forder.data.source.remote.api.service.FOrderApi;
import java.util.ArrayList;
import java.util.List;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Duong on 4/14/2017.
 */

public class ProductRemoteDataSource extends BaseRemoteDataSource
        implements ProductDataSource.RemoteDataSource {

    public ProductRemoteDataSource(FOrderApi api) {
        super(api);
    }

    @Override
    public Observable<List<Product>> getListProduct(int domainId) {
        return mFOrderApi.getListProduct(domainId)
                .flatMap(new Func1<ProductResponse, Observable<List<Product>>>() {
                    @Override
                    public Observable<List<Product>> call(ProductResponse productResponse) {
                        if (productResponse != null) {
                            return Observable.just(productResponse.getListProduct());
                        }
                        return Observable.error(new NullPointerException());
                    }
                });
    }

    @Override
    public Observable<List<Product>> getListProductInShop(int shopId, int domainId) {
        return mFOrderApi.getListProductShop(shopId, domainId)
                .flatMap(new Func1<ProductResponse, Observable<List<Product>>>() {
                    @Override
                    public Observable<List<Product>> call(ProductResponse productResponse) {
                        if (productResponse != null) {
                            return Observable.just(productResponse.getListProduct());
                        }
                        return Observable.error(new NullPointerException());
                    }
                });
    }

    @Override
    public Observable<List<User>> getListCommentInProduct(int productId, int domainId) {
        List<User> users = new ArrayList<>();
        users.add(new User("Trần Đức Quốc", "Rất ngon"));
        users.add(new User("Trần Minh Trí", "Cơm ngon hơn!"));
        users.add(new User("Nguyễn Phúc Huy", "Thích bánh mỳ hơn!"));
        users.add(new User("Nguyễn Tiến Vinh", "Phở ngon"));
        users.add(new User("Trần Đức Quốc", "Rất ngon"));
        users.add(new User("Trần Đức Quốc", "Rất ngon"));
        users.add(new User("Trần Minh Trí", "Cơm ngon hơn!"));
        users.add(new User("Nguyễn Phúc Huy", "Thích bánh mỳ hơn!"));
        users.add(new User("Nguyễn Tiến Vinh", "Phở ngon"));
        return Observable.just(users);
    }

    @Override
    public Observable<User> sendComment(CommentRequest request) {
        User user = new User(request.getIdProduct(), request.getNameUser(), request.getComment(),
                request.getIdProduct());
        return Observable.just(user);
    }

    @Override
    public Observable<Void> orderProduct(OrderRequest orderRequest) {
        return mFOrderApi.orderRequest(orderRequest)
                .flatMap(new Func1<OrderResponse, Observable<Void>>() {
                    @Override
                    public Observable<Void> call(OrderResponse orderResponse) {
                        if (orderResponse != null) {
                            return Observable.just(null);
                        }
                        return Observable.error(new NullPointerException());
                    }
                });
    }
}
