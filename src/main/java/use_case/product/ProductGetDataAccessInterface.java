package use_case.product;

import entity.Product;

public interface ProductGetDataAccessInterface {

    /**
     * Get method for ProductGetDataAccessInterface.
     * @param id id
     * @return Product
     */
    Product get(int id);
}
