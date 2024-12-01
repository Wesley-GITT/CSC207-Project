package use_case.user.show_wishlist;

public interface ShowWishlistOutputBoundary {

    void prepareSuccessView(ShowWishlistOutputData listCartItemsOutputData);

    void prepareFailView(String errorMessage);
}
