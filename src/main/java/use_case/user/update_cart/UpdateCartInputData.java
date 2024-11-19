package use_case.user.update_cart;

import java.util.Set;

public class UpdateCartInputData {

    private final String username;
    private final String password;
    private final Set<Integer> cartItems;

    public UpdateCartInputData(String username, String password, Set<Integer> cartItems) {
        this.username = username;
        this.password = password;
        this.cartItems = cartItems;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Integer> getCartItems() {
        return cartItems;
    }
}
