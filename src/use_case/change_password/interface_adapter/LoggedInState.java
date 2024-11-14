package use_case.change_password.interface_adapter;

/**
 * The State information representing the logged-in user.
 */
public class LoggedInState {
    private String username = "";
    private String password = "";
    private String passwordError;
    private String name;
    private String address;
    private String contactInfo;

    public LoggedInState(LoggedInState copy) {
        username = copy.username;
        password = copy.password;
        passwordError = copy.passwordError;
        name = copy.name;
        address = copy.address;
        contactInfo = copy.contactInfo;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public LoggedInState() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getPassword() {
        return password;
    }

    public String getname() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }
}
