package use_case.product.list_my_products;

import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.search.SearchInputData;
import use_case.book.search.SearchOutputBoundary;

public class ListProductInteractor implements ListProductInputBoundary {

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
