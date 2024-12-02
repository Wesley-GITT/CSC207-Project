package interface_adapter.signup;

import interface_adapter.LogIn.LoginState;
import interface_adapter.LogIn.LoginViewModel;
import interface_adapter.ViewManagerModel;
import use_case.user.reg.RegOutputBoundary;
import use_case.user.reg.RegOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class SignupPresenter implements RegOutputBoundary {

    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;
    private final ViewManagerModel viewManagerModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(RegOutputData response) {
        // On success, switch to the login view.
        final LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        this.loginViewModel.setState(loginState);
        loginViewModel.firePropertyChanged();

        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }

    @Override
    public void switchToOriginalView() {
         viewManagerModel.setState(loginViewModel.getViewName());
         viewManagerModel.firePropertyChanged();
    }

    @Override
    public void switchToMyUserView() {
        viewManagerModel.setState(loginViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}