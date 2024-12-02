package use_case.user.auth;

public interface AuthOutputBoundary {

    void prepareSuccessView(AuthOutputData outputData);

    void prepareFailView(String errorMessage);

    void switchToOriginView();

    void switchToRegView();
}
