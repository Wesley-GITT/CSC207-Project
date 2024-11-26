package use_case.user.show_other_profile;

public class ShowOtherProfileOutputData {

    private final String username;
    private final String telephone;
    private final String email;

    public ShowOtherProfileOutputData(String username, String telephone, String email) {
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
