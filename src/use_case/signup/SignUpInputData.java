package use_case.signup;

/*
A data class for sign-up input
 */
public class SignUpInputData {
    private String username;
    private String password;
    private String name;
    private String address;
    private String contactInfo;

    public SignUpInputData(String username, String password, String name, String address, String contactInfo) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    // Getters, and Setters
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getAddress() {return address;}
    public void setAddress(String address) {this.address = address;}

    public String getContactInfo() {return contactInfo;}
    public void setContactInfo(String contactInfo) {this.contactInfo = contactInfo;}

}
