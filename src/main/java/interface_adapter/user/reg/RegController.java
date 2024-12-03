package interface_adapter.user.reg;

import use_case.user.reg.RegInputBoundary;
import use_case.user.reg.RegInputData;

/**
 * Controller for the Signup Use Case.
 */
public class RegController {

    private final RegInputBoundary regInteractor;

    public RegController(RegInputBoundary regInteractor) {
        this.regInteractor = regInteractor;
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

        regInteractor.execute(signupInputData);
    }

    public void switchToSignIn() {
        regInteractor.switchToSignIn();
    }
}
