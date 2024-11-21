package use_case.user.show_cart;

import java.util.Set;

public class ShowCartOutputData {

    private final Set<Integer> cartItems;

    public ShowCartOutputData(Set<Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<Integer> getCartItems() {
        return cartItems;
    }
}
