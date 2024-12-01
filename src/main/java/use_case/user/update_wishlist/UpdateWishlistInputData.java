package use_case.user.update_wishlist;

import java.util.Set;

public class UpdateWishlistInputData {

    private final String username;
    private final String password;
    private final Set<Integer> wishlist;

    public UpdateWishlistInputData(String username, String password, Set<Integer> wishlist) {
        this.username = username;
        this.password = password;
        this.wishlist = wishlist;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Set<Integer> getWishlist() {
        return wishlist;
    }
}
