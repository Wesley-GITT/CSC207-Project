package entity;

import java.util.Set;

public class MyUser extends OtherUser implements User {

    private String password;
    private String address;
    private Set<Integer> cartItems;

    public MyUser(String username, String password, String address, ContactInfo contactInfo, Set<Integer> cartItems, Set<Integer> productIds) {
        super(username, contactInfo, productIds);
        this.password = password;
        this.address = address;
        this.cartItems = cartItems;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.contactInfo.setEmail(email);
    }

    public void setTelephone(String telephone) {
        this.contactInfo.setTelephone(telephone);
    }

    public void addCartItem(int productId) {
        this.cartItems.add(productId);
    }

    public void removeCartItem(int productId) {
        this.cartItems.remove(productId);
    }

    public void addProduct(int productId) {
        this.productIds.add(productId);
    }

    public void removeProduct(int productId) {
        this.productIds.remove(productId);
    }
}
