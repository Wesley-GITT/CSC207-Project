package use_case.user.show_my_profile;

public class ShowMyProfileOutputData {

    private final String address;
    private final String telephone;
    private final String email;

    public ShowMyProfileOutputData(String address, String telephone, String email) {
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
