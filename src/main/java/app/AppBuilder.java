package app;

import data_access.user.InMemoryUserDataAccessObject;
import interface_adapter.LogIn.LoginController;
import interface_adapter.LogIn.LoginPresenter;
import interface_adapter.LogIn.LoginViewModel;
import interface_adapter.Logout.LogoutController;
import interface_adapter.Logout.LogoutPresenter;
import interface_adapter.MainPage.LoggedInViewModel;
import interface_adapter.MainPage.MainPageViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupViewModel;
import use_case.user.auth.AuthInputBoundary;
import use_case.user.auth.AuthInteractor;
import use_case.user.auth.AuthOutputBoundary;
import use_case.user.logout.LogoutInputBoundary;
import use_case.user.logout.LogoutInteractor;
import use_case.user.logout.LogoutOutputBoundary;
import use_case.user.reg.RegInputBoundary;
import use_case.user.reg.RegInteractor;
import use_case.user.reg.RegOutputBoundary;
import view.container.MainPage;
import view.user.AuthView;
import view.user.RegView;

import javax.swing.*;
import java.awt.*;

public class AppBuilder {
//    private final JFrame cardFrame = new JFrame();
//    private final CardLayout cardLayout = new CardLayout();
//
//    private final MyUserFactory userFactory = new MyUserFactory();
//    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
//    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();
//    private final InMemoryProductDataAccessObject productDataAccessObject = new InMemoryProductDataAccessObject();
//    private final InMemoryBookDataAccessObject bookDataAccessObject = new InMemoryBookDataAccessObject();

    private ViewManagerModel viewManagerModel;
    private LoginViewModel loginViewModel;
    private AuthView authView;
    private LoggedInViewModel loggedInViewModel;
    private SignupViewModel signupViewModel;
    private RegView regView;
//    private MainPage mainPage;
//    private MainPageViewModel mainPageViewModel;


    public AppBuilder() {
//        cardFrame.setLayout(cardLayout);
        viewManagerModel = new ViewManagerModel();
        loggedInViewModel = new LoggedInViewModel();
        signupViewModel = new SignupViewModel();
    }

//    public AppBuilder addLoginView() {
//        loginViewModel = new LoginViewModel();
//        authView = new AuthView(loginViewModel);
//        authView.setModal(true);
//        authView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        return this;
//    }
    public AppBuilder addLoginView() {
        // Initialize Login ViewModel
        loginViewModel = new LoginViewModel();

        // Create Login Use Case
        AuthOutputBoundary loginPresenter = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel, signupViewModel);
        AuthInputBoundary loginInteractor = new AuthInteractor(userDataAccessObject, loginPresenter);
        LoginController loginController = new LoginController(loginInteractor);

        // Initialize AuthView
        authView = new AuthView(new LoginViewModel(), loginController);

        return this;
    }


//    public AppBuilder addSignupView() {
//        signupViewModel = new SignupViewModel();
//        regView = new RegView(signupViewModel);
//        regView.setModal(true);
//        regView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        return this;
//    }
    public AppBuilder addSignupView() {
        // Initialize Signup ViewModel
        signupViewModel = new SignupViewModel();

        // Create Signup Use Case
        RegOutputBoundary signupPresenter = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        RegInputBoundary signupInteractor = new RegInteractor(userDataAccessObject, signupPresenter);
        SignupController signupController = new SignupController(signupInteractor);

        // Initialize RegView
        regView = new RegView(new SignupViewModel(), signupController);

        return this;
    }


//    public AppBuilder addMainPage() {
//        MainPageViewModel mainPageViewModel = new MainPageViewModel();
//        MainPage mainPage = new MainPage(new MainPageViewModel());
//        cardFrame.setLayout(new BorderLayout());
//        cardFrame.getContentPane().add(mainPage);
//        return this;
//    }

    public AppBuilder addLoginUseCase() {
        final AuthOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel, signupViewModel);
        final AuthInputBoundary loginInteractor = new AuthInteractor(userDataAccessObject, loginOutputBoundary);
        final LoginController loginController = new LoginController(loginInteractor);
        authView.setLoginController(loginController);
        return this;
    }

    public AppBuilder addSignupUseCase() {
        final RegOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        final RegInputBoundary userSignupInteractor = new RegInteractor(userDataAccessObject, signupOutputBoundary);
        final SignupController controller = new SignupController(userSignupInteractor);
        regView.setSignupController(controller);
        return this;
    }

    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel, loggedInViewModel, loginViewModel);
        final LogoutInputBoundary logoutInteractor = new LogoutInteractor(logoutOutputBoundary);
        final LogoutController logoutController = new LogoutController(logoutInteractor);
//        MainPage.setLogoutController(logoutController);
        return this;
    }

//    public JFrame build() {
//        final JFrame application = new JFrame("Bookstore");
//        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//
//        viewManagerModel.setState("Main");
//        viewManagerModel.firePropertyChanged();
//
//        return application;
//    }

    public void build() {
        SwingUtilities.invokeLater(() -> {
            authView.setVisible(true);
        });
    }

}

