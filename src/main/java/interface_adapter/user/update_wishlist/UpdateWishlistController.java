package interface_adapter.user.update_wishlist;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.update_wishlist.UpdateWishlistInputBoundary;
import use_case.user.update_wishlist.UpdateWishlistInputData;

import java.util.Set;

/**
 * Controller for the Signup Use Case.
 */
public class UpdateWishlistController {

    private final UpdateWishlistInputBoundary updateWishlistInteractor;
    private final ViewManagerModel viewManagerModel;

    public UpdateWishlistController(UpdateWishlistInputBoundary updateWishlistInteractor, ViewManagerModel viewManagerModel) {
        this.updateWishlistInteractor = updateWishlistInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    public void execute(Set<Integer> wishlist) {
        final ViewManagerState state = viewManagerModel.getState();
        final String username = state.getUsername();
        final String password = state.getPassword();
        final UpdateWishlistInputData updateWishlistInputData = new UpdateWishlistInputData(username, password, wishlist);

        updateWishlistInteractor.execute(updateWishlistInputData);
    }
}
