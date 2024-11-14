package use_case.login;

/*
Interface to define of the process of login
 */
public interface LoginInputBoundary {
    /**
     * Executes the login use case.
     *
     * @param loginInputData the input data
     */
    LoginOutputData login(LoginInputData loginInputData);

}
