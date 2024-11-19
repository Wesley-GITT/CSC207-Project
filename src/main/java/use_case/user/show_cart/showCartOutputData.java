package use_case.user.show_cart;

import java.util.Set;

public class showCartOutputData {

    private final Set<Integer> cartItems;

    public showCartOutputData(Set<Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<Integer> getCartItems() {
        return cartItems;
    }
}
