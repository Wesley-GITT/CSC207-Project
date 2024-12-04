package use_case.user;

import entity.MyUser;

public interface UserSaveDataAccessInterface {

    /**
     * Save method for UserSaveDataAccessInterface.
     * @param user user
     */
    void save(MyUser user);
}
