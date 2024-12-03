package interface_adapter.user.show_other_profile;

/**
 * The state for the ShowOtherProfile View Model.
 */
public class ShowOtherProfileState {
    private String username;
    private String telephone;
    private String email;
    private String ShowOtherProfileError;

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

    public String getShowOtherProfileError() {
        return ShowOtherProfileError;
    }

    public void setShowOtherProfileError(String showOtherProfileError) {
        this.ShowOtherProfileError = showOtherProfileError;
    }
}
