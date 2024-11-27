package data_access.user;

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
