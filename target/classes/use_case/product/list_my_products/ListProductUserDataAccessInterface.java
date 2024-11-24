package use_case.product.list_my_products;

import use_case.user.*;

public interface ListProductUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface,
        SaveProductDataAccessInterface,
        UserExistDataAccessInterface {
}