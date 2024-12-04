package entity;

/**
 * The Presenter for the Login Use Case.
 */
public class OtherUserFactory {

    /**
     * The Presenter for the Login Use Case.
     * @param username :
     * @param contactInfo :
     * @param id :
     * @return :
     */
    public OtherUser create(int id, String username, ContactInfo contactInfo) {
        return new OtherUser(id, username, contactInfo);
    }

    /**
     * The Presenter for the Login Use Case.
     * @param username :
     * @return :
     */
    public OtherUser create(String username) {
        return new OtherUser(-1, username, new ContactInfo(null, null));
    }

    /**
     * The Presenter for the Login Use Case.
     * @param user :
     * @return :
     */
    public OtherUser create(MyUser user) {
        return new OtherUser(user.id, user.username, new ContactInfo(user.getTelephone(), user.getEmail()));
    }
}
