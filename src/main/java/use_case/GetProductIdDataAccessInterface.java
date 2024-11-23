package use_case;

import entity.Product;

public interface GetProductIdDataAccessInterface {

    public Product getProductById(int productId);
}
