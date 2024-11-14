package use_case.login;

/*
A data class for sign in input
 */
public class LoginOutputData {
    private final boolean success;
    private final String username;

    public LoginOutputData(boolean success, String username) {
        this.success = success;
        this.username = username;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getUsername() {return username;}

}
