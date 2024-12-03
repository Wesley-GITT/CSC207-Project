package interface_adapter.book.search;

import use_case.book.search.SearchBookInputBoundary;
import use_case.book.search.SearchBookInputData;

/**
 * The controller for the Login Use Case.
 */
public class SearchBookController {

    private final SearchBookInputBoundary searchBookInteractor;

    public SearchBookController(SearchBookInputBoundary searchBookInteractor) {
        this.searchBookInteractor = searchBookInteractor;
    }

    public void execute(String keyword, int startIndex, boolean withProduct) {
        final SearchBookInputData searchBookInputData = new SearchBookInputData(keyword, 20, startIndex, withProduct);
        searchBookInteractor.execute(searchBookInputData);
    }
}
