package interface_adapter.product.update;

import interface_adapter.product.view.ProductViewModel;
import use_case.product.update.UpdateProductOutputBoundary;
import use_case.product.update.UpdateProductOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class UpdateProductPresenter implements UpdateProductOutputBoundary {

    private final UpdateProductViewModel updateProductViewModel;
    private final ProductViewModel productViewModel;

    public UpdateProductPresenter(UpdateProductViewModel updateProductViewModel, ProductViewModel productViewModel) {
        this.updateProductViewModel = updateProductViewModel;
        this.productViewModel = productViewModel;
    }

    @Override
    public void prepareSuccessView(UpdateProductOutputData response) {
        UpdateProductState state = updateProductViewModel.getState();
        state.setProductId(response.getProductId());
        updateProductViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final UpdateProductState state = updateProductViewModel.getState();
        state.setUpdateProductError(error);
        updateProductViewModel.firePropertyChanged();
    }
}
