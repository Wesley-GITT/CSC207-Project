package entity;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyUser extends OtherUser {

    private String password;
    private String address;
    private Set<Integer> cartItems;
    private Set<Integer> products;

    public MyUser(int id, String username, String password, String address, ContactInfo contactInfo, Set<Integer> cartItems, Set<Integer> products) {
        super(id, username, contactInfo);
        this.password = password;
        this.address = address;
        this.cartItems = new HashSet<>();
        this.setCartItems(cartItems);
        this.products = new HashSet<>();
        this.products.addAll(products);
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

    public Set<Integer> getCartItems() {
        // don't allow code of other scope to modify cartItems without using setter
        return Set.copyOf(this.cartItems);
    }

    public void setCartItems(Set<Integer> cartItems) {
        // add and remove manually to save memory for copying
        Iterator<Integer> selfCartItemsIterator = this.cartItems.iterator();
        while (selfCartItemsIterator.hasNext()) {
            Integer cartItem = selfCartItemsIterator.next();
            if (!cartItems.contains(cartItem)) {
                selfCartItemsIterator.remove();
            }
        }

        Iterator<Integer> resultantCartItemsIterator = cartItems.iterator();
        while (resultantCartItemsIterator.hasNext()) {
            Integer cartItem = resultantCartItemsIterator.next();
            if (!this.cartItems.contains(cartItem)) {
                this.cartItems.add(cartItem);
            }
        }
    }

    public Set<Integer> getProducts() {
        return Set.copyOf(this.cartItems);
    }

    public void setProducts(Set<Integer> products) {
        Iterator<Integer> selfProductsIterator = this.products.iterator();
        while (selfProductsIterator.hasNext()) {
            Integer product = selfProductsIterator.next();
            if (!products.contains(product)) {
                selfProductsIterator.remove();
            }
        }

        Iterator<Integer> resultantProductsIterator = products.iterator();
        while (resultantProductsIterator.hasNext()) {
            Integer product = resultantProductsIterator.next();
            if (!this.products.contains(product)) {
                this.products.add(product);
            }
        }
    }
}
