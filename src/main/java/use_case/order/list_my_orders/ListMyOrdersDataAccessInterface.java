package use_case.order.list_my_orders;

import entity.Order;
import use_case.user.BasicAuthDataAccessInterface;

import java.util.List;

public interface ListMyOrdersDataAccessInterface extends BasicAuthDataAccessInterface {

    List<Order> getOrdersByBuyerId(int buyerId);
    int getBuyerId(String username);
}
