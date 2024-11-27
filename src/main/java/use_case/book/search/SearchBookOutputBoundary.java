package use_case.book.search;

public interface SearchBookOutputBoundary {

    /**
     * Prepares the success view with the search results.
     *
     * @param searchBookOutputData The data encapsulating the search results.
     */
    void prepareSuccessView(SearchBookOutputData searchBookOutputData);

    void prepareFailView(String errorMessage);
}
