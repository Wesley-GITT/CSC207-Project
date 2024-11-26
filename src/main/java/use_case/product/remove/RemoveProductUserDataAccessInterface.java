package use_case.product.remove;

import use_case.product.ProductExistDataAccessInterface;
import use_case.product.create.CreateProductUserDataAccessInterface;
import use_case.user.*;

public interface RemoveProductUserDataAccessInterface extends
        ProductExistDataAccessInterface,
        CreateProductUserDataAccessInterface {

    void remove(int id);
}

