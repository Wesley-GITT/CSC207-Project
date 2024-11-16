package use_case.signup;

/*
A data class for sign-up output
 */
public class SignUpOutputData {
    private final boolean success;
    private final String username;

    public SignUpOutputData(boolean success, String username) {
        this.success = success;
        this.username = username;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getUsername() {
        return username;
    }

    // Setters
}
