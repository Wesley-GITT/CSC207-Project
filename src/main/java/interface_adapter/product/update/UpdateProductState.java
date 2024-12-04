package interface_adapter.product.update;

/**
 * The state for the Login View Model.
 */
public class UpdateProductState {
    private int productId;
    // set productId to -1 to indicate to create product
    private String bookId;
    private String updateProductError;

    public String getUpdateProductError() {
        return updateProductError;
    }

    public void setUpdateProductError(String updateProductError) {
        this.updateProductError = updateProductError;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }
}
