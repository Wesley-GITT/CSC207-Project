package use_case.book.search;

public interface SearchBookInputBoundary {

    /**
     * Executes the search operation using the provided input data.
     *
     * @param searchBookInputData The search criteria encapsulated in a SearchBookInputData object.
     */
    void execute(SearchBookInputData searchBookInputData);
}
