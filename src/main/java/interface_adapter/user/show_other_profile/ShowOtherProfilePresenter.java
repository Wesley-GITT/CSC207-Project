package interface_adapter.user.show_other_profile;

import use_case.user.show_other_profile.ShowOtherProfileOutputBoundary;
import use_case.user.show_other_profile.ShowOtherProfileOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class ShowOtherProfilePresenter implements ShowOtherProfileOutputBoundary {

    private final ShowOtherProfileViewModel showOtherProfileViewModel;

    public ShowOtherProfilePresenter(ShowOtherProfileViewModel showOtherProfileViewModel) {
        this.showOtherProfileViewModel = showOtherProfileViewModel;
    }

    @Override
    public void prepareSuccessView(ShowOtherProfileOutputData response) {
        ShowOtherProfileState showOtherProfileState = showOtherProfileViewModel.getState();
        showOtherProfileState.setUsername(response.getUsername());
        showOtherProfileState.setTelephone(response.getTelephone());
        showOtherProfileState.setEmail(response.getEmail());
        showOtherProfileViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final ShowOtherProfileState state = showOtherProfileViewModel.getState();
        state.setShowOtherProfileError(error);
        showOtherProfileViewModel.firePropertyChanged();
    }
}
