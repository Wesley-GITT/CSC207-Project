package use_case.user.reg;

public interface RegInputBoundary {

    /**
     * Execute method for RegInputBoundary.
     * @param regInputData regInputData
     */
    void execute(RegInputData regInputData);

    /**
     * SwitchToSignIn.
     */
    void switchToSignIn();
}
