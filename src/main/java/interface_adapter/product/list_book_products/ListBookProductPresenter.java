package interface_adapter.product.list_book_products;

import use_case.product.list_book_products.ListBookProductOutputBoundary;
import use_case.product.list_book_products.ListBookProductOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class ListBookProductPresenter implements ListBookProductOutputBoundary {

    private final ListBookProductViewModel listBookProductViewModel;


    public ListBookProductPresenter(ListBookProductViewModel listBookProductViewModel) {
        this.listBookProductViewModel = listBookProductViewModel;
    }

    @Override
    public void prepareSuccessView(ListBookProductOutputData response) {
        ListBookProductState state = listBookProductViewModel.getState();
        state.setProductIds(response.getProductIds());
        listBookProductViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final ListBookProductState state = listBookProductViewModel.getState();
        state.setListBookProductError(error);
        listBookProductViewModel.firePropertyChanged();
    }
}
