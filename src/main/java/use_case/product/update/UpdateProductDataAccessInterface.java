package use_case.product.update;

import use_case.product.ProductExistDataAccessInterface;
import use_case.product.ProductGetDataAccessInterface;
import use_case.product.ProductSaveDataAccessInterface;

public interface UpdateProductDataAccessInterface extends
        ProductExistDataAccessInterface,
        ProductGetDataAccessInterface,
        ProductSaveDataAccessInterface {
}
