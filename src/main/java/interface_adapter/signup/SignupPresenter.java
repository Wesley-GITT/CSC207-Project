package interface_adapter.signup;

import interface_adapter.ViewManagerModel;
import interface_adapter.LogIn.LoginState;
import interface_adapter.LogIn.LoginViewModel;
import use_case.user.reg.RegOutputBoundary;
import use_case.user.reg.RegOutputData;

/**
 * Presenter for the Signup Use Case.
 */
public class SignupPresenter implements RegOutputBoundary {

    private final ViewManagerModel viewManagerModel;
    private final SignupViewModel signupViewModel;
    private final LoginViewModel loginViewModel;

    public SignupPresenter(ViewManagerModel viewManagerModel,
                           SignupViewModel signupViewModel,
                           LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.signupViewModel = signupViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(RegOutputData response) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsername(response.getUsername());
        loginViewModel.setState(loginState);

        viewManagerModel.setState(loginViewModel.getViewName());
    }

    @Override
    public void prepareFailView(String errorMessage) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(errorMessage);
        signupViewModel.setState(signupState);
    }

    @Override
    public void switchToOriginalView() {
        viewManagerModel.setState(loginViewModel.getViewName());
    }

    @Override
    public void switchToMyUserView() {
        // Future implementation for MyUser view
    }
}
