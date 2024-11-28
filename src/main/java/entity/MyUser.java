package entity;

public class MyUser extends OtherUser {

    private String password;

    public MyUser(int id, String username, String password, ContactInfo contactInfo) {
        super(id, username, contactInfo);
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.contactInfo.setEmail(email);
    }

    public void setTelephone(String telephone) {
        this.contactInfo.setTelephone(telephone);
    }
}