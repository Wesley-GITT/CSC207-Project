package data_access.book;

import entity.Book;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import use_case.BookDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookRepository bookRepository;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = new RestTemplate();
    }

    // Expose a method returning BookDTO instead of Book
    public List<BookDTO> searchBooks(String keyword) {
        List<Book> books = bookRepository.searchBooks(keyword);
        return books.stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    // Map Book Entity to BookDTO
    private BookDTO mapToDTO(Book book) {
        return new BookDTO(
                book.getId() != null ? book.getId().toString() : null,
                book.getTitle(),
                book.getAuthor(),
                book.getAuthors(),
                book.getPublisher(),
                book.getPublishedDate(),
                book.getDescription(),
                book.getLanguage(),
                book.getGenre(),
                book.getPrice(),
                book.getSeller()
        );
    }

    public JSONObject getBookDetails(String title) {
        String apiKey = "AIzaSyAUVk9spYk1jYZ1A-K-qu8ImmuBxWVcO4I";
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + title.replace(" ", "+") + "&key=" + apiKey;

        try {
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray items = jsonResponse.optJSONArray("items");

            if (items != null && items.length() > 0) {
                JSONObject bookInfo = items.getJSONObject(0).optJSONObject("volumeInfo");

                if (bookInfo != null) {
                    String titleResult = bookInfo.optString("title");
                    String author = bookInfo.optJSONArray("authors") != null
                            ? bookInfo.optJSONArray("authors").join(", ")
                            : "Unknown Author";
                    String description = bookInfo.optString("description", "No description available.");
                    String publisher = bookInfo.optString("publisher", "Unknown Publisher");
                    String publishedDate = bookInfo.optString("publishedDate", "Unknown Date");
                    String genre = bookInfo.optString("categories", "Unknown Genre");
                    String previewLink = bookInfo.optString("previewLink", "No preview available.");
                    String isbn = bookInfo.optJSONArray("industryIdentifiers") != null
                            ? bookInfo.optJSONArray("industryIdentifiers").getJSONObject(0).optString("identifier")
                            : "No ISBN available";

                    JSONObject bookDetails = new JSONObject();
                    bookDetails.put("title", titleResult);
                    bookDetails.put("author", author);
                    bookDetails.put("description", description);
                    bookDetails.put("publisher", publisher);
                    bookDetails.put("publishedDate", publishedDate);
                    bookDetails.put("genre", genre);
                    bookDetails.put("previewLink", previewLink);
                    bookDetails.put("isbn", isbn);

                    return bookDetails;
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching or parsing book details: " + e.getMessage());
        }

        return null;
    }
}
