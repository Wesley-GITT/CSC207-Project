package interface_adapter.product.list_book_products;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class ListBookProductViewModel extends ViewModel<ListBookProductState> {

    public ListBookProductViewModel() {
        super("list book products");
        setState(new ListBookProductState());
    }

}
