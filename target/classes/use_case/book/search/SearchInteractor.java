package use_case.book.search;

public class SearchInteractor implements SearchInputBoundary {

    private final SearchBookDataAccessInterface bookDataAccessInterface;
    private final SearchOutputBoundary searchPresenter;


    public SearchInteractor(SearchBookDataAccessInterface bookDataAccessInterface, SearchOutputBoundary searchPresenter) {
        this.bookDataAccessInterface = bookDataAccessInterface;
        this.searchPresenter = searchPresenter;
    }

    @Override
    public void execute(SearchInputData searchInputData) {

    }
}
