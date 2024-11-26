package use_case.book.viewsearchbook;

public class ViewBookInputData {

    private final String bookId;

    public ViewBookInputData(String bookId) {
        this.bookId = bookId;
    }

    public String getBookId() {
        return bookId;
    }
}
