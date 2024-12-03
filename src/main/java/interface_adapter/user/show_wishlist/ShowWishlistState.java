package interface_adapter.user.show_wishlist;

import java.util.Set;

/**
 * The state for the ShowWishlist View Model.
 */
public class ShowWishlistState {
    private Set<Integer> wishlist;
    private String ShowWishlistError;

    public Set<Integer> getWishlist() {
        return wishlist;
    }

    public void setWishlist(Set<Integer> wishlist) {
        this.wishlist = wishlist;
    }

    public String getShowWishlistError() {
        return ShowWishlistError;
    }

    public void setShowWishlistError(String showWishlistError) {
        this.ShowWishlistError = showWishlistError;
    }
}
