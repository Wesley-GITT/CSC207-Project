package use_case.order.list_customer_orders;

import java.util.Set;

public class ListCustomerOrdersOutputData {

    private final Set<Integer> orderIds;

    public ListCustomerOrdersOutputData(Set<Integer> orderIds) {
        this.orderIds = orderIds;
    }

    public Set<Integer> getOrderIds() {
        return orderIds;
    }
}
