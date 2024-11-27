package use_case.product.list_my_products;

import entity.MyUser;
import use_case.user.auth.AuthUserDataAccessInterface;

import java.util.Set;

public class ListMyProductInteractor implements ListMyProductInputBoundary {

    private AuthUserDataAccessInterface userDataAccessObject;
    private ListMyProductDataAccessInterface productDataAccessObject;
    private ListMyProductOutputBoundary listProductPresenter;

    public ListMyProductInteractor(AuthUserDataAccessInterface userDataAccessObject, ListMyProductDataAccessInterface productDataAccessObject, ListMyProductOutputBoundary listProductPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.productDataAccessObject = productDataAccessObject;
        this.listProductPresenter = listProductPresenter;
    }

    @Override
    public void execute(ListMyProductInputData listMyProductInputData) {

        final String username = listMyProductInputData.getUsername();
        final String password = listMyProductInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            listProductPresenter.prepareFailView("Authentication failed");
            return;
        }

        final MyUser user = userDataAccessObject.get(username, password);
        final Set<Integer> output = productDataAccessObject.listByUserId(user.getId());

        ListMyProductOutputData outputData = new ListMyProductOutputData(output);
        listProductPresenter.prepareSuccessView(outputData);
    }
}
