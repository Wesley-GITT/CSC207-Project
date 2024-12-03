package interface_adapter.product.update;

import interface_adapter.product.view.ProductViewModel;
import use_case.product.create.CreateProductOutputBoundary;
import use_case.product.create.CreateProductOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class CreateProductPresenter implements CreateProductOutputBoundary {

    private final UpdateProductViewModel updateProductViewModel;
    private final ProductViewModel productViewModel;

    public CreateProductPresenter(UpdateProductViewModel updateProductViewModel, ProductViewModel productViewModel) {
        this.updateProductViewModel = updateProductViewModel;
        this.productViewModel = productViewModel;
    }

    @Override
    public void prepareFailView(String error) {
        final UpdateProductState state = updateProductViewModel.getState();
        state.setUpdateProductError(error);
        updateProductViewModel.firePropertyChanged();
    }

    @Override
    public void prepareSuccessView(CreateProductOutputData response) {
        UpdateProductState state = updateProductViewModel.getState();
        state.setProductId(response.getProductId());
        updateProductViewModel.firePropertyChanged();
    }
}
