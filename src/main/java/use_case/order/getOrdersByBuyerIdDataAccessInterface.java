package use_case.order;

import entity.Order;

import java.util.List;

public interface getOrdersByBuyerIdDataAccessInterface {

    int getBuyerId(String username);
    List<Order> getOrdersByBuyerId(int buyerId);
}
