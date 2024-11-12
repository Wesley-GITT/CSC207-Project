package use_case.signup;

/*
Interface to define the input for the sign-up process
 */
public interface SignUpInputBoundary {
    SignUpOutputData registerUser(SignUpInputData signUpInputData);
}
