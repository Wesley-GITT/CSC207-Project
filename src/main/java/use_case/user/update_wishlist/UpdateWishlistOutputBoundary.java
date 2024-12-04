package use_case.user.update_wishlist;

public interface UpdateWishlistOutputBoundary {

    /**
     * PrepareSuccessView for UpdateWishlistOutputBoundary.
     * @param listCartItemsOutputData listCartItemsOutputData
     */
    void prepareSuccessView(UpdateWishlistOutputData listCartItemsOutputData);

    /**
     * PrepareFailView for UpdateWishlistOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);
}
