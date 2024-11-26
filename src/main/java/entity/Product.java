package entity;

public class Product {

    private int id;
    private String bookId;
    private int sellerId;
    private String bookCondition;
    private float price;
    private boolean isSold;

    public Product(int id, String bookId, int sellerId, String bookCondition, float price, boolean isSold) {
        this.id = id;
        this.bookId = bookId;
        this.sellerId = sellerId;
        this.bookCondition = bookCondition;
        this.price = price;
        this.isSold = isSold;
    }

    public int getId() {
        return id;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public String getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(String bookCondition) {
        this.bookCondition = bookCondition;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean getIsSold() {
        return isSold;
    }

    public void setIsSold(boolean sold) {
        this.isSold = sold;
    }
}
