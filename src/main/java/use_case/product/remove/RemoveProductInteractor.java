package use_case.product.remove;

import entity.MyUser;
import entity.Product;
import use_case.user.auth.AuthUserDataAccessInterface;


public class RemoveProductInteractor implements RemoveProductInputBoundary {

    private final AuthUserDataAccessInterface userDataAccessObject;
    private final RemoveProductDataAccessInterface productDataAccessObject;
    private final RemoveProductOutputBoundary removeProductPresenter;

    public RemoveProductInteractor(AuthUserDataAccessInterface userDataAccessObject, RemoveProductDataAccessInterface productDataAccessObject, RemoveProductOutputBoundary removeProductPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.productDataAccessObject = productDataAccessObject;
        this.removeProductPresenter = removeProductPresenter;
    }

    @Override
    public void execute(RemoveProductInputData removeProductInputData) {

        final String username = removeProductInputData.getUsername();
        final String password = removeProductInputData.getPassword();
        final int productId = removeProductInputData.getProductId();

        if (!productDataAccessObject.exist(productId)) {
            removeProductPresenter.prepareFailView("Product with ID `" + productId + "` does not exist");
            return;
        }

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            removeProductPresenter.prepareFailView("Authentication failed");
            return;
        }

        final MyUser user = userDataAccessObject.get(username, password);
        final Product product = productDataAccessObject.get(productId);

        if (user.getId() != product.getSellerId()) {
            removeProductPresenter.prepareFailView("Authentication failed");
            return;
        }

        productDataAccessObject.remove(productId);
        RemoveProductOutputData outputData = new RemoveProductOutputData(productId);
        removeProductPresenter.prepareSuccessView(outputData);

    }
}
