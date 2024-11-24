package data_access;

import data_access.book.BookService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceRealTest {

    @Test
    void testGetBookDetails_RealFetch() throws JSONException {
        // Replace with your actual API Key (Avoid exposing in public repositories!)
        String apiKey = "AIzaSyAUVk9spYk1jYZ1A-K-qu8ImmuBxWVcO4I";  // Replace with valid key
        String title = "Genshin Impact";  // A title likely to return a result

        // Create an instance of BookService with a real RestTemplate
        BookService bookService = new BookService(new RestTemplate());

        // Perform the actual fetch from Google Books API
        JSONObject bookDetails = bookService.getBookDetails(title);

        // Assert that the response is not null
        assertNotNull(bookDetails, "The book details should not be null");

        // Assert that expected fields are present
        assertTrue(bookDetails.has("title"), "The response should contain the 'title'");
        assertTrue(bookDetails.has("author"), "The response should contain the 'author'");
        assertTrue(bookDetails.has("description"), "The response should contain the 'description'");
        assertTrue(bookDetails.has("publisher"), "The response should contain the 'publisher'");
        assertTrue(bookDetails.has("publishedDate"), "The response should contain the 'publishedDate'");

        // Optionally, log the details for manual inspection (useful for debugging)
        System.out.println("Book Details: " + bookDetails.toString(4));
    }
}
