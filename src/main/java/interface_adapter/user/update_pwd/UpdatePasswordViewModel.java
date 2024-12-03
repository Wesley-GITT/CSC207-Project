package interface_adapter.user.update_pwd;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class UpdatePasswordViewModel extends ViewModel<UpdatePasswordState> {

    public UpdatePasswordViewModel() {
        super("update password");
        setState(new UpdatePasswordState());
    }

}
