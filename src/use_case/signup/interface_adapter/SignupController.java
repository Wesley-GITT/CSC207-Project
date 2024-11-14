package use_case.signup.interface_adapter;

import use_case.signup.SignUpInputData;
import use_case.signup.SignUpInputBoundary;

/**
 * Controller for the Signup Use Case.
 */
public class SignupController {

    private final SignUpInputBoundary userSignupUseCaseInteractor;

    public SignupController(SignUpInputBoundary userSignupUseCaseInteractor) {
        this.userSignupUseCaseInteractor = userSignupUseCaseInteractor;
    }

    /**
     * Executes the Signup Use Case.
     * @param username the username to sign up
     * @param password the password
     * @param name the nickname
     * @param address the address
     * @param contactInfo the contact information
     */
    public void registerUser(String username, String password, String name, String address, String contactInfo) {
        final SignUpInputData signupInputData = new SignUpInputData(username, password, name, address, contactInfo);

        userSignupUseCaseInteractor.registerUser(signupInputData);
    }

    /**
     * Executes the "switch to LoginView" Use Case.
     */
    public void switchToLoginView() {
            userSignupUseCaseInteractor.switchToLoginView();
        }


}
