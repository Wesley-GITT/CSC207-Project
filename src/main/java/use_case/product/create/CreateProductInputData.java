package use_case.product.create;

public class CreateProductInputData {

    private final String username;
    private final String password;
    private final String bookId;
    private final String bookCondition;
    private final double price;

    public CreateProductInputData(String username, String password, String bookId, String bookCondition, double price) {
        this.username = username;
        this.password = password;
        this.bookId = bookId;
        this.bookCondition = bookCondition;
        this.price = price;
    }

    public String getUsername() {return username;}

    public String getPassword() {return password;}

    public String getBookId() {return bookId;}

    public String getBookCondition() {return bookCondition;}

    public double getPrice() {return price;}

}
