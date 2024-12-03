package interface_adapter.product.view;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class ProductViewModel extends ViewModel<ProductState> {

    public ProductViewModel() {
        super("view product");
        setState(new ProductState());
    }

}
