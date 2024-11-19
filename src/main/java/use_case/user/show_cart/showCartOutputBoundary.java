package use_case.user.show_cart;

public interface showCartOutputBoundary {

    void prepareSuccessView(showCartOutputData showCartOutputData);

    void prepareFailView(String errorMessage);
}
