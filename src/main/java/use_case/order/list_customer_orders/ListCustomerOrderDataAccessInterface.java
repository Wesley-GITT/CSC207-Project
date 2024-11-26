package use_case.order.list_customer_orders;

import java.util.Set;

public interface ListCustomerOrderDataAccessInterface {

    Set<Integer> listCustomOrders(int sellerId);
}
