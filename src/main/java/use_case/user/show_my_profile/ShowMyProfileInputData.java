package use_case.user.show_my_profile;

public class ShowMyProfileInputData {

    private final String username;
    private final String password;

    public ShowMyProfileInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
