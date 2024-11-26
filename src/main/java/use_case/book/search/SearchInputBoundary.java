package use_case.book.search;

public interface SearchInputBoundary {

    /**
     * Executes the search operation using the provided input data.
     *
     * @param searchInputData The search criteria encapsulated in a SearchInputData object.
     */
    void execute(SearchInputData searchInputData);
}
