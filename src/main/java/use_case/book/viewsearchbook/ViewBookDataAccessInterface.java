package use_case.book.viewsearchbook;

import entity.Book;

public interface ViewBookDataAccessInterface {

    /**
     * Finds a book by its ID.
     *
     * @param bookId The ID of the book.
     * @return The book entity if found, otherwise null.
     */
    Book findBookById(String bookId);
}
