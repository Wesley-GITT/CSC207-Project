package use_case.order.list_my_orders;

import java.util.Set;

public interface ListMyOrdersDataAccessInterface {

    Set<Integer> listMyOrders(int sellerId);
}
