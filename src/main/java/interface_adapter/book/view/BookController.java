package interface_adapter.book.view;

import use_case.book.view.ViewBookInputBoundary;
import use_case.book.view.ViewBookInputData;

/**
 * The controller for the Login Use Case.
 */
public class BookController {

    private final ViewBookInputBoundary viewBookInteractor;

    public BookController(ViewBookInputBoundary viewBookInteractor) {
        this.viewBookInteractor = viewBookInteractor;
    }

    public void execute(String bookId) {
        final ViewBookInputData viewBookInputData = new ViewBookInputData(bookId);
        viewBookInteractor.execute(viewBookInputData);
    }
}
