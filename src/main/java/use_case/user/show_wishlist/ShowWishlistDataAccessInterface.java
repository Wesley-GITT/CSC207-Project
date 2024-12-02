package use_case.user.show_wishlist;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;

public interface ShowWishlistDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface {
}
