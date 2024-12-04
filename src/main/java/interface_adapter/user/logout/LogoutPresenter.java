package interface_adapter.user.logout;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.logout.LogoutOutputBoundary;

/**
 * The Presenter for the Login Use Case.
 */
public class LogoutPresenter implements LogoutOutputBoundary {

    private final ViewManagerModel viewManagerModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        // Clear username and password and navigate to the "home" view
        final ViewManagerState state = viewManagerModel.getState();
        state.setUsername("");
        state.setPassword("");
        state.setViewName("home");
        // Always navigate to "home"
        viewManagerModel.firePropertyChanged();
    }
}
