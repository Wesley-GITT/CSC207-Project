package use_case.user.auth;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserExistDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;

public interface AuthUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserExistDataAccessInterface,
        UserGetDataAccessInterface {

    void setCurrentUsername(String username);

    void setCurrentPassword(String password);

    String getCurrentUsername();

    String getCurrentPassword();
}
