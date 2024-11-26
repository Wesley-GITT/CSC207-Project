package use_case.order.create;

import entity.Order;
import use_case.order.OrderGetDataAccessInterface;
import use_case.order.OrderSaveDataAccessInterface;

public interface CreateOrderDataAccessInterface extends
        OrderGetDataAccessInterface,
        OrderSaveDataAccessInterface {

    void add(Order order);
}