package interface_adapter.user.show_wishlist;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.show_wishlist.ShowWishlistOutputBoundary;
import use_case.user.show_wishlist.ShowWishlistOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class ShowWishlistPresenter implements ShowWishlistOutputBoundary {

    private final ShowWishlistViewModel showWishlistViewModel;
    // private final ProductViewModel
    private final ViewManagerModel viewManagerModel;

    public ShowWishlistPresenter(ShowWishlistViewModel showWishlistViewModel, ViewManagerModel viewManagerModel) {
        this.showWishlistViewModel = showWishlistViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ShowWishlistOutputData response) {
        ShowWishlistState state = showWishlistViewModel.getState();
        state.setWishlist(response.getWishlist());
        showWishlistViewModel.firePropertyChanged();

        ViewManagerState managerState = viewManagerModel.getState();
        managerState.setViewName("my wishlist");
        showWishlistViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final ShowWishlistState state = showWishlistViewModel.getState();
        state.setShowWishlistError(error);
        showWishlistViewModel.firePropertyChanged();
    }
}
