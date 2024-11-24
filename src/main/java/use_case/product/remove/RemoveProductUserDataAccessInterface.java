package use_case.product.remove;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserExistDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface RemoveProductUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserExistDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {
}

