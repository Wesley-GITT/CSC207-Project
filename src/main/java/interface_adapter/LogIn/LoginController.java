package interface_adapter.LogIn;

import use_case.user.auth.AuthInputBoundary;
import use_case.user.auth.AuthInputData;

/**
 * Controller for the Login Use Case.
 */
public class LoginController {

    private final AuthInputBoundary loginUseCaseInteractor;

    public LoginController(AuthInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     *
     * @param username the username
     * @param password the password
     */
    public void execute(String username, String password) {
        AuthInputData inputData = new AuthInputData(username, password);
        loginUseCaseInteractor.execute(inputData);
    }
}
