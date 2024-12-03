package interface_adapter.user.update_name;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import interface_adapter.user.show_my_profile.ShowMyProfileState;
import interface_adapter.user.show_my_profile.ShowMyProfileViewModel;
import use_case.user.update_name.UpdateNameOutputBoundary;
import use_case.user.update_name.UpdateNameOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class UpdateNamePresenter implements UpdateNameOutputBoundary {

    private final UpdateNameViewModel updateNameViewModel;
    private final ShowMyProfileViewModel showMyProfileViewModel;
    private final ViewManagerModel viewManagerModel;

    public UpdateNamePresenter(UpdateNameViewModel updateNameViewModel, ShowMyProfileViewModel showMyProfileViewModel, ViewManagerModel viewManagerModel) {
        this.updateNameViewModel = updateNameViewModel;
        this.showMyProfileViewModel = showMyProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(UpdateNameOutputData response) {
        final String newUsername = response.getUsername();
        ShowMyProfileState state = showMyProfileViewModel.getState();
        state.setUsername(newUsername);
        showMyProfileViewModel.firePropertyChanged();

        ViewManagerState managerState = viewManagerModel.getState();
        managerState.setUsername(newUsername);
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final UpdateNameState state = updateNameViewModel.getState();
        state.setUpdateNameError(error);
        updateNameViewModel.firePropertyChanged();
    }
}
