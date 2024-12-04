package use_case.user;

import entity.MyUser;

public interface UserGetDataAccessInterface {

    /**
     * Get method for UserGetDataAccessInterface.
     * @param username username
     * @param password password
     * @return MyUser
     */
    MyUser get(String username, String password);
}
