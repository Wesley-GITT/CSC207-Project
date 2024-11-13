package use_case.order;

/*
This data class encapsulates the input data needed to create, cancel, or complete an order.
 */
public class OrderInputData {
    private Integer bookId;
    private String buyer;

    // Constructor
    public OrderInputData(Integer bookId, String buyer) {
        this.bookId = bookId;
        this.buyer = buyer;
    }

    public Integer getBookId() {
        return bookId;
    }
    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBuyer() {
        return buyer;
    }
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }
}
