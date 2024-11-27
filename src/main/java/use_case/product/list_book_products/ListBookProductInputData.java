package use_case.product.list_book_products;

public class ListBookProductInputData {
    private final String bookId;

    public ListBookProductInputData(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
