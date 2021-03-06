package com.framgia.forder.data.source;

import com.framgia.forder.data.model.Domain;
import com.framgia.forder.data.model.DomainManagement;
import com.framgia.forder.data.model.User;
import com.framgia.forder.data.source.remote.api.request.AddUserInDomainRequest;
import com.framgia.forder.data.source.remote.api.request.RegisterDomainRequest;
import com.framgia.forder.data.source.remote.api.response.BaseResponse;
import com.framgia.forder.data.source.remote.api.response.ChangeRuleOfUserResponse;
import com.framgia.forder.data.source.remote.api.response.DeleteDomainResponse;
import com.framgia.forder.data.source.remote.api.response.DeleteUserInDomainResponse;
import com.framgia.forder.data.source.remote.api.response.DomainToRequestShopResponse;
import com.framgia.forder.data.source.remote.api.response.EditDomainResponse;
import com.framgia.forder.data.source.remote.api.response.RegisterDomainResponse;
import java.util.List;
import rx.Observable;

/**
 * Created by Age on 4/12/2017.
 */

public class DomainDataSource {
    public interface LocalDataSource {
        User getUser();

        void saveCurrentDomain(Domain domain);

        Domain getCurrentDomain();
    }

    public interface RemoteDataSource {
        Observable<List<Domain>> getListDomain(int userId, String userEmail, String userToken);

        Observable<List<DomainManagement>> getListDomainManagement();

        Observable<RegisterDomainResponse> requestRegisterDomain(
                RegisterDomainRequest registerDomainRequest);

        Observable<DeleteUserInDomainResponse> requestDeleteUserInDomain(int domainId, int userId);

        Observable<DeleteDomainResponse> requestDeleteDomain(int domainId);

        Observable<EditDomainResponse> requestEditDdomain(int domainId, String name, String status,
                String idRoomChatwork);

        Observable<List<User>> getListUserInDomain(int domainId);

        Observable<ChangeRuleOfUserResponse> requestChangeRuleOfUserInDomain(int domainId,
                int userId, String role);

        Observable<BaseResponse> requestAddUserInDomain(
                AddUserInDomainRequest addUserInDomainRequest);

        Observable<List<User>> getListUserToAddInDomain(int domainId);

        Observable<List<DomainToRequestShopResponse.DomainToRequest>> getListDomainToRequestShop(
                int shopId);
    }
}
