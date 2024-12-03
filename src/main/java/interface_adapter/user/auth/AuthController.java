package interface_adapter.user.auth;

import use_case.user.auth.AuthInputBoundary;
import use_case.user.auth.AuthInputData;

/**
 * The controller for the Login Use Case.
 */
public class AuthController {

    private final AuthInputBoundary authInteractor;

    public AuthController(AuthInputBoundary authInteractor) {
        this.authInteractor = authInteractor;
    }

    /**
     * Executes the Login Use Case.
     * @param username the username of the user logging in
     * @param password the password of the user logging in
     */

    public void execute(String username, String password) {
        final AuthInputData authInputData = new AuthInputData(username, password);

        authInteractor.execute(authInputData);
    }

    public void switchToSignUp() {
        authInteractor.switchToSignUp();
    }
}
