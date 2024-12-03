package use_case.product.update;

public class UpdateProductInputData {

    private final String username;
    private final String password;
    private final int productId;
    private final String bookCondition;
    private final double price;
    private final boolean isSold;

    public UpdateProductInputData(String username, String password, int productId,
                                  String bookCondition, double price, boolean isSold) {

        this.username = username;
        this.password = password;
        this.productId = productId;
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
