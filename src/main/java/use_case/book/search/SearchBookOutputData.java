package use_case.book.search;

import java.util.List;

public class SearchBookOutputData {

    private final List<String> bookIds;
    private final int startIndex;
    private final int endIndex;
    private final int resNumEachOutput;

    public SearchBookOutputData(List<String> bookIds, int startIndex, int endIndex, int resNumEachOutput) {

        this.bookIds = bookIds;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.resNumEachOutput = resNumEachOutput;
    }

    public List<String> getBookIds() {
        return bookIds;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getResNumEachOutput() {
        return resNumEachOutput;
    }
}
