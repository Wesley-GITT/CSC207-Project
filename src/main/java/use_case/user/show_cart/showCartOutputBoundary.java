package use_case.user.show_cart;

public interface ShowCartOutputBoundary {

    void prepareSuccessView(ShowCartOutputData showCartOutputData);

    void prepareFailView(String errorMessage);
}
