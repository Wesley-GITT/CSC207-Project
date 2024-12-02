package entity;

import java.util.HashSet;
import java.util.Set;

public class MyUserFactory {

    public MyUser create(int id, String username, String password, ContactInfo contactInfo, Set<Integer> wishlist) {
        return new MyUser(id, username, password, contactInfo, wishlist);
    }

    public MyUser create(String username, String password) {
        return new MyUser(-1, username, password, new ContactInfo("", ""), new HashSet<>());
    }
}
