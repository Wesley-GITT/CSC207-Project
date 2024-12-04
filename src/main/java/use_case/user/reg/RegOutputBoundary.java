package use_case.user.reg;

public interface RegOutputBoundary {

    /**
     * PrepareSuccessView for RegOutputBoundary.
     * @param outputData outputData
     */
    void prepareSuccessView(RegOutputData outputData);

    /**
     * PrepareFailView for RegOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);

    /**
     * SwitchToSignIn.
     */
    void switchToSignIn();
}
