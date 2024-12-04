package interface_adapter.user.show_wishlist;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.show_wishlist.ShowWishlistInputBoundary;
import use_case.user.show_wishlist.ShowWishlistInputData;

/**
 * Controller for the Signup Use Case.
 */
public class ShowWishlistController {

    private final ShowWishlistInputBoundary showWishlistInteractor;
    private final ViewManagerModel viewManagerModel;

    public ShowWishlistController(ShowWishlistInputBoundary showWishlistInteractor, ViewManagerModel viewManagerModel) {
        this.showWishlistInteractor = showWishlistInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Execute method for showWishlistInteractor.
     */
    public void execute() {
        final ViewManagerState state = viewManagerModel.getState();
        final String username = state.getUsername();
        final String password = state.getPassword();
        final ShowWishlistInputData showWishlistInputData = new ShowWishlistInputData(username, password);

        showWishlistInteractor.execute(showWishlistInputData);
    }
}
