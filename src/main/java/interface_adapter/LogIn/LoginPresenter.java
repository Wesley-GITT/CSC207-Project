package interface_adapter.LogIn;

import interface_adapter.ViewManagerModel;
import interface_adapter.MainPage.LoggedInState;
import interface_adapter.MainPage.LoggedInViewModel;
import use_case.user.auth.AuthOutputBoundary;
import use_case.user.auth.AuthOutputData;

/**
 * Presenter for the Login Use Case.
 */
public class LoginPresenter implements AuthOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final LoggedInViewModel loggedInViewModel;
    private final LoginViewModel loginViewModel;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          LoggedInViewModel loggedInViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(AuthOutputData response) {
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        loggedInViewModel.setState(loggedInState);

        viewManagerModel.setState(loggedInViewModel.getViewName());
    }

    @Override
    public void prepareFailView(String errorMessage) {
        LoginState loginState = loginViewModel.getState();
        loginState.setLoginError(errorMessage);
        loginViewModel.setState(loginState);
    }
}
