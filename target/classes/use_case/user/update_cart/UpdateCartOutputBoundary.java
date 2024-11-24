package use_case.user.update_cart;

public interface UpdateCartOutputBoundary {

    void prepareSuccessView(UpdateCartOutputData updateCartOutputData);

    void prepareFailView(String errorMessage);
}
