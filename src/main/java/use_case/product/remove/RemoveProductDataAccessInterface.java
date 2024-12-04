package use_case.product.remove;

import use_case.product.ProductExistDataAccessInterface;
import use_case.product.ProductGetDataAccessInterface;

public interface RemoveProductDataAccessInterface extends
        ProductExistDataAccessInterface,
        ProductGetDataAccessInterface {

    /**
     * Remove method for RemoveProductDataAccessInterface.
     * @param id id
     */
    void remove(int id);
}

