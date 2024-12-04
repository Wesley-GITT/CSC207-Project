package interface_adapter.user.show_my_profile;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.show_my_profile.ShowMyProfileOutputBoundary;
import use_case.user.show_my_profile.ShowMyProfileOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class ShowMyProfilePresenter implements ShowMyProfileOutputBoundary {

    private final ShowMyProfileViewModel showMyProfileViewModel;
    private final ViewManagerModel viewManagerModel;

    public ShowMyProfilePresenter(ShowMyProfileViewModel showMyProfileViewModel, ViewManagerModel viewManagerModel) {
        this.showMyProfileViewModel = showMyProfileViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ShowMyProfileOutputData response) {
        final ShowMyProfileState state = showMyProfileViewModel.getState();
        state.setUsername(response.getUsername());
        state.setEmail(response.getTelephone());
        state.setEmail(response.getEmail());
        showMyProfileViewModel.firePropertyChanged();
        final ViewManagerState managerState = viewManagerModel.getState();
        managerState.setViewName("my profile");
        viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final ShowMyProfileState state = showMyProfileViewModel.getState();
        state.setShowMyProfileError(error);
        showMyProfileViewModel.firePropertyChanged();
    }
}
