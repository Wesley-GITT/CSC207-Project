package use_case.book.viewsearchbook;

import use_case.book.viewsearchbook.ViewBookInputData;

public interface ViewBookInputBoundary {

    /**
     * Executes the use case to view a book's details.
     *
     * @param inputData The input data containing the book ID.
     */
    void execute(ViewBookInputData inputData);
}
