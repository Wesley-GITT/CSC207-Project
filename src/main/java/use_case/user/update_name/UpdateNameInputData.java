package use_case.user.update_name;

public class UpdateNameInputData {

    private final String username;
    private final String password;
    private final String newUsername;

    public UpdateNameInputData(String username, String password, String newUsername) {
        this.username = username;
        this.password = password;
        this.newUsername = newUsername;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getNewUsername() {
        return newUsername;
    }
}
