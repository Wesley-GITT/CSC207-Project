package use_case.book.search;

public class SearchBookInputData {

    private final String keyword;
    private final int resMaxNumEachSearch;
    private final int startIndex;
    private final boolean withProduct;

    public SearchBookInputData(String keyword, int resMaxNumEachSearch, int startIndex, boolean withProduct) {
        this.keyword = keyword;
        this.resMaxNumEachSearch = resMaxNumEachSearch;
        this.startIndex = startIndex;
        this.withProduct = withProduct;
    }

    public String getKeyword() {
        return keyword;
    }

    public int getResMaxNumEachSearch() {
        return resMaxNumEachSearch;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public boolean isWithProduct() {
        return withProduct;
    }
}