import Repository.BookRepository;
import entity.Book;

import java.util.List;
import java.util.Optional;

public class BookService {
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    // Other methods for updating, deleting, and filtering books
}
