package interface_adapter.user.update_my_profile;

/**
 * The state for the UpdateMyProfile View Model.
 */
public class UpdateMyProfileState {
    private String Telephone;
    private String Email;
    private String UpdateProfileError;

    public String getUpdateProfileError() {
        return UpdateProfileError;
    }

    public void setUpdateProfileError(String updateProfileError) {
        this.UpdateProfileError = updateProfileError;
    }

    public String getTelephone() {
        return Telephone;
    }

    public void setTelephone(String telephone) {
        Telephone = telephone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
