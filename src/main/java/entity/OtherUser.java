package entity;

public class OtherUser {

    protected int id;
    protected String username;
    protected ContactInfo contactInfo;

    public OtherUser(int id, String username, ContactInfo contactInfo) {
        this.id = id;
        this.username = username;
        this.contactInfo = contactInfo;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return contactInfo.getEmail();
    }

    public String getTelephone() {
        return contactInfo.getTelephone();
    }
}
