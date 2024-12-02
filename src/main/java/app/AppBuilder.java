package app;

import javax.swing.SwingUtilities;

import data_access.user.InMemoryUserDataAccessObject;
import interface_adapter.LogIn.LoginController;
import interface_adapter.LogIn.LoginPresenter;
import interface_adapter.LogIn.LoginViewModel;
import interface_adapter.MainPage.LoggedInViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.user.auth.AuthInputBoundary;
import use_case.user.auth.AuthInteractor;
import use_case.user.auth.AuthOutputBoundary;
import use_case.user.reg.RegInputBoundary;
import use_case.user.reg.RegInteractor;
import use_case.user.reg.RegOutputBoundary;
import view.user.AuthView;
import view.user.RegView;

/**
 * Constructs and initializes the application, connecting all components.
 */
public class AppBuilder {

    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();

    private ViewManagerModel viewManagerModel;
    private LoggedInViewModel loggedInViewModel;
    private LoginViewModel loginViewModel;
    private SignupViewModel signupViewModel;

    private AuthView authView;
    private RegView regView;

    public AppBuilder() {
        // Initialize AppBuilder
        viewManagerModel = new ViewManagerModel();
        loggedInViewModel = new LoggedInViewModel();
    }

    /**
     * Sets up the login (AuthView) and its logic.
     */
    public AppBuilder addLoginView() {
        // Initialize Login ViewModel
        loginViewModel = new LoginViewModel();

        // Create Login Use Case
        AuthOutputBoundary loginPresenter = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);
        AuthInputBoundary loginInteractor = new AuthInteractor(userDataAccessObject, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);

        // Initialize AuthView
        authView = new AuthView();

        // TODO: Attach actions using getters for buttons (if needed)
        return this;
    }

    /**
     * Sets up the signup (RegView) and its logic.
     */
    public AppBuilder addSignupView() {
        // Initialize Signup ViewModel
        signupViewModel = new SignupViewModel();

        // Create Signup Use Case
        RegOutputBoundary signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        RegInputBoundary signupInteractor = new RegInteractor(userDataAccessObject, signupPresenter);
        SignupController signupController = new SignupController(signupInteractor);

        // Initialize RegView
        regView = new RegView();

        // TODO: Attach actions using getters for buttons (if needed)
        return this;
    }

    /**
     * Builds and starts the application, showing the login view first.
     */
    public void build() {
        SwingUtilities.invokeLater(() -> {
            authView.setVisible(true);
        });
    }
}
