package use_case.product.remove;

import use_case.user.*;

public interface RemoveProductUserDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserExistDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface,
        SaveProductDataAccessInterface {
}

