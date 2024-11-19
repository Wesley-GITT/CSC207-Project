package use_case.user.update_cart;

import java.util.Set;

public class UpdateCartOutputData {

    private final Set<Integer> cartItems;

    public UpdateCartOutputData(Set<Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<Integer> getCartItems() {
        return cartItems;
    }
}
