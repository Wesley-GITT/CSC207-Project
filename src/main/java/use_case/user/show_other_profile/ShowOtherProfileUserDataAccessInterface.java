package use_case.user.show_other_profile;

import entity.OtherUser;
import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface ShowOtherProfileUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {

    /**
     * ExistById.
     * @param id id
     * @return boolean
     */
    boolean existById(int id);

    /**
     * GetOther.
     * @param id id
     * @return OtherUser
     */
    OtherUser getOther(int id);
}
