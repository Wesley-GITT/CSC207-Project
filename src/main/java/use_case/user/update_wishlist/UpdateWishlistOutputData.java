package use_case.user.update_wishlist;

import java.util.Set;

public class UpdateWishlistOutputData {

    private final Set<Integer> wishlist;

    public UpdateWishlistOutputData(Set<Integer> wishlist) {
        this.wishlist = wishlist;
    }

    public Set<Integer> getWishlist() {
        return wishlist;
    }
}
