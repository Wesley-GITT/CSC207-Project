package data_access.book;

import entity.Book;
import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.view.ViewBookDataAccessInterface;

import java.util.*;


public class InMemoryBookDataAccessObject implements
        ViewBookDataAccessInterface,
        SearchBookDataAccessInterface {

    private Map<String, Book> books = new HashMap<>();
    private List<Book> bookList = new ArrayList<>();
    private final int maxResults = 10;

    @Override
    public Book get(String bookId) {
        return books.get(bookId);
    }

    @Override
    public boolean exist(String bookId) {
        return books.containsKey(bookId);
    }

    @Override
    public List<String> search(String keyword, int startIndex, int maxListSize) {
        List<String> result = new ArrayList<>();
        for (int i = startIndex; i < bookList.size() && i - startIndex < maxResults; i++) {
            Book book = bookList.get(i);
            result.add(book.getId());
        }
        return result;
    }

    public void save(Book book) {
        books.put(book.getId(), book);
        bookList.add(book);
    }
}
