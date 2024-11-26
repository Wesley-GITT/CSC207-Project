package use_case.book.search;

import java.util.Set;

public class SearchBookOutputData {

    private final Set<String> bookIds;

    /**
     * Constructor to initialize search output data.
     *
     * @param bookIds The list of bookIds retrieved from the search.
     */
    public SearchBookOutputData(Set<String> bookIds) {
        this.bookIds = bookIds;
    }

    public Set<String> getBookIds() {
        return bookIds;
    }
}
