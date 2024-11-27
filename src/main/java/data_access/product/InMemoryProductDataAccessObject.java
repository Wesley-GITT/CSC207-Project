package data_access.product;

import entity.Product;
import use_case.product.create.CreateProductDataAccessInterface;
import use_case.product.list_my_products.ListMyProductDataAccessInterface;
import use_case.product.remove.RemoveProductDataAccessInterface;
import use_case.product.update.UpdateProductDataAccessInterface;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class InMemoryProductDataAccessObject implements
        CreateProductDataAccessInterface,
        UpdateProductDataAccessInterface,
        ListMyProductDataAccessInterface,
        RemoveProductDataAccessInterface {

    private final HashMap<Integer, Product> productsById = new HashMap<>();


    @Override
    public void add(Product product){
        productsById.put(product.getId(), product);
    }

    @Override
    public Set<Integer> list(int userId){
        Set<Integer> result = new HashSet<>();
        for (Product product: productsById.values()) {
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
