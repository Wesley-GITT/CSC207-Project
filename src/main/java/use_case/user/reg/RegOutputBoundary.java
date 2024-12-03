package use_case.user.reg;

public interface RegOutputBoundary {

    void prepareSuccessView(RegOutputData outputData);

    void prepareFailView(String errorMessage);

    void switchToSignIn();
}
