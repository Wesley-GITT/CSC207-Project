package data_access.order;

import entity.*;
import use_case.order.GetOrderDataAccessInterface;
import use_case.order.SaveOrderDataAccessInterface;
import use_case.order.getOrdersByBuyerIdDataAccessInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryOrderDataAccessObject implements
        GetOrderDataAccessInterface,
        SaveOrderDataAccessInterface,
        getOrdersByBuyerIdDataAccessInterface {

    private final Map<Integer, Order> orders = new HashMap<>();
    private final Map<String, MyUser> usersByName;

    public InMemoryOrderDataAccessObject(Map<String, MyUser> sharedUsersByName) {
        this.usersByName = sharedUsersByName;
    }

    @Override
    public int getBuyerId(String username) {
        MyUser user = usersByName.get(username);
        if (user == null) {
            throw new IllegalStateException("User not found: " + username);
        }
        return user.getId();
    }

    @Override
    public List<Order> getOrdersByBuyerId(int buyerId) {
        List<Order> buyerOrders = new ArrayList<>();
        for (Order order : orders.values()) {
            if (order.getBuyerId() == buyerId) {
                buyerOrders.add(order);
            }
        }
        return buyerOrders;
    }

    @Override
    public Order getOrder(int orderId) {
        return orders.get(orderId);
    }

    @Override
    public void saveOrder(Order order) {
        orders.put(order.getId(), order);
    }

    public void clearOrders() {
        orders.clear();
    }
}
