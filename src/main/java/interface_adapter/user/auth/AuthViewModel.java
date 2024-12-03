package interface_adapter.user.auth;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class AuthViewModel extends ViewModel<AuthState> {

    public AuthViewModel() {
        super("authentication");
        setState(new AuthState());
    }

}
