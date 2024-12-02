package use_case.user.update_wishlist;

public interface UpdateWishlistOutputBoundary {

    void prepareSuccessView(UpdateWishlistOutputData listCartItemsOutputData);

    void prepareFailView(String errorMessage);
}
