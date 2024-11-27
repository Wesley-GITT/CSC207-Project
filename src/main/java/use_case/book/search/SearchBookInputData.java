package use_case.book.search;

public class SearchBookInputData {

    private final String queryKeyword;
    private final String queryTitle;
    private final String queryAuthor;
    private final String queryPublisher;
    private final String querySubject;
    private final String queryIsbn;

    private final String langRestrict;
    private final int maxResults;
    private final String orderBy;
    private final int startIndex;

    public SearchBookInputData(String queryKeyword, String queryTitle, String queryAuthor, String queryPublisher,
                               String querySubject, String queryIsbn, String langRestrict, int maxResults,
                               String orderBy, int startIndex) {

        this.queryKeyword = queryKeyword;
        this.queryTitle = queryTitle;
        this.queryAuthor = queryAuthor;
        this.queryPublisher = queryPublisher;
        this.querySubject = querySubject;
        this.queryIsbn = queryIsbn;
        this.langRestrict = langRestrict;
        this.maxResults = maxResults;
        this.orderBy = orderBy;
        this.startIndex = startIndex;
    }

    public String getQueryKeyword() {
        return queryKeyword;
    }

    public String getQueryTitle() {
        return queryTitle;
    }

    public String getQueryAuthor() {
        return queryAuthor;
    }

    public String getQueryPublisher() {
        return queryPublisher;
    }

    public String getQuerySubject() {
        return querySubject;
    }

    public String getQueryIsbn() {
        return queryIsbn;
    }

    public String getLangRestrict() {
        return langRestrict;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public int getStartIndex() {
        return startIndex;
    }
}
