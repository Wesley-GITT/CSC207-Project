package use_case.change_password;

/**
 * The input data for the Change Password Use Case.
 */
public class ChangePasswordInputData {

    private final String password;
    private final String username;
    private final String name;
    private final String address;
    private final String contactInfo;


    public ChangePasswordInputData(String username, String password, String name, String address, String contactInfo) {
        this.password = password;
        this.username = username;
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
    }

    String getPassword() {
        return password;
    }

    String getUsername() {
        return username;
    }

    String getName() {return name;}

    String getAddress() {return address;}

    String getContactInfo() {return contactInfo;}

}
