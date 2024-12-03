package interface_adapter.user.auth;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.auth.AuthOutputBoundary;
import use_case.user.auth.AuthOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class AuthPresenter implements AuthOutputBoundary {

    private final AuthViewModel authViewModel;
    private final ViewManagerModel viewManagerModel;

    public AuthPresenter(ViewManagerModel viewManagerModel, AuthViewModel authViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.authViewModel = authViewModel;
    }

    @Override
    public void prepareSuccessView(AuthOutputData response) {
        AuthState state = authViewModel.getState();
        state.setLoginError(null);
        authViewModel.firePropertyChanged();

        // capture the username and password
        ViewManagerState managerState = viewManagerModel.getState();
        managerState.setUsername(response.getUsername());
        managerState.setPassword(response.getPassword());
        managerState.setPopupName("");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final AuthState state = authViewModel.getState();
        state.setLoginError(error);
        authViewModel.firePropertyChanged();
    }

    @Override
    public void switchToSignUp() {
        ViewManagerState managerState = viewManagerModel.getState();
        managerState.setPopupName("registration");
        viewManagerModel.firePropertyChanged();
    }
}
