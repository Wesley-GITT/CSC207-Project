package interface_adapter.product.remove;

import interface_adapter.product.list_my_products.ListMyProductState;
import interface_adapter.product.list_my_products.ListMyProductViewModel;
import use_case.product.remove.RemoveProductOutputBoundary;
import use_case.product.remove.RemoveProductOutputData;

import java.util.Set;

/**
 * The Presenter for the RemoveProduct Use Case.
 */
public class RemoveProductPresenter implements RemoveProductOutputBoundary {

    private final RemoveProductViewModel removeProductViewModel;
    private final ListMyProductViewModel listMyProductViewModel;

    public RemoveProductPresenter(RemoveProductViewModel removeProductViewModel, ListMyProductViewModel listMyProductViewModel) {
        this.removeProductViewModel = removeProductViewModel;
        this.listMyProductViewModel = listMyProductViewModel;
    }

    @Override
    public void prepareSuccessView(RemoveProductOutputData response) {
        ListMyProductState state = listMyProductViewModel.getState();
        final Set<Integer> productIds = state.getProductIds();
        productIds.remove(response.getProductId());
    }

    @Override
    public void prepareFailView(String error) {
        final RemoveProductState state = removeProductViewModel.getState();
        state.setRemoveProductError(error);
        removeProductViewModel.firePropertyChanged();
    }
}
