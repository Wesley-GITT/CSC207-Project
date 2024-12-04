package use_case.user.show_wishlist;

public interface ShowWishlistOutputBoundary {

    /**
     * PrepareSuccessView for ShowWishlistOutputBoundary.
     * @param listCartItemsOutputData listCartItemsOutputData
     */
    void prepareSuccessView(ShowWishlistOutputData listCartItemsOutputData);

    /**
     * PrepareFailView for ShowWishlistOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);
}
