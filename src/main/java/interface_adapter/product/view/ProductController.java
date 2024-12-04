package interface_adapter.product.view;

import use_case.product.view.ViewProductInputBoundary;
import use_case.product.view.ViewProductInputData;

/**
 * The controller for the Login Use Case.
 */
public class ProductController {

    private final ViewProductInputBoundary viewProductInteractor;

    public ProductController(ViewProductInputBoundary viewProductInteractor) {
        this.viewProductInteractor = viewProductInteractor;
    }

    /**
     * Execute method for ProductController.
     * @param productId productId
     */
    public void execute(int productId) {
        final ViewProductInputData viewProductInputData = new ViewProductInputData(productId);
        viewProductInteractor.execute(viewProductInputData);
    }
}
