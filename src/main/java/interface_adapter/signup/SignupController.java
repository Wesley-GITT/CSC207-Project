package interface_adapter.signup;

import use_case.user.reg.RegInputBoundary;
import use_case.user.reg.RegInputData;

/**
 * Controller for the Signup Use Case.
 */
public class SignupController {

    private final RegInputBoundary userSignupUseCaseInteractor;

    public SignupController(RegInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the Signup Use Case.
     * @param username the username to sign up
     * @param password1 the password
     * @param password2 the password repeated
     */
    public void execute(String username, String password1, String password2) {
        final RegInputData signupInputData = new RegInputData(
                username, password1, password2);

        userSignupUseCaseInteractor.execute(signupInputData);
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToLoginView() {
        // modification expected
        // userSignupUseCaseInteractor.switchToLoginView();
    }
}
