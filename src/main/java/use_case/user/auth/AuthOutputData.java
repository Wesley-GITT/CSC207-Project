package use_case.user.auth;

public class AuthOutputData {

    private final int id;
    private final String username;
    private final String password;

    public AuthOutputData(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
