package data_access.product;

import entity.MyUser;
import entity.Product;
import use_case.product.update.UpdateProductDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductDataAccessObject implements
        UpdateProductDataAccessInterface {

    private final HashMap<Integer, Product> productsById = new HashMap<>();
    private final Map<String, MyUser> usersByName = new HashMap<>();
    private final Map<Integer, MyUser> usersById = new HashMap<>();

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
