package interface_adapter.user.show_other_profile;

import interface_adapter.ViewModel;

/**
 * The View Model for the ShowOtherProfile View.
 */
public class ShowOtherProfileViewModel extends ViewModel<ShowOtherProfileState> {

    public ShowOtherProfileViewModel() {
        super("other profile");
        setState(new ShowOtherProfileState());
    }

}
