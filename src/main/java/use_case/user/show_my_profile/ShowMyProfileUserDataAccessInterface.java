package use_case.user.show_my_profile;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface ShowMyProfileUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {
}
