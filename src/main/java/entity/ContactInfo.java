package entity;

/**
 * The Presenter for the Login Use Case.
 */
public class ContactInfo {

    private String telephone;
    private String email;

    public ContactInfo(String telephone, String email) {
        this.telephone = telephone;
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
