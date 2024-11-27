package use_case.book.search;

import java.util.List;

public interface SearchBookDataAccessInterface {

    List<String> search(String keyword, int startIndex, int maxItemNum);
}
