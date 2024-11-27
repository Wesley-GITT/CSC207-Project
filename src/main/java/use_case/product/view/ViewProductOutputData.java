package use_case.product.view;

public class ViewProductOutputData {

    private final int productId;
    private final String bookId;
    private final int sellerId;
    private final String bookCondition;
    private final double price;
    private final boolean isSold;

    public ViewProductOutputData(int productId, String bookId, int sellerId,
                                 String bookCondition, double price, boolean isSold) {

        this.productId = productId;
        this.bookId = bookId;
        this.sellerId = sellerId;
        this.bookCondition = bookCondition;
        this.price = price;
        this.isSold = isSold;
    }

    public int getProductId() {
        return productId;
    }

    public String getBookId() {
        return bookId;
    }

    public int getSellerId() {
        return sellerId;
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
