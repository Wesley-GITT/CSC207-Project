package use_case.product.create;

public class CreateProductInputData {

    private final String username;
    private final String password;
    private final int id;
    private final String bookId;
    private final String sellerId;
    private final String bookCondition;
    private final float price;
    private final boolean sold;

    public CreateProductInputData(String username, String password, int id, String bookId, String sellerId, String bookCondition, float price, boolean sold) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.bookId = bookId;
        this.sellerId = sellerId;
        this.bookCondition = bookCondition;
        this.price = price;
        this.sold = sold;
    }

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public Integer getProductId() {
        return id;
    }

    public String getBookId() {return bookId;}

    public String getSellerId() {return sellerId;}

    public String getBookCondition() {return bookCondition;}

    public float getPrice() {return price;}

    public boolean isSold() {return sold;}

}
