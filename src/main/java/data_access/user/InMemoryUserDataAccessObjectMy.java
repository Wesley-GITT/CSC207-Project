package data_access.user;

import entity.MyUser;
import use_case.user.auth.AuthUserDataAccessInterface;
import use_case.user.reg.RegUserDataAccessInterface;
import use_case.user.update_my_profile.UpdateMyProfileUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObjectMy implements
        AuthUserDataAccessInterface,
        RegUserDataAccessInterface,
        UpdateMyProfileUserDataAccessInterface {

    private final Map<String, MyUser> users = new HashMap<>();

    private String currentUsername;
    private String currentPassword;

    @Override
    public boolean doesUserExist(String username) {
        return users.containsKey(username);
    }

    @Override
    public boolean isAuthenticated(String username, String password) {
        if (!doesUserExist(username)) {
            return false;
        }

        MyUser u = users.get(username);

        if (u.getPassword() != password) {
            return false;
        }

        return true;
    }

    @Override
    public MyUser get(String username, String password) {
        return users.get(username);
    }

    @Override
    public void save(MyUser user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void add(MyUser user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public void setCurrentUsername(String username) {
        this.currentUsername = username;
    }

    @Override
    public void setCurrentPassword(String password) {
        this.currentPassword = password;
    }

    @Override
    public String getCurrentUsername() {
        return currentUsername;
    }

    @Override
    public String getCurrentPassword() {
        return currentPassword;
    }
}
