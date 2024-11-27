package data_access.order;

import entity.*;
import use_case.order.cancel.CancelOrderDataAccessInterface;
import use_case.order.create.CreateOrderDataAccessInterface;
import use_case.order.list_customer_orders.ListCustomerOrdersDataAccessInterface;
import use_case.order.list_my_orders.ListMyOrdersDataAccessInterface;
import use_case.order.view.ViewOrderDataAccessInterface;

import java.util.*;

public class InMemoryOrderOrdersOrdersDataAccessObject implements
        CancelOrderDataAccessInterface,
        CreateOrderDataAccessInterface,
        ListCustomerOrdersDataAccessInterface,
        ListMyOrdersDataAccessInterface,
        ViewOrderDataAccessInterface {

    private final Map<Integer, Order> orders = new HashMap<>();

    @Override
    public Order get(int id) {
        return orders.get(id);
    }

    @Override
    public void save(Order order) {
        orders.put(order.getId(), order);
    }

    @Override
    public void remove(int id) {
        orders.remove(id);
    }

    @Override
    public boolean exist(int id) {
        return orders.containsKey(id);
    }

    @Override
    public void add(Order order) {
        order.setId(orders.size());
        save(order);
    }

    @Override
    public Set<Integer> listCustomOrders(int sellerId) {
        Set<Integer> orderIds = new HashSet<>();
        for (Order order: orders.values()) {
            if (order.getSellerId() == sellerId) {
                orderIds.add(order.getId());
            }
        }
        return orderIds;
    }

    @Override
    public Set<Integer> listMyOrders(int buyerId) {
        Set<Integer> orderIds = new HashSet<>();
        for (Order order: orders.values()) {
            if (order.getBuyerId() == buyerId) {
                orderIds.add(order.getId());
            }
        }
        return orderIds;
    }
}
