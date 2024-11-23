package use_case.product.remove;

import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.search.SearchInputData;
import use_case.book.search.SearchOutputBoundary;

public class RemoveProductInteractor implements RemoveProductInputBoundary {

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
