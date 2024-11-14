package use_case.signup.interface_adapter;

/**
 * The state for the Signup View Model.
 */
public class SignupState {
    private String username = "";
    private String usernameError;
    private String password = "";
    private String passwordError;
    private String name = "";
    private String nameError;
    private String address = "";
    private String addressError;
    private String contactInfo = "";
    private String contactInfoError;

    public String getUsername() {
        return username;
    }
    public String getUsernameError() {
        return usernameError;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setUsernameError(String usernameError) {
        this.usernameError = usernameError;
    }

    public String getPassword() {
        return password;
    }
    public String getPasswordError() {
        return passwordError;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getname() {
        return name;
    }
    public String getnameError() {return nameError;}
    public void setName(String password) {
        this.password = password;
    }
    public void setNameError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getaddress() {return address;}
    public String getaddressError() {return addressError;}
    public void setAddress(String password) {
        this.password = password;
    }
    public void setAddressErrorError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getcontactInfo() {return contactInfo;}
    public String getcontactInfoError() {return contactInfoError;}
    public void setContactInfo(String password) {
        this.password = password;
    }
    public void setContactInfoErrordError(String passwordError) {
        this.passwordError = passwordError;
    }


    @Override
    public String toString() {
        return "SignupState{"
                + "username='" + username + '\''
                + ", password='" + password + '\''
                + ", name='" + name + '\''
                + ", address='" + address + '\''
                + ", contactInfo='" + contactInfo + '\''
                + '}';
    }
}
