package interface_adapter.user.update_my_profile;

import interface_adapter.ViewModel;

/**
 * The View Model for the UpdateMyProfile View.
 */
public class UpdateMyProfileViewModel extends ViewModel<UpdateMyProfileState> {

    public UpdateMyProfileViewModel() {
        super("update profile");
        setState(new UpdateMyProfileState());
    }

}
