package interface_adapter.user.update_wishlist;

import interface_adapter.user.show_wishlist.ShowWishlistState;
import interface_adapter.user.show_wishlist.ShowWishlistViewModel;
import use_case.user.update_wishlist.UpdateWishlistOutputBoundary;
import use_case.user.update_wishlist.UpdateWishlistOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class UpdateWishlistPresenter implements UpdateWishlistOutputBoundary {

    private final UpdateWishlistViewModel updateWishlistViewModel;
    private final ShowWishlistViewModel showWishlistViewModel;

    /**
     * UpdateWishlistPresenter.
     * @param updateWishlistViewModel updateWishlistViewModel
     * @param showWishlistViewModel showWishlistViewModel
     */
    public UpdateWishlistPresenter(UpdateWishlistViewModel updateWishlistViewModel, ShowWishlistViewModel showWishlistViewModel) {
        this.updateWishlistViewModel = updateWishlistViewModel;
        this.showWishlistViewModel = showWishlistViewModel;
    }

    @Override
    public void prepareSuccessView(UpdateWishlistOutputData response) {
        // On success, switch to the login view.
        final ShowWishlistState showWishlistState = showWishlistViewModel.getState();
        showWishlistState.setWishlist(response.getWishlist());
        showWishlistViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final UpdateWishlistState state = updateWishlistViewModel.getState();
        state.setUpdateWishlistError(error);
        updateWishlistViewModel.firePropertyChanged();
    }
}
