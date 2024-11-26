package use_case.book.search;

public class SearchBookInteractor implements SearchBookInputBoundary {

    private final SearchBookDataAccessInterface bookDataAccessObject;
    private final SearchBookOutputBoundary searchBookPresenter;

    /**
     * Constructor to initialize dependencies.
     *
     * @param bookDataAccessObject The data access interface for searching books.
     * @param searchBookPresenter The output boundary for handling the results.
     */
    public SearchBookInteractor(SearchBookDataAccessInterface bookDataAccessObject, SearchBookOutputBoundary searchBookPresenter) {
        this.bookDataAccessObject = bookDataAccessObject;
        this.searchBookPresenter = searchBookPresenter;
    }

    @Override
    public void execute(SearchBookInputData inputData) {

    }
}
