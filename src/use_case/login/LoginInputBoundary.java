package use_case.login;

/*
Interface to define of the process of login
 */
public interface LoginInputBoundary {
    LoginOutputData login(LoginInputData loginInputData);
}
