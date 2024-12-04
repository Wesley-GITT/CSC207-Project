package use_case.product.list_my_products;

import java.util.Set;

public class ListMyProductOutputData {

    private final Set<Integer> productIds;

    public ListMyProductOutputData(Set<Integer> productIds) {
        this.productIds = productIds;
    }

    public Set<Integer> getProductIds() {
        return productIds;
    }
}

