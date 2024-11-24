package use_case.book.search;

import entity.Book;
import java.util.List;

public interface SearchBookDataAccessInterface {

    /**
     * Searches for books based on a given keyword.
     *
     * @param keyword The search keyword (e.g., title, author, genre).
     * @return A list of Book entities matching the search criteria.
     */
    List<Book> searchBooks(String keyword);

    /**
     * Fetches the detailed information of a book by its title.
     *
     * @param title The title of the book.
     * @return A Book object containing detailed information about the book.
     */
    Book getBookDetailsByTitle(String title);
}
