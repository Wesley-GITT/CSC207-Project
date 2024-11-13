package use_case.login;

/*
Interface for handling login output, presenting success or failure
 */
public interface LoginOutputBoundary {
    void presentLoginResult(LoginOutputData loginOutputData);
}
