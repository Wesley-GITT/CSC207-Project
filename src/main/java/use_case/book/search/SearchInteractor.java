package use_case.book.search;

import entity.Book;
import java.util.List;

public class SearchInteractor implements SearchInputBoundary {

    private final SearchBookDataAccessInterface dataAccess;
    private final SearchOutputBoundary outputBoundary;

    /**
     * Constructor to initialize dependencies.
     *
     * @param dataAccess The data access interface for searching books.
     * @param outputBoundary The output boundary for handling the results.
     */
    public SearchInteractor(SearchBookDataAccessInterface dataAccess, SearchOutputBoundary outputBoundary) {
        this.dataAccess = dataAccess;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(SearchInputData inputData) {
        try {
            // Perform the search using the data access interface
            List<Book> books = dataAccess.searchBooks(inputData.getKeyword());

            if (books.isEmpty()) {
                outputBoundary.prepareFailView("No books found for keyword: " + inputData.getKeyword());
            } else {
                SearchOutputData outputData = new SearchOutputData(books, "Search successful.");
                outputBoundary.prepareSuccessView(outputData);
            }
        } catch (Exception e) {
            outputBoundary.prepareFailView("An error occurred during the search: " + e.getMessage());
        }
    }
}
