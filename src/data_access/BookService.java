package data_access;

import entity.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.BookRepository;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

//    Done by autowired
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.searchBooks(keyword);
    }
}
