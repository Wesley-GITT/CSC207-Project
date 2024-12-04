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

    /**
     * Execute method for SearchBookController.
     * @param keyword keyword for searching.
     * @param startIndex the start index of searching.
     * @param withProduct withProduct boolean.
     */
    public void execute(String keyword, int startIndex, boolean withProduct) {
        final SearchBookInputData searchBookInputData = new SearchBookInputData(keyword, 10, startIndex, withProduct);
        searchBookInteractor.execute(searchBookInputData);
    }
}
