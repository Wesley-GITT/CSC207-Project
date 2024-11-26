package use_case.order.list_customer_orders;

import java.util.Set;

public interface ListCustomerOrdersDataAccessInterface {

    Set<Integer> listCustomOrders(int sellerId);
}
