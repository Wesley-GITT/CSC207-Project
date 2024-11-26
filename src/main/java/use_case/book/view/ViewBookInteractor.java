package use_case.book.view;

import entity.Book;

public class ViewBookInteractor implements ViewBookInputBoundary {

    private final ViewBookDataAccessInterface BookDataAccessObject;
    private final ViewBookOutputBoundary viewBookPresenter;

    /**
     * Constructor to inject the dependencies.
     *
     * @param BookDataAccessObject The data access interface to retrieve the book.
     * @param viewBookPresenter The output boundary to handle the output.
     */
    public ViewBookInteractor(ViewBookDataAccessInterface BookDataAccessObject,
                              ViewBookOutputBoundary viewBookPresenter) {

        this.BookDataAccessObject = BookDataAccessObject;
        this.viewBookPresenter = viewBookPresenter;
    }

    @Override
    public void execute(ViewBookInputData inputData) {
        String bookId = inputData.getBookId();

        // Fetch the book by its ID
        if (!BookDataAccessObject.exist(bookId)) {
            viewBookPresenter.prepareFailView("Book with ID `" + bookId + "` doesn't exist");
            return;
        }

        Book book = BookDataAccessObject.get(bookId);
        ViewBookOutputData outputData = new ViewBookOutputData(
                book.getId(), book.getImageUrl(), book.getTitle(), book.getAuthors(),
                book.getPublisher(), book.getPublishedDate(), book.getDescription(),
                book.getSampleUrl(), book.getLanguage(), book.getCategories()
        );

        viewBookPresenter.prepareSuccessView(outputData);
    }
}
