package use_case.product.update;

public class UpdateProductOutputData {

    private final int productId;
    private final String bookCondition;
    private final double price;
    private final boolean isSold;

    public UpdateProductOutputData(int productId, String bookCondition, double price, boolean isSold) {
        this.productId = productId;
        this.bookCondition = bookCondition;
        this.price = price;
        this.isSold = isSold;
    }

    public int getProductId() {
        return productId;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public double getPrice() {
        return price;
    }

    public boolean isSold() {
        return isSold;
    }
}
