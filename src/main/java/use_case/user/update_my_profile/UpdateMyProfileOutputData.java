package use_case.user.update_my_profile;

public class UpdateMyProfileOutputData {

    private final String address;
    private final String telephone;
    private final String email;

    public UpdateMyProfileOutputData(String address, String telephone, String email) {
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }
}
