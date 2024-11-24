package data_access.product;

import entity.*;
import use_case.order.GetProductIdDataAccessInterface;
import use_case.order.SaveProductDataAccessInterface;

import java.util.HashMap;
import java.util.Map;

public class InMemoryProductDataAccessObject implements
        GetProductIdDataAccessInterface,
        SaveProductDataAccessInterface {

    private final Map<Integer, Product> products = new HashMap<>();

    @Override
    public Product getProductById(int productId) {
        return products.get(productId);
    }

    @Override
    public void saveProduct(Product product) {
        products.put(product.getId(), product);
    }
}
