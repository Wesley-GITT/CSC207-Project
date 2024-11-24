package use_case.product.create;

import use_case.user.*;

public interface CreateProductUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface,
        UserExistDataAccessInterface,
        SaveProductDataAccessInterface {
}
