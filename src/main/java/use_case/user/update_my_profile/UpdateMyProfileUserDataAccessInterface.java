package use_case.user.update_my_profile;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface UpdateMyProfileUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {
}
