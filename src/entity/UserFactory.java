package entity;

import java.util.Set;

public class UserFactory {

    public OtherUser create(String username, ContactInfo contactInfo, Set<Integer> productIds) {
        return new OtherUser(username, contactInfo, productIds);
    }

    public MyUser create(
            String username, String password, String address, ContactInfo contactInfo, Set<Integer> cartItems, Set<Integer> productIds) {
        return new MyUser(username, password, address, contactInfo, cartItems, productIds);
    }
}
