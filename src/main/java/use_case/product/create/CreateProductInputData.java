package use_case.product.create;

public class CreateProductInputData {

    private int id;
    private String bookId;
    private String sellerId;
    private String bookCondition;
    private float price;
    private boolean sold;

    public CreateProductInputData(int id, String bookId, String sellerId, String bookCondition, float price, boolean sold) {
        this.id = id;
        this.bookId = bookId;
        this.sellerId = sellerId;
        this.bookCondition = bookCondition;
        this.price = price;
        this.sold = sold;
    }

    public Integer getProductId() {
        return id;
    }
    public void setProductId(Integer id) {
        this.id = id;
    }

    public String getBookId() {return bookId;}
    public void setBookId(String bookId) {this.bookId = bookId;}

    public String getSellerId() {return sellerId;}
    public void setSellerId(String sellerId) {this.sellerId = sellerId;}

    public String getBookCondition() {return bookCondition;}
    public void setBookCondition(String bookCondition) {this.bookCondition = bookCondition;}

    public float getPrice() {return price;}
    public void setPrice(float price) {this.price = price;}

    public boolean isSold() {return sold;}
    public void setSold(boolean sold) {this.sold = sold;}


}
