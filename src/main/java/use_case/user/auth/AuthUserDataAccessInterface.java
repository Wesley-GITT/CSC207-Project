package use_case.user.auth;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserExistDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface AuthUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserExistDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {
}
