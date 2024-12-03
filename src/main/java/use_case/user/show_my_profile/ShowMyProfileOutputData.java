package use_case.user.show_my_profile;

public class ShowMyProfileOutputData {

    private final String username;
    private final String telephone;
    private final String email;

    public ShowMyProfileOutputData(String username, String telephone, String email) {
        this.username = username;
        this.telephone = telephone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
