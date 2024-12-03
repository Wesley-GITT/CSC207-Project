package interface_adapter.product.remove;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class RemoveProductViewModel extends ViewModel<RemoveProductState> {

    public RemoveProductViewModel() {
        super("remove product");
        setState(new RemoveProductState());
    }

}
