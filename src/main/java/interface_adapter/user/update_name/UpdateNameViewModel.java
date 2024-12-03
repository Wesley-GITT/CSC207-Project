package interface_adapter.user.update_name;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class UpdateNameViewModel extends ViewModel<UpdateNameState> {

    public UpdateNameViewModel() {
        super("update username");
        setState(new UpdateNameState());
    }

}
