package use_case.login.interface_adapter;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

/**
 * The controller for the Login Use Case.
 */
public class LoginController {

    private final LoginInputBoundary loginUseCaseInteractor;

    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    /**
     * Executes the Login Use Case.
     * @param username the username of the user logging in
     * @param password the password of the user logging in
     */
    public void login (String username, String password) {
        final LoginInputData loginInputData = new LoginInputData(
                username, password);

        loginUseCaseInteractor.login(loginInputData);
    }
}