package use_case.order;

import entity.Order;

import java.util.List;

public interface getOrdersBySellerIdDataAccessInterface {

    List<Order> getOrdersBySellerId(int sellerId);
}
