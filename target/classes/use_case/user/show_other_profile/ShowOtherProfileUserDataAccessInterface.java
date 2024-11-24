package use_case.user.show_other_profile;

import entity.OtherUser;
import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface ShowOtherProfileUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {

    boolean doesUserExistById(int id);

    OtherUser getOther(int id);
}
