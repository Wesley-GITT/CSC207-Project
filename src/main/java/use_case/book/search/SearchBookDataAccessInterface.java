package use_case.book.search;

import entity.Book;
import java.util.Set;

public interface SearchBookDataAccessInterface {


    Set<Book> search();
}
