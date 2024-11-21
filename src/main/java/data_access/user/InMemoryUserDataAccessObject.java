package data_access.user;

import entity.MyUser;
import entity.OtherUser;
import use_case.user.auth.AuthUserDataAccessInterface;
import use_case.user.reg.RegUserDataAccessInterface;
import use_case.user.show_cart.ShowCartUserDataAccessInterface;
import use_case.user.show_my_profile.ShowMyProfileUserDataAccessInterface;
import use_case.user.show_other_profile.ShowOtherProfileUserDataAccessInterface;
import use_case.user.update_cart.UpdateCartUserDataAccessInterface;
import use_case.user.update_my_profile.UpdateMyProfileUserDataAccessInterface;
import use_case.user.update_name.UpdateNameUserDataAccessInterface;
import use_case.user.update_pwd.UpdatePasswordUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryUserDataAccessObject implements
        AuthUserDataAccessInterface,
        RegUserDataAccessInterface,
        ShowCartUserDataAccessInterface,
        ShowMyProfileUserDataAccessInterface,
        ShowOtherProfileUserDataAccessInterface,
        UpdateCartUserDataAccessInterface,
        UpdateMyProfileUserDataAccessInterface,
        UpdateNameUserDataAccessInterface,
        UpdatePasswordUserDataAccessInterface {

    private final Map<String, MyUser> users = new HashMap<>();
    private final Map<Integer, OtherUser> otherUsers = new HashMap<>();

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
    public void save(MyUser user) { users.put(user.getUsername(), user); }

    public void saveOther(OtherUser user) { otherUsers.put(user.getId(), user); }

    @Override
    public void add(MyUser user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public boolean doesUserExistById(int id) {
        return otherUsers.containsKey(id);
    }

    @Override
    public OtherUser getOther(int id) {
        return otherUsers.get(id);
    }
}
