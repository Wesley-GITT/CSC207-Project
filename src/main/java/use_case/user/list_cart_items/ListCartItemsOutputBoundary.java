package use_case.user.list_cart_items;

public interface ListCartItemsOutputBoundary {

    void prepareSuccessView(ListCartItemsOutputData listCartItemsOutputData);

    void prepareFailView(String errorMessage);
}
