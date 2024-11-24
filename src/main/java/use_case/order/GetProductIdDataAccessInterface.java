package use_case.order;

import entity.Product;

public interface GetProductIdDataAccessInterface {

    Product getProductById(int productId);
}
