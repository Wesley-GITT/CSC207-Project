package app;

import data_access.book.InMemoryBookDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUserFactory;
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
    private final JFrame cardFrame = new JFrame();
    private final CardLayout cardLayout = new CardLayout();
    // thought question: is the hard dependency below a problem?
    private final MyUserFactory userFactory = new MyUserFactory();
    private final ViewManagerModel viewManagerModel = new ViewManagerModel();
//    private final ViewManager viewManager = new ViewManager(cardPanel, cardLayout, viewManagerModel);

    // thought question: is the hard dependency below a problem?
    private final InMemoryUserDataAccessObject userDataAccessObject = new InMemoryUserDataAccessObject();
    private final InMemoryProductDataAccessObject productDataAccessObject = new InMemoryProductDataAccessObject();
    private final InMemoryBookDataAccessObject bookDataAccessObject = new InMemoryBookDataAccessObject();

    private LoginViewModel loginViewModel;
    private AuthView loginView;
    private LoggedInViewModel loggedInViewModel;
    private SignupViewModel signupViewModel;
    private RegView signupView;
    private MainPage mainPage;
    private MainPageViewModel mainPageViewModel;


    public AppBuilder() {
        cardFrame.setLayout(cardLayout);
    }

    public AppBuilder addLoginView() {
        loginViewModel = new LoginViewModel();
        loginView = new AuthView(loginViewModel);
        loginView.setModal(true);
        loginView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        return this;
    }

    public AppBuilder addSignupView() {
        signupViewModel = new SignupViewModel();
        signupView = new RegView(signupViewModel);
        signupView.setModal(true);
        signupView.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        return this;
    }

    public AppBuilder addMainPage() {
//        MainPageViewModel mainPageViewModel = new MainPageViewModel();
//        mainPage = new MainPage(mainPageViewModel);
//        cardFrame.setLayout(new BorderLayout());//add(mainPage, mainPageViewModel.getViewName());
        MainPage mainPage = new MainPage(new MainPageViewModel());
        cardFrame.getContentPane().add(mainPage); // MainPage is added to the main frame
        return this;
    }

    public AppBuilder addLoginUseCase() {
        final AuthOutputBoundary loginOutputBoundary = new LoginPresenter(viewManagerModel, loggedInViewModel, loginViewModel);
        final AuthInputBoundary loginInteractor = new AuthInteractor(userDataAccessObject, loginOutputBoundary);
        final LoginController loginController = new LoginController(loginInteractor);
        loginView.setLoginController(loginController);
        return this;
    }

    public AppBuilder addSignupUseCase() {
        final RegOutputBoundary signupOutputBoundary = new SignupPresenter(viewManagerModel, signupViewModel, loginViewModel);
        final RegInputBoundary userSignupInteractor = new RegInteractor(userDataAccessObject, signupOutputBoundary);
        final SignupController controller = new SignupController(userSignupInteractor);
        signupView.setSignupController(controller);
        return this;
    }

    public AppBuilder addLogoutUseCase() {
        final LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(viewManagerModel, loggedInViewModel, loginViewModel);
        final LogoutInputBoundary logoutInteractor = new LogoutInteractor(logoutOutputBoundary);
        final LogoutController logoutController = new LogoutController(logoutInteractor);
//        MainPage.setLogoutController(logoutController);
        return this;
    }

    public JFrame build() {
        final JFrame application = new JFrame("Bookstore");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        viewManagerModel.setState("Main");
        viewManagerModel.firePropertyChanged();

        return application;
    }

}

