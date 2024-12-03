package interface_adapter.user.reg;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.reg.RegOutputBoundary;
import use_case.user.reg.RegOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class RegPresenter implements RegOutputBoundary {

    private final RegViewModel regViewModel;
    private final ViewManagerModel viewManagerModel;

    public RegPresenter(RegViewModel regViewModel, ViewManagerModel viewManagerModel) {
        this.regViewModel = regViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(RegOutputData response) {
        // On success, switch to the login view.
        ViewManagerState state = viewManagerModel.getState();
        state.setUsername(response.getUsername());
        state.setPassword(response.getPassword());
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final RegState state = regViewModel.getState();
        state.setRegisterError(error);
        regViewModel.firePropertyChanged();
    }

    @Override
    public void switchToSignIn() {
        final ViewManagerState state = viewManagerModel.getState();
        state.setPopupName("registration");
        viewManagerModel.firePropertyChanged();
    }
}
