package use_case.order.list_my_orders;

import use_case.user.BasicAuthDataAccessInterface;
import use_case.order.getOrdersByBuyerIdDataAccessInterface;

public interface ListMyOrdersDataAccessInterface extends
        BasicAuthDataAccessInterface,
        getOrdersByBuyerIdDataAccessInterface {
}
