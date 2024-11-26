package use_case.book.view;

import entity.Book;

public interface ViewBookDataAccessInterface {

    /**
     * get a book by its ID.
     *
     * @param bookId The ID of the book.
     * @return The book entity
     */
    Book get(String bookId);

    /**
     * check if a book exists using its ID.
     *
     * @param bookId The ID of the book.
     * @return True if the book entity if found, otherwise false.
     */
    boolean exist(String bookId);
}