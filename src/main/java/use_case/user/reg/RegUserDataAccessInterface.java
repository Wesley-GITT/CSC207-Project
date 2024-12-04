package use_case.user.reg;

import entity.MyUser;
import use_case.user.UserExistDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface RegUserDataAccessInterface extends
        UserExistDataAccessInterface,
        UserSaveDataAccessInterface {

    /**
     * Add method for RegUserDataAccessInterface.
     * @param user user
     */
    void add(MyUser user);
}
