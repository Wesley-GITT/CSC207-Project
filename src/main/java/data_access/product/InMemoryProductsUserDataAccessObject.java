package data_access.product;

import entity.MyUser;
import entity.Product;
import use_case.product.ProductExistDataAccessInterface;
import use_case.product.ProductGetDataAccessInterface;
import use_case.product.ProductSaveDataAccessInterface;
import use_case.product.create.CreateProductUserDataAccessInterface;
import use_case.product.list_my_products.ListProductUserDataAccessInterface;
import use_case.product.remove.RemoveProductUserDataAccessInterface;

import java.util.*;

public class InMemoryProductsUserDataAccessObject implements
        CreateProductUserDataAccessInterface,
        ListProductUserDataAccessInterface,
        RemoveProductUserDataAccessInterface,
        ProductExistDataAccessInterface,
        ProductGetDataAccessInterface,
        ProductSaveDataAccessInterface {

    private final HashMap<Integer, Product> productsById = new HashMap<>();
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
    public void add(Product product){
        productsById.put(product.getId(), product);
    }

    @Override
    public Set<Integer> list(int userId){
        Set<Integer> result = new HashSet<>();
        Iterator<Product> it = productsById.values().iterator();

        while (it.hasNext()) {
            Product product = it.next();
            if (product.getSellerId() == userId) {
                result.add(product.getId());
            }
        }
        return result;
    }

    @Override
    public void remove(int id){
        productsById.remove(id);
    }

    @Override
    public void save(Product product){
        productsById.put(product.getId(), product);
    }

    @Override
    public boolean exist(int id){
        return productsById.containsKey(id);
    }

    @Override
    public Product get(int id){
        return productsById.get(id);
    }

}
