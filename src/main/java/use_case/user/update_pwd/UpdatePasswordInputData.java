package use_case.user.update_pwd;

public class UpdatePasswordInputData {

    private final String username;
    private final String orginalPassword;
    private final String newPassword;
    private final String newPasswordRepeated;

    public UpdatePasswordInputData(String username, String orginalPassword,
                                   String newPassword, String newPasswordRepeated) {
        this.username = username;
        this.orginalPassword = orginalPassword;
        this.newPassword = newPassword;
        this.newPasswordRepeated = newPasswordRepeated;
    }

    public String getUsername() {
        return username;
    }

    public String getOrginalPassword() {
        return orginalPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getNewPasswordRepeated() {
        return newPasswordRepeated;
    }
}
