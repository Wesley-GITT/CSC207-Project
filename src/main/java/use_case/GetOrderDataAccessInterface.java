package use_case;

import entity.Order;

public interface GetOrderDataAccessInterface {

    public Order getOrder(int orderId);
}
