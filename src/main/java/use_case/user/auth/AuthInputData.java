package use_case.user.auth;

public class AuthInputData {

    private final String username;
    private final String password;

    public AuthInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }
}
