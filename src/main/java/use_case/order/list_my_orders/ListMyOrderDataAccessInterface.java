package use_case.order.list_my_orders;

import java.util.Set;

public interface ListMyOrderDataAccessInterface {

    Set<Integer> listMyOrders(int sellerId);
}
