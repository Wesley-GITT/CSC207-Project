package controller;

import data_access.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import use_case.BookDTO;

@RestController
@RequestMapping("/api/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/search")
    public List<BookDTO> searchBooks(@RequestParam String keyword) {
        return bookService.searchBooks(keyword);
    }

    @GetMapping("/details/{title}")
    public String getBookDetails(@PathVariable String title) {
        JSONObject bookDetails = bookService.getBookDetails(title);

        if (bookDetails != null) {
            return bookDetails.toString();  // Return JSON with book information
        } else {
            return "Book details not found or could not be retrieved";
        }
    }

}