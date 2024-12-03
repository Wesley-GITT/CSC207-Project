package interface_adapter.product.remove;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.product.remove.RemoveProductInputBoundary;
import use_case.product.remove.RemoveProductInputData;

/**
 * The controller for the Login Use Case.
 */
public class RemoveProductController {

    private final RemoveProductInputBoundary removeProductInteractor ;
    private final ViewManagerModel viewManagerModel;

    public RemoveProductController(RemoveProductInputBoundary removeProductInteractor, ViewManagerModel viewManagerModel) {
        this.removeProductInteractor = removeProductInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    public void execute(int productId) {
        final ViewManagerState storage = viewManagerModel.getState();
        final String username = storage.getUsername();
        final String password = storage.getPassword();
        final RemoveProductInputData removeProductInputData = new RemoveProductInputData(username, password, productId);
        removeProductInteractor.execute(removeProductInputData);
    }
}
