package interface_adapter.user.update_pwd;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.update_pwd.UpdatePasswordOutputBoundary;
import use_case.user.update_pwd.UpdatePasswordOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class UpdatePasswordPresenter implements UpdatePasswordOutputBoundary {

    private final UpdatePasswordViewModel updatePwdViewModel;
    private final ViewManagerModel viewManagerModel;

    public UpdatePasswordPresenter(UpdatePasswordViewModel updatePwdViewModel, ViewManagerModel viewManagerModel) {
        this.updatePwdViewModel = updatePwdViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UpdatePasswordOutputData response) {
        final ViewManagerState state = viewManagerModel.getState();
        state.setPassword(response.getPassword());
        state.setPopupName("");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final UpdatePasswordState state = updatePwdViewModel.getState();
        state.setUpdatePasswordError(error);
        updatePwdViewModel.firePropertyChanged();
    }
}
