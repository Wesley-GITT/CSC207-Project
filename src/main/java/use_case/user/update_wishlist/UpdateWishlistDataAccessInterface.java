package use_case.user.update_wishlist;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface UpdateWishlistDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {
}
