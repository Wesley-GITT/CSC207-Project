package interface_adapter.user.show_my_profile;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class ShowMyProfileViewModel extends ViewModel<ShowMyProfileState> {

    public ShowMyProfileViewModel() {
        super("my profile");
        setState(new ShowMyProfileState());
    }

}
