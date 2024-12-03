package interface_adapter.product.update;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.product.create.CreateProductInputBoundary;
import use_case.product.create.CreateProductInputData;
import use_case.product.update.UpdateProductInputBoundary;
import use_case.product.update.UpdateProductInputData;

/**
 * The controller for the Login Use Case.
 */
public class UpdateProductController {

    private final UpdateProductInputBoundary updateProductInteractor;
    private final CreateProductInputBoundary createProductInteractor;
    private final ViewManagerModel viewManagerModel;

    public UpdateProductController(UpdateProductInputBoundary updateProductInteractor,
                                   CreateProductInputBoundary createProductInteractor,
                                   ViewManagerModel viewManagerModel) {

        this.updateProductInteractor = updateProductInteractor;
        this.createProductInteractor = createProductInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    public void execute(int productId, String bookCondition, double price, boolean isSold) {
        final ViewManagerState state = viewManagerModel.getState();
        final String username = state.getUsername();
        final String password = state.getPassword();
        final UpdateProductInputData updateProductInputData = new UpdateProductInputData(username, password, productId, bookCondition, price, isSold);
        updateProductInteractor.execute(updateProductInputData);
    }

    public void execute(String bookId, String bookCondition, double price) {
        final ViewManagerState state = viewManagerModel.getState();
        final String username = state.getUsername();
        final String password = state.getPassword();
        final CreateProductInputData createProductInputData = new CreateProductInputData(username, password, bookId, bookCondition, price);
        createProductInteractor.execute(createProductInputData);
    }
}
