package interface_adapter.product.list_my_products;

import java.util.Set;

/**
 * The state for the Login View Model.
 */
public class ListMyProductState {
    private Set<Integer> productIds;
    private String listMyProductError;

    public Set<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Integer> productIds) {
        this.productIds = productIds;
    }

    public String getListMyProductError() {
        return listMyProductError;
    }

    public void setListMyProductError(String listMyProductError) {
        this.listMyProductError = listMyProductError;
    }
}
