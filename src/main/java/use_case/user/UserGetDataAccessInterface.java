package use_case.user;

import entity.MyUser;

public interface UserGetDataAccessInterface {

    MyUser get(String username, String password);
}
