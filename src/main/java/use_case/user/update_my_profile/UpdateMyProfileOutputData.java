package use_case.user.update_my_profile;

public class UpdateMyProfileOutputData {

    private final String telephone;
    private final String email;

    public UpdateMyProfileOutputData(String telephone, String email) {
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
