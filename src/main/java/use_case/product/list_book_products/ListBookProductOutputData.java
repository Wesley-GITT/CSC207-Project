package use_case.product.list_book_products;

import java.util.Set;

public class ListBookProductOutputData {

    private final Set<Integer> productIds;

    public ListBookProductOutputData(Set<Integer> productIds) {
        this.productIds = productIds;
    }

    public Set<Integer> getProductIds() {
        return productIds;
    }
}
