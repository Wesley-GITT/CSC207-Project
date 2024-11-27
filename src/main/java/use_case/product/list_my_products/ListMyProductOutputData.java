package use_case.product.list_my_products;

import java.util.Set;

public class ListProductOutputData {

    private final Set<Integer> products;

    public ListProductOutputData(Set<Integer> products) {
        this.products = products;
    }

    public Set<Integer> getProducts() {
        return products;
    }
}
