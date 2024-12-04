package interface_adapter.product.list_my_products;

import use_case.product.list_my_products.ListMyProductOutputBoundary;
import use_case.product.list_my_products.ListMyProductOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class ListMyProductPresenter implements ListMyProductOutputBoundary {

    private final ListMyProductViewModel listMyProductViewModel;

    public ListMyProductPresenter(ListMyProductViewModel listMyProductViewModel) {
        this.listMyProductViewModel = listMyProductViewModel;
    }

    @Override
    public void prepareSuccessView(ListMyProductOutputData response) {
        final ListMyProductState state = listMyProductViewModel.getState();
        state.setProductIds(response.getProductIds());
        listMyProductViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final ListMyProductState state = listMyProductViewModel.getState();
        state.setListMyProductError(error);
        listMyProductViewModel.firePropertyChanged();
    }
}
