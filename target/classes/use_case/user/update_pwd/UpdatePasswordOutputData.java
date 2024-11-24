package use_case.user.update_pwd;

public class UpdatePasswordOutputData {

    private final String password;

    public UpdatePasswordOutputData(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
