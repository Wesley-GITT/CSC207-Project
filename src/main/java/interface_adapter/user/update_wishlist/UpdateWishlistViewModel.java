package interface_adapter.user.update_wishlist;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class UpdateWishlistViewModel extends ViewModel<UpdateWishlistState> {

    public UpdateWishlistViewModel() {
        super("update wishlist");
        setState(new UpdateWishlistState());
    }

}
