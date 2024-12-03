package interface_adapter.user.logout;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class LogoutViewModel extends ViewModel<LogoutState> {

    public LogoutViewModel() {
        super("authentication");
        setState(new LogoutState());
    }

}
