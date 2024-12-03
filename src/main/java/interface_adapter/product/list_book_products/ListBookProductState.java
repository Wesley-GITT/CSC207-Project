package interface_adapter.product.list_book_products;

import java.util.Set;

/**
 * The state for the Login View Model.
 */
public class ListBookProductState {
    private Set<Integer> productIds;
    private String listBookProductError;

    public Set<Integer> getProductIds() {
        return productIds;
    }

    public void setProductIds(Set<Integer> productIds) {
        this.productIds = productIds;
    }

    public String getListBookProductError() {
        return listBookProductError;
    }

    public void setListBookProductError(String listBookProductError) {
        this.listBookProductError = listBookProductError;
    }
}
