package use_case.signup;

/*
A data class for sign-up output
 */
public class SignUpOutputData {
    private boolean success;
    private String message;

    public SignUpOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    // Setters
}
