package interface_adapter.user.update_my_profile;

import interface_adapter.user.show_my_profile.ShowMyProfileState;
import interface_adapter.user.show_my_profile.ShowMyProfileViewModel;
import use_case.user.update_my_profile.UpdateMyProfileOutputBoundary;
import use_case.user.update_my_profile.UpdateMyProfileOutputData;

/**
 * The Presenter for the Signup Use Case.
 */
public class UpdateMyProfilePresenter implements UpdateMyProfileOutputBoundary {

    private final UpdateMyProfileViewModel updateMyProfileViewModel;
    private final ShowMyProfileViewModel showMyProfileViewModel;

    public UpdateMyProfilePresenter(UpdateMyProfileViewModel updateMyProfileViewModel,
                                    ShowMyProfileViewModel showMyProfileViewModel) {
        this.updateMyProfileViewModel = updateMyProfileViewModel;
        this.showMyProfileViewModel = showMyProfileViewModel;
    }

    @Override
    public void prepareSuccessView(UpdateMyProfileOutputData response) {
        final ShowMyProfileState state = showMyProfileViewModel.getState();
        state.setTelephone(response.getTelephone());
        state.setEmail(response.getEmail());
        showMyProfileViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final UpdateMyProfileState state = updateMyProfileViewModel.getState();
        state.setUpdateProfileError(error);
        updateMyProfileViewModel.firePropertyChanged();
    }
}
