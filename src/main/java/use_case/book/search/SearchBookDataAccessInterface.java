package use_case.book.search;

import java.util.List;

public interface SearchBookDataAccessInterface {

    /**
     * Search Method in SearchBookDataAccessInterface.
     * @param keyword keyword
     * @param startIndex startIndex
     * @param maxItemNum maxItemNum
     * @return implemented elsewhere
     */
    List<String> search(String keyword, int startIndex, int maxItemNum);
}
