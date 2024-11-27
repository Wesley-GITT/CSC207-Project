package use_case.product.list_my_products;

import entity.MyUser;
import use_case.user.auth.AuthUserDataAccessInterface;

import java.util.Set;

public class ListProductInteractor implements ListProductInputBoundary{

    private AuthUserDataAccessInterface userDataAccessObject;
    private ListProductDataAccessInterface productDataAccessObject;
    private ListProductOutputBoundary listProductPresenter;

    public ListProductInteractor(AuthUserDataAccessInterface userDataAccessObject, ListProductDataAccessInterface productDataAccessObject, ListProductOutputBoundary listProductPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.productDataAccessObject = productDataAccessObject;
        this.listProductPresenter = listProductPresenter;
    }

    @Override
    public void execute(ListProductInputData listProductInputData) {

        final String username = listProductInputData.getUsername();
        final String password = listProductInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            listProductPresenter.prepareFailView("Authentication failed");
            return;
        }

        final MyUser user = userDataAccessObject.get(username, password);
        final Set<Integer> output = productDataAccessObject.list(user.getId());

        ListProductOutputData outputData = new ListProductOutputData(output);
        listProductPresenter.prepareSuccessView(outputData);

    }
}
