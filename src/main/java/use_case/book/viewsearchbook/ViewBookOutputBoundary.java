package use_case.book.viewsearchbook;

import use_case.book.viewsearchbook.ViewBookOutputData;

public interface ViewBookOutputBoundary {

    /**
     * Prepares the success view with the book details.
     *
     * @param outputData The output data containing the book details.
     */
    void prepareSuccessView(ViewBookOutputData outputData);

    /**
     * Prepares the failure view with an error message.
     *
     * @param errorMessage A message describing the failure.
     */
    void prepareFailView(String errorMessage);
}
