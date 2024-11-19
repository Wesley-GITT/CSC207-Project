package use_case.user.reg;

public class RegInputData {

    private final String username;
    private final String password;
    private final String passwordRepeated;

    public RegInputData(String username, String password, String passwordRepeated) {
        this.username = username;
        this.password = password;
        this.passwordRepeated = passwordRepeated;
    }

    String getUsername() {
        return username;
    }

    String getPassword() {
        return password;
    }

    String getPasswordRepeated() {return passwordRepeated; }
}
