package entity;

public class OtherUserFactory {

    public OtherUser create(int id, String username, ContactInfo contactInfo) {
        return new OtherUser(id, username, contactInfo);
    }

    public OtherUser create(String username) {
        return new OtherUser(-1, username, new ContactInfo(null, null));
    }

    public OtherUser create(MyUser user) {
        return new OtherUser(user.id, user.username, new ContactInfo(user.getTelephone(), user.getEmail()));
    }
}
