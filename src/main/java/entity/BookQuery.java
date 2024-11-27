package entity;

public class BookQuery {

    private String queryKeyword;
    private String queryTitle;
    private String queryAuthor;
    private String queryPublisher;
    private String querySubject;
    private String queryIsbn;

    private String langRestrict;
    private int maxResults;
    private String orderBy;
    private int startIndex;

    public BookQuery(String queryKeyword, String queryTitle, String queryAuthor, String queryPublisher,
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

    public void setQueryKeyword(String queryKeyword) {
        this.queryKeyword = queryKeyword;
    }

    public void setQueryTitle(String queryTitle) {
        this.queryTitle = queryTitle;
    }

    public void setQueryAuthor(String queryAuthor) {
        this.queryAuthor = queryAuthor;
    }

    public void setQueryPublisher(String queryPublisher) {
        this.queryPublisher = queryPublisher;
    }

    public void setQuerySubject(String querySubject) {
        this.querySubject = querySubject;
    }

    public void setQueryIsbn(String queryIsbn) {
        this.queryIsbn = queryIsbn;
    }

    public void setLangRestrict(String langRestrict) {
        this.langRestrict = langRestrict;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }
}
