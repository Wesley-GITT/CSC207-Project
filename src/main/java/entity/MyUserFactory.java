package entity;

import java.util.HashSet;
import java.util.Set;

/**
 * The Presenter for the Login Use Case.
 */
public class MyUserFactory {

    /**
     * The Presenter for the Login Use Case.
     * @param id :
     * @param contactInfo :
     * @param password :
     * @param username :
     * @param wishlist :
     * @return :
     */
    public MyUser create(int id, String username, String password, ContactInfo contactInfo, Set<Integer> wishlist) {
        return new MyUser(id, username, password, contactInfo, wishlist);
    }

    /**
     * The Presenter for the Login Use Case.
     * @param password :
     * @param username :
     * @return :
     */
    public MyUser create(String username, String password) {
        return new MyUser(-1, username, password, new ContactInfo("", ""), new HashSet<>());
    }
}
