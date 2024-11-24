package use_case.order;

import entity.Order;

public interface GetOrderDataAccessInterface {

    Order getOrder(int orderId);
}
