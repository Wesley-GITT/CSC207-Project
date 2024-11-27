package use_case.product.remove;

import use_case.product.ProductExistDataAccessInterface;
import use_case.product.create.CreateProductDataAccessInterface;

public interface RemoveProductDataAccessInterface extends
        ProductExistDataAccessInterface,
        CreateProductDataAccessInterface {

    void remove(int id);
}

