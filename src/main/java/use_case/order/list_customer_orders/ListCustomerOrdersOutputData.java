package use_case.order.list_customer_orders;

import java.util.List;

public class ListCustomerOrdersOutputData {

    private final List<Integer> productIds;

    public ListCustomerOrdersOutputData(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }
}
