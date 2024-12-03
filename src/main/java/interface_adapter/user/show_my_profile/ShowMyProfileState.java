package interface_adapter.user.show_my_profile;

/**
 * The state for the Signup View Model.
 */
public class ShowMyProfileState {
    private String username;
    private String telephone;
    private String email;
    private String ShowMyProfileError;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getShowMyProfileError() {
        return ShowMyProfileError;
    }

    public void setShowMyProfileError(String showMyProfileError) {
        this.ShowMyProfileError = showMyProfileError;
    }
}
