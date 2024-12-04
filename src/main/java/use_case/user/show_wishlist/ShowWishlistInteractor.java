package use_case.user.show_wishlist;

import java.util.Set;

import entity.MyUser;

public class ShowWishlistInteractor implements ShowWishlistInputBoundary {

    private ShowWishlistDataAccessInterface userDataAccessObject;
    private ShowWishlistOutputBoundary showWishlistPresenter;

    public ShowWishlistInteractor(ShowWishlistDataAccessInterface userDataAccessObject,
                                  ShowWishlistOutputBoundary updateCartPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.showWishlistPresenter = updateCartPresenter;
    }

    @Override
    public void execute(ShowWishlistInputData showWishlistInputData) {

        final String username = showWishlistInputData.getUsername();
        final String password = showWishlistInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            showWishlistPresenter.prepareFailView("Authentication failed");
        }
        else {
            final MyUser user = userDataAccessObject.get(username, password);
            final Set<Integer> wishlist = user.getWishlist();

            final ShowWishlistOutputData outputData = new ShowWishlistOutputData(wishlist);
            showWishlistPresenter.prepareSuccessView(outputData);
        }
    }
}
