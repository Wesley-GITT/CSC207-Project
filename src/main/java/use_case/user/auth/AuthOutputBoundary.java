package use_case.user.auth;

public interface AuthOutputBoundary {

    /**
     * PrepareSuccessView for AuthOutputBoundary.
     * @param outputData outputData
     */
    void prepareSuccessView(AuthOutputData outputData);

    /**
     * PrepareFailView for AuthOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);

    /**
     * SwitchToSignUp.
     */
    void switchToSignUp();
}
