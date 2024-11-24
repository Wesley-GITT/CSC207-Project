package use_case.product.list_my_products;

import entity.MyUser;

import java.util.Set;

public class ListProductInteractor implements ListProductInputBoundary{

    private ListProductUserDataAccessInterface userDataAccessObject;
    private ListProductOutputBoundary listProductPresenter;

    public ListProductInteractor(ListProductUserDataAccessInterface userDataAccessObject, ListProductOutputBoundary listProductPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.listProductPresenter = listProductPresenter;
    }

    @Override
    public void execute(ListProductInputData listProductInputData) {

        final String username = listProductInputData.getUsername();
        final String password = listProductInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            listProductPresenter.prepareFailView("Authentication failed");
        }
        else {
            final MyUser user = userDataAccessObject.get(username, password);
            final Set<Integer> products = user.getCartItems();

            userDataAccessObject.save(user);

            ListProductOutputData outputData = new ListProductOutputData(products);
            listProductPresenter.prepareSuccessView(outputData);
        }
    }
}
