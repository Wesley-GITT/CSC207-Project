package use_case.product.update;

public class UpdateProductInputData {

    private final String username;
    private final String password;
    private final int productId;
    private final String bookId;
    private final String bookCondition;
    private final double price;
    private final boolean isSold;

    public UpdateProductInputData(String username, String password, int productId, String bookId,
                                  String bookCondition, double price, boolean isSold) {

        this.username = username;
        this.password = password;
        this.productId = productId;
        this.bookId = bookId;
        this.bookCondition = bookCondition;
        this.price = price;
        this.isSold = isSold;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getProductId() {
        return productId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public double getPrice() {
        return price;
    }

    public boolean getIsSold() {
        return isSold;
    }
}
