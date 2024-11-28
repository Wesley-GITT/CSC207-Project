package use_case.user.show_my_profile;

public class ShowMyProfileOutputData {

    private final String telephone;
    private final String email;

    public ShowMyProfileOutputData(String telephone, String email) {
        this.telephone = telephone;
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
