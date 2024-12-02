package interface_adapter.signup;

import use_case.user.reg.RegInputBoundary;
import use_case.user.reg.RegInputData;

/**
 * Controller for the Signup Use Case.
 */
public class SignupController {

    private final RegInputBoundary signupInteractor;

    public SignupController(RegInputBoundary signupInteractor) {
        this.signupInteractor = signupInteractor;
    }

    /**
     * Executes the Signup Use Case.
     *
     * @param username         the username
     * @param password         the password
     * @param repeatPassword   the repeated password
     */
    public void execute(String username, String password, String repeatPassword) {
        RegInputData inputData = new RegInputData(username, password, repeatPassword);
        signupInteractor.execute(inputData);
    }

    public void switchToLoginView() {
        signupInteractor.switchToOriginalView();
    }
}
