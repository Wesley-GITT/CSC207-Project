package use_case.product.remove;

import entity.MyUser;
import use_case.user.auth.AuthUserDataAccessInterface;


public class RemoveProductInteractor implements RemoveProductInputBoundary {

    private final AuthUserDataAccessInterface userDataAccessObject;
    private final RemoveProductUserDataAccessInterface productDataAccessObject;
    private final RemoveProductOutputBoundary removeProductPresenter;

    public RemoveProductInteractor(AuthUserDataAccessInterface userDataAccessObject, RemoveProductUserDataAccessInterface productDataAccessObject, RemoveProductOutputBoundary removeProductPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.productDataAccessObject = productDataAccessObject;
        this.removeProductPresenter = removeProductPresenter;
    }

    @Override
    public void execute(RemoveProductInputData removeProductInputData) {

        final String username = removeProductInputData.getUsername();
        final String password = removeProductInputData.getPassword();
        final int id = removeProductInputData.getProductId();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            removeProductPresenter.prepareFailView("Authentication failed");
            return;
        }
        final MyUser user = userDataAccessObject.get(username, password);
        if (productDataAccessObject.exist(id)) {
            productDataAccessObject.remove(id);
        }

        RemoveProductOutputData outputData = new RemoveProductOutputData(id);
        removeProductPresenter.prepareSuccessView(outputData);

    }
}
