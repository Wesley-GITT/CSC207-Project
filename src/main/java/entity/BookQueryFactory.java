package entity;

public class BookQueryFactory {

    public final static String RELEVANCE = "relevance";
    public final static String NEWEST = "newest";

    public BookQuery create(String queryKeyword, String queryTitle, String queryAuthor, String queryPublisher,
                            String querySubject, String queryIsbn, String langRestrict, int maxResults,
                            String orderBy, int startIndex) {

        return new BookQuery(
                queryKeyword, queryTitle, queryAuthor, queryPublisher, querySubject, queryIsbn,
                langRestrict, maxResults, orderBy, startIndex);
    }

    public BookQuery create(String queryKeyword) {
        return new BookQuery(
                queryKeyword, "", "", "",
                "", "", "en", 10,
                RELEVANCE, 0
        );
    }
}
