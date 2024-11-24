package use_case.book.viewsearchbook;

import entity.Book;
import use_case.book.viewsearchbook.*;

public class ViewBookInteractor implements ViewBookInputBoundary {

    private final ViewBookDataAccessInterface dataAccess;
    private final ViewBookOutputBoundary outputBoundary;

    /**
     * Constructor to inject the dependencies.
     *
     * @param dataAccess The data access interface to retrieve the book.
     * @param outputBoundary The output boundary to handle the output.
     */
    public ViewBookInteractor(ViewBookDataAccessInterface dataAccess, ViewBookOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(ViewBookInputData inputData) {
        String bookId = inputData.getBookId();

        // Fetch the book by its ID
        Book book = dataAccess.findBookById(bookId);

        if (book != null) {
            // Prepare success view with the book details
            ViewBookOutputData outputData = new ViewBookOutputData(book);
            outputBoundary.prepareSuccessView(outputData);
        } else {
            // Prepare fail view with an error message
            outputBoundary.prepareFailView("Book with ID " + bookId + " not found.");
        }
    }
}
