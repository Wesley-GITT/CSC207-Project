package use_case.user.update_name;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserExistDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface UpdateNameUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserExistDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {
}
