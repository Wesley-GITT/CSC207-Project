package use_case.book.viewsearchbook;

import entity.Book;

public class ViewBookOutputData {

    private final Book book;

    public ViewBookOutputData(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }
}
