package entity;

import java.util.HashSet;
import java.util.Set;

public class MyUserFactory {

    public MyUser create(int id, String username, String password, String address, ContactInfo contactInfo, Set<Integer> cartItems) {
        return new MyUser(id, username, password, address, contactInfo, cartItems);
    }

    public MyUser create(String username, String password) {
        return new MyUser(-1, username, password, null, new ContactInfo(null, null), new HashSet<Integer>());
    }
}
