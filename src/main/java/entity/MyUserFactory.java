package entity;

public class MyUserFactory {

    public MyUser create(int id, String username, String password, ContactInfo contactInfo) {
        return new MyUser(id, username, password, contactInfo);
    }

    public MyUser create(String username, String password) {
        return new MyUser(-1, username, password, new ContactInfo("", ""));
    }
}
