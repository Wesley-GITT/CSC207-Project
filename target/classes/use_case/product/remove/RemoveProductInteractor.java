package use_case.product.remove;

import entity.MyUser;
import java.util.Set;

public class RemoveProductInteractor implements RemoveProductInputBoundary {

    private RemoveProductUserDataAccessInterface userDataAccessObject;
    private RemoveProductOutputBoundary removeProductPresenter;

    public RemoveProductInteractor(RemoveProductUserDataAccessInterface userDataAccessObject, RemoveProductOutputBoundary removeProductPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.removeProductPresenter = removeProductPresenter;
    }

    @Override
    public void execute(RemoveProductInputData removeProductInputData) {

        final String username = removeProductInputData.getUsername();
        final String password = removeProductInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            removeProductPresenter.prepareFailView("Authentication failed");
        } else {
            final Set<Integer> products = removeProductInputData.getProducts();
            final MyUser user = userDataAccessObject.get(username, password);

            userDataAccessObject.save(user);

            RemoveProductOutputData outputData = new RemoveProductOutputData("Successfully removed");
            removeProductPresenter.prepareSuccessView(outputData);
        }
    }
}
