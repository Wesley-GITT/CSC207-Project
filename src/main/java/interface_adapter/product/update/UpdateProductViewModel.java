package interface_adapter.product.update;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class UpdateProductViewModel extends ViewModel<UpdateProductState> {

    public UpdateProductViewModel() {
        super("update product");
        setState(new UpdateProductState());
    }

}
