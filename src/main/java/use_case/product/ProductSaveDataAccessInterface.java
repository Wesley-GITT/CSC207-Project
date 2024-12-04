package use_case.product;

import entity.Product;

public interface ProductSaveDataAccessInterface {

    /**
     * Save method for ProductSaveDataAccessInterface.
     * @param product product
     */
    void save(Product product);
}
