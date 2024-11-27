package use_case.book.search;

import java.util.Set;

public class SearchBookOutputData {

    private final Set<String> bookIds;
    private final int startIndex;
    private final int maxResults;
    private final String orderBy;
    private final String langRestrict;

    /**
     * Constructor to initialize search output data.
     *
     * @param bookIds The list of bookIds retrieved from the search.
     */
    public SearchBookOutputData(Set<String> bookIds, int startIndex, int maxResults,
                                String orderBy, String langRestrict) {

        this.bookIds = bookIds;
        this.startIndex = startIndex;
        this.maxResults = maxResults;
        this.orderBy = orderBy;
        this.langRestrict = langRestrict;
    }

    public Set<String> getBookIds() {
        return bookIds;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public String getLangRestrict() {
        return langRestrict;
    }
}
