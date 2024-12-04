package use_case.user.auth;

public interface AuthInputBoundary {

    /**
     * Execute method for AuthInputBoundary.
     * @param authInputData authInputData
     */
    void execute(AuthInputData authInputData);

    /**
     * SwitchToSignUp.
     */
    void switchToSignUp();
}
