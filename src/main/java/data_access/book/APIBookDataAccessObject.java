package data_access.book;

import entity.Book;
import entity.BookQuery;
import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.view.ViewBookDataAccessInterface;

import java.util.Set;


public class APIBookDataAccessObject implements ViewBookDataAccessInterface, SearchBookDataAccessInterface {

    @Override
    public Set<String> search(BookQuery query) {
        return Set.of();
    }

    @Override
    public Book get(String bookId) {
        return null;
    }

    @Override
    public boolean exist(String bookId) {
        return false;
    }
}
