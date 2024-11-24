package use_case.product.list_my_products;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface ListProductUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {
}