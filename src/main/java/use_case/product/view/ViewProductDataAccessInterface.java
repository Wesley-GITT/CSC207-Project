package use_case.product.view;

import use_case.product.ProductExistDataAccessInterface;
import use_case.product.ProductGetDataAccessInterface;

public interface ViewProductDataAccessInterface extends
        ProductExistDataAccessInterface,
        ProductGetDataAccessInterface {
}

