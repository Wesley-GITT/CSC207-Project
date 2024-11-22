package use_case.book.search;

import entity.Book;

import java.util.Set;

public class SearchOutputData {

    final private Set<Book> books;
    final private int startIndex;

    public SearchOutputData(Set<Book> books, int startIndex) {
        this.books = Set.copyOf(books);
        this.startIndex = startIndex;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public int getStartIndex() {
        return startIndex;
    }
}
