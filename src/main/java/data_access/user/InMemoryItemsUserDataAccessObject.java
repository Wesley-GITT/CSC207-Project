package data_access.user;

import entity.*;
import use_case.GetOrderDataAccessInterface;
import use_case.GetProductIdDataAccessInterface;
import use_case.SaveOrderDataAccessInterface;
import use_case.SaveProductDataAccessInterface;
import use_case.order.create.CreateOrderDataAccessInterface;
import use_case.user.auth.AuthUserDataAccessInterface;
import use_case.user.list_cart_items.ListCartItemsUserDataAccessInterface;
import use_case.user.reg.RegUserDataAccessInterface;
import use_case.user.show_my_profile.ShowMyProfileUserDataAccessInterface;
import use_case.user.show_other_profile.ShowOtherProfileUserDataAccessInterface;
import use_case.user.update_cart.UpdateCartUserDataAccessInterface;
import use_case.user.update_my_profile.UpdateMyProfileUserDataAccessInterface;
import use_case.user.update_name.UpdateNameUserDataAccessInterface;
import use_case.user.update_pwd.UpdatePasswordUserDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryItemsUserDataAccessObject implements
        AuthUserDataAccessInterface,
        RegUserDataAccessInterface,
        ListCartItemsUserDataAccessInterface,
        ShowMyProfileUserDataAccessInterface,
        ShowOtherProfileUserDataAccessInterface,
        UpdateCartUserDataAccessInterface,
        UpdateMyProfileUserDataAccessInterface,
        UpdateNameUserDataAccessInterface,
        UpdatePasswordUserDataAccessInterface,
        GetProductIdDataAccessInterface,
        SaveProductDataAccessInterface,
        GetOrderDataAccessInterface,
        SaveOrderDataAccessInterface,
        CreateOrderDataAccessInterface {

    private final Map<Integer, Product> products = new HashMap<>();
    private final Map<Integer, Order> orders = new HashMap<>();
    private final Map<String, MyUser> usersByName = new HashMap<>();
    private final Map<Integer, MyUser> usersById = new HashMap<>();

    @Override
    public boolean doesUserExist(String username) {
        return usersByName.containsKey(username);
    }

    @Override
    public boolean isAuthenticated(String username, String password) {
        if (!doesUserExist(username)) {
            return false;
        }

        MyUser u = usersByName.get(username);

        if (u.getPassword() != password) {
            return false;
        }

        return true;
    }

    @Override
    public MyUser get(String username, String password) {
        return usersByName.get(username);
    }

    @Override
    public void save(MyUser user) {
        usersByName.put(user.getUsername(), user);
        usersById.put(user.getId(), user);
    }

    @Override
    public void add(MyUser user) {
        usersByName.put(user.getUsername(), user);
        usersById.put(user.getId(), user);
    }

    @Override
    public boolean doesUserExistById(int id) {
        return usersById.containsKey(id);
    }

    @Override
    public OtherUser getOther(int id) {
        OtherUserFactory userFactory = new OtherUserFactory();
        return userFactory.create(usersById.get(id));
    }

    @Override
    public Product getProductById(int productId) {
        return products.get(productId);
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    @Override
    public void saveOrder(Order order) {
        orders.put(order.getId(), order);
    }
}
