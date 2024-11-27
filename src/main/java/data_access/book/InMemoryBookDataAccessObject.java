package data_access.book;

import entity.Book;
import entity.BookQuery;
import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.view.ViewBookDataAccessInterface;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class InMemoryBookDataAccessObject implements ViewBookDataAccessInterface, SearchBookDataAccessInterface {

    private Map<String, Book> books = new HashMap<>();

    @Override
    public Set<String> search(BookQuery query) {
        // for the purpose of testing, the search method here
        // will only return a set of bookId where the book title
        // contains the keyword of the query.
        final Set<String> queryResult = new HashSet<>();
        final String keyword = query.getQueryKeyword().toLowerCase();
        for (Book book: books.values()) {
            final String title = book.getTitle().toLowerCase();
            if (title.contains(keyword)) {
                queryResult.add(book.getId());
            }
        }
        return queryResult;
    }

    @Override
    public Book get(String bookId) {
        return books.get(bookId);
    }

    @Override
    public boolean exist(String bookId) {
        return books.containsKey(bookId);
    }

    public void save(Book book) {
        books.put(book.getId(), book);
    }
}
