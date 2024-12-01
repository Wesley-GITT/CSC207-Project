package interface_adapter.LogIn;


import use_case.user.auth.AuthInputBoundary;
import use_case.user.auth.AuthInputData;

/**
 * The controller for the Login Use Case.
 */
public class LoginController {

    private final AuthInputBoundary loginUseCaseInteractor;

    public LoginController(AuthInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     * @param username the username of the user logging in
     * @param password the password of the user logging in
     */
    public void execute(String username, String password) {
        final AuthInputData loginInputData = new AuthInputData(
                username, password);

        loginUseCaseInteractor.execute(loginInputData);
    }
}
