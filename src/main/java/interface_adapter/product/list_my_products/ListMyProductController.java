package interface_adapter.product.list_my_products;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.product.list_my_products.ListMyProductInputBoundary;
import use_case.product.list_my_products.ListMyProductInputData;

/**
 * The controller for the Login Use Case.
 */
public class ListMyProductController {

    private final ListMyProductInputBoundary listMyProductInteractor;
    private final ViewManagerModel viewManagerModel;

    public ListMyProductController(ListMyProductInputBoundary listMyProductInteractor, ViewManagerModel viewManagerModel) {
        this.listMyProductInteractor = listMyProductInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    public void execute() {
        final ViewManagerState storage = viewManagerModel.getState();
        final String username = storage.getUsername();
        final String password = storage.getPassword();
        final ListMyProductInputData listMyProductInputData = new ListMyProductInputData(username, password);
        listMyProductInteractor.execute(listMyProductInputData);
    }
}
