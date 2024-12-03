package interface_adapter.user.auth;

/**
 * The state for the Login View Model.
 */
public class AuthState {
    private String loginError;

    public String getLoginError() {
        return loginError;
    }

    public void setLoginError(String usernameError) {
        this.loginError = usernameError;
    }

}
