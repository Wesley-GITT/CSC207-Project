package interface_adapter.user.update_name;

/**
 * The state for the Signup View Model.
 */
public class UpdateNameState {
    private String username;
    private String UpdateNameError;

    public String getUpdateNameError() {
        return UpdateNameError;
    }

    public void setUpdateNameError(String updateNameError) {
        this.UpdateNameError = updateNameError;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
