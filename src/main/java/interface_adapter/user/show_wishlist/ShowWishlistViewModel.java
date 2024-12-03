package interface_adapter.user.show_wishlist;

import interface_adapter.ViewModel;

/**
 * The View Model for the ShowWishlist View.
 */
public class ShowWishlistViewModel extends ViewModel<ShowWishlistState> {

    public ShowWishlistViewModel() {
        super("my wishlist");
        setState(new ShowWishlistState());
    }

}
