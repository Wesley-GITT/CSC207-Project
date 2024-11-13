package data_access;

import data_access.BookService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceRealTest {

    @Test
    public void testGetBookDetails_RealFetch() {
        // Actual API Key and real Google Books API call
        String apiKey = "AIzaSyAUVk9spYk1jYZ1A-K-qu8ImmuBxWVcO4I";  // Replace with your actual API Key
        String title = "Genshin";

        // Instantiate your service or directly call your method
        BookService bookService = new BookService(new RestTemplate());

        // Make the real API call
        JSONObject bookDetails = bookService.getBookDetails(title);

        // Verify the results
        assertNotNull(bookDetails);
        assertTrue(bookDetails.has("title"));
        assertTrue(bookDetails.has("description"));
    }
}
