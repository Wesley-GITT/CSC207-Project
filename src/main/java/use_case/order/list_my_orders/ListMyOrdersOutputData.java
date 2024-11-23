package use_case.order.list_my_orders;

import java.util.List;

public class ListMyOrdersOutputData {

    private final List<Integer> productIds;

    public ListMyOrdersOutputData(List<Integer> productIds) {
        this.productIds = productIds;
    }

    public List<Integer> getProductIds() {
        return productIds;
    }
}
