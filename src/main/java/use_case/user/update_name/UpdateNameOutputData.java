package use_case.user.update_name;

public class UpdateNameOutputData {

    private final String username;

    public UpdateNameOutputData(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}
