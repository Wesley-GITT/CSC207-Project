package use_case.user.update_my_profile;

public class UpdateMyProfileInputData {

    private final String username;
    private final String password;
    private final String address;
    private final String telephone;
    private final String email;

    public UpdateMyProfileInputData(String username, String password, String address, String telephone, String email) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.telephone = telephone;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() { return telephone; }

    public String getEmail() { return email; }
}
