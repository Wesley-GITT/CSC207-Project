package data_access.user;

import entity.MyUser;
import entity.Product;
import use_case.product.create.CreateProductUserDataAccessInterface;
import use_case.product.list_my_products.ListProductUserDataAccessInterface;
import use_case.product.remove.RemoveProductUserDataAccessInterface;
import use_case.user.SaveProductDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductsUserDataAccessObject implements
        CreateProductUserDataAccessInterface,
        ListProductUserDataAccessInterface,
        RemoveProductUserDataAccessInterface,
        SaveProductDataAccessInterface {

    private final HashMap<Integer, Product> productsById = new HashMap<>();
    private final HashMap<String, Product> productsBySellerId = new HashMap<>();
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

        return u.getPassword().equals(password);
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
    public void saveProduct(Product product) {
        productsById.put(product.getId(), product);
        productsBySellerId.put(product.getSellerId(), product);
    }

}
