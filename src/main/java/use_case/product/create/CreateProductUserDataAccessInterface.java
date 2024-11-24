package use_case.product.create;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.SaveProductDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface CreateProductUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface,
        SaveProductDataAccessInterface {
}
