package use_case.product.list_my_products;

import java.util.Set;

public class ListMyProductOutputData {

    private final Set<Integer> products;

    public ListMyProductOutputData(Set<Integer> products) {
        this.products = products;
    }

    public Set<Integer> getProducts() {
        return products;
    }
}
