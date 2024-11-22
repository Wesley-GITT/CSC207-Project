package use_case.user.list_cart_items;

import java.util.Set;

public class ListCartItemsOutputData {

    private final Set<Integer> cartItems;

    public ListCartItemsOutputData(Set<Integer> cartItems) {
        this.cartItems = cartItems;
    }

    public Set<Integer> getCartItems() {
        return cartItems;
    }
}
