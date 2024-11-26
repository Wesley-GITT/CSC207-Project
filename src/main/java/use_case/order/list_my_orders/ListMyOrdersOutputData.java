package use_case.order.list_my_orders;

import java.util.Set;

public class ListMyOrdersOutputData {

    private final Set<Integer> orderIds;

    public ListMyOrdersOutputData(Set<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    public Set<Integer> getOrderIds() {
        return orderIds;
    }
}
