package use_case.book.search;

import entity.Book;
import java.util.List;

public class SearchOutputData {

    private final List<Book> books;
    private final String message;

    /**
     * Constructor to initialize search output data.
     *
     * @param books The list of books retrieved from the search.
     * @param message A message about the search operation (e.g., "Search successful").
     */
    public SearchOutputData(List<Book> books, String message) {
        this.books = books;
        this.message = message;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getMessage() {
        return message;
    }
}
