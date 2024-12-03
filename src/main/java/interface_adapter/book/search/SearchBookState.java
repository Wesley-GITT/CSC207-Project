package interface_adapter.book.search;

import java.util.List;

/**
 * The state for the Login View Model.
 */
public class SearchBookState {
    private List<String> bookIds;
    private int startIndex;
    private int endIndex;
    private String searchBookError;
    
    public List<String> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<String> bookIds) {
        this.bookIds = bookIds;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String getSearchBookError() {
        return searchBookError;
    }

    public void setSearchBookError(String searchBookError) {
        this.searchBookError = searchBookError;
    }
}
