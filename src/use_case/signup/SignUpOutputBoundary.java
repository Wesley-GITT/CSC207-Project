package use_case.signup;

/*
Interface for handling signup output, presenting success or failure
 */
public interface SignUpOutputBoundary {
    void presentSignUpResult(SignUpOutputData signUpOutputData);
}
