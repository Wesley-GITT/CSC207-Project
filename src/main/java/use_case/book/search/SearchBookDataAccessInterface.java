package use_case.book.search;

import entity.BookQuery;

import java.util.Set;

public interface SearchBookDataAccessInterface {
    
    Set<String> search(BookQuery query);
}
