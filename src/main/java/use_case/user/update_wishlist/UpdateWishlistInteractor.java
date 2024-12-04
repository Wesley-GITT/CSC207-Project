package use_case.user.update_wishlist;

import java.util.Set;

import entity.MyUser;

public class UpdateWishlistInteractor implements UpdateWishlistInputBoundary {

    private UpdateWishlistDataAccessInterface userDataAccessObject;
    private UpdateWishlistOutputBoundary showWishlistPresenter;

    public UpdateWishlistInteractor(UpdateWishlistDataAccessInterface userDataAccessObject,
                                    UpdateWishlistOutputBoundary updateCartPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.showWishlistPresenter = updateCartPresenter;
    }

    @Override
    public void execute(UpdateWishlistInputData updateWishlistInputData) {

        final String username = updateWishlistInputData.getUsername();
        final String password = updateWishlistInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            showWishlistPresenter.prepareFailView("Authentication failed");
        }
        else {
            final MyUser user = userDataAccessObject.get(username, password);
            final Set<Integer> wishlist = updateWishlistInputData.getWishlist();
            user.setWishlist(wishlist);

            userDataAccessObject.save(user);

            final UpdateWishlistOutputData outputData = new UpdateWishlistOutputData(wishlist);
            showWishlistPresenter.prepareSuccessView(outputData);
        }
    }
}
