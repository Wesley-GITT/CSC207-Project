package interface_adapter.user.update_pwd;

/**
 * The state for the Signup View Model.
 */
public class UpdatePasswordState {
    private String UpdatePasswordError;

    public String getUpdatePasswordError() {
        return UpdatePasswordError;
    }

    public void setUpdatePasswordError(String updatePasswordError) {
        this.UpdatePasswordError = updatePasswordError;
    }
}
