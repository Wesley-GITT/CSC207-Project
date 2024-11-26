package use_case.book.search;

public interface SearchOutputBoundary {

    /**
     * Prepares the success view with the search results.
     *
     * @param searchOutputData The data encapsulating the search results.
     */
    void prepareSuccessView(SearchOutputData searchOutputData);

    void prepareFailView(String errorMessage);
}
