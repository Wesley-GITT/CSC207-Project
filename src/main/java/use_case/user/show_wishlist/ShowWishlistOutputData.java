package use_case.user.show_wishlist;

import java.util.Set;

public class ShowWishlistOutputData {

    private final Set<Integer> wishlist;

    public ShowWishlistOutputData(Set<Integer> wishlist) {
        this.wishlist = wishlist;
    }

    public Set<Integer> getWishlist() {
        return wishlist;
    }
}
