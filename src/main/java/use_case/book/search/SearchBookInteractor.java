package use_case.book.search;

import entity.BookQuery;
import entity.BookQueryFactory;

import java.util.Set;

public class SearchBookInteractor implements SearchBookInputBoundary {

    private final SearchBookDataAccessInterface bookDataAccessObject;
    private final SearchBookOutputBoundary searchBookPresenter;

    /**
     * Constructor to initialize dependencies.
     *
     * @param bookDataAccessObject The data access interface for searching books.
     * @param searchBookPresenter The output boundary for handling the results.
     */
    public SearchBookInteractor(SearchBookDataAccessInterface bookDataAccessObject, SearchBookOutputBoundary searchBookPresenter) {
        this.bookDataAccessObject = bookDataAccessObject;
        this.searchBookPresenter = searchBookPresenter;
    }

    @Override
    public void execute(SearchBookInputData inputData) {

        final String queryKeyword = inputData.getQueryKeyword();
        final String queryTitle = inputData.getQueryTitle();
        final String queryAuthor = inputData.getQueryAuthor();
        final String queryPublisher = inputData.getQueryPublisher();
        final String querySubject = inputData.getQuerySubject();
        final String queryIsbn = inputData.getQueryIsbn();
        final String langRestrict = inputData.getLangRestrict();
        final int maxResults = inputData.getMaxResults();
        final String orderBy = inputData.getOrderBy();
        final int startIndex = inputData.getStartIndex();

        BookQueryFactory factory = new BookQueryFactory();
        BookQuery query = factory.create(
                queryKeyword, queryTitle, queryAuthor, queryPublisher, querySubject, queryIsbn,
                langRestrict, maxResults, orderBy, startIndex);

        final Set<String> bookIds = bookDataAccessObject.search(query);
        final SearchBookOutputData outputData = new SearchBookOutputData(
                bookIds, startIndex, maxResults, orderBy, langRestrict);

        searchBookPresenter.prepareSuccessView(outputData);
    }
}
