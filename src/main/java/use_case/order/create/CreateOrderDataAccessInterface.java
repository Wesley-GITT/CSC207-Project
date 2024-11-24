package use_case.order.create;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;
import use_case.order.GetOrderDataAccessInterface;
import use_case.order.SaveOrderDataAccessInterface;
import use_case.order.GetProductIdDataAccessInterface;
import use_case.order.SaveProductDataAccessInterface;

public interface CreateOrderDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface,
        GetOrderDataAccessInterface,
        SaveOrderDataAccessInterface,
        GetProductIdDataAccessInterface,
        SaveProductDataAccessInterface {
}