package use_case.signup;

/*
Interface to define the input for the sign-up process
 */
public interface SignUpInputBoundary {
    /**
     * Register user the signup use case.
     * @param signUpInputData the input data
     */
    SignUpOutputData registerUser(SignUpInputData signUpInputData);

    /**
     * Executes the switch to login view use case.
     */
    void switchToLoginView();
}
