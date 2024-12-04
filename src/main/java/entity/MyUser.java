package entity;

import java.util.Set;

/**
 * The Presenter for the Login Use Case.
 */
public class MyUser extends OtherUser {

    private String password;
    private Set<Integer> wishlist;

    public MyUser(int id, String username, String password, ContactInfo contactInfo, Set<Integer> wishlist) {
        super(id, username, contactInfo);
        this.password = password;
        this.wishlist = wishlist;
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

    /**
     * The Presenter for the Login Use Case.
     * @param email :
     */
    public void setEmail(String email) {
        this.contactInfo.setEmail(email);
    }

    /**
     * The Presenter for the Login Use Case.
     * @param telephone :
     */
    public void setTelephone(String telephone) {
        this.contactInfo.setTelephone(telephone);
    }

    public Set<Integer> getWishlist() {
        return Set.copyOf(wishlist);
    }

    public void setWishlist(Set<Integer> wishlist) {
        this.wishlist = Set.copyOf(wishlist);
    }
}
