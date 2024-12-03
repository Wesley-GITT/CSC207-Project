package interface_adapter.product.view;

/**
 * The state for the Login View Model.
 */
public class ProductState {
    private int productId;
    private int sellerId;
    private String bookId;
    private String bookCondition;
    private double price;
    private boolean isSold;
    private String viewProductError;

    public String getViewProductError() {
        return viewProductError;
    }

    public void setViewProductError(String viewProductError) {
        this.viewProductError = viewProductError;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public void setSellerId(int sellerId) {
        this.sellerId = sellerId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }
}
