package interface_adapter.product.list_my_products;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class ListMyProductViewModel extends ViewModel<ListMyProductState> {

    public ListMyProductViewModel() {
        super("list my products");
        setState(new ListMyProductState());
    }

}
