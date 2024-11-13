package data_access;

import application.Application;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

// Replace 'Application' with the name of your main application class
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RestTemplate restTemplate;

    @InjectMocks
    private BookService bookService;

    @Test
    public void testGetBookDetails_SuccessfulResponse() throws Exception {
        // Mock Google Books API JSON response
        String mockApiResponse = """
            {
                "items": [
                    {
                        "volumeInfo": {
                            "title": "Harry Potter and the Philosopher's Stone",
                            "authors": ["J.K. Rowling"],
                            "description": "A fantasy novel about a young wizard, Harry Potter."
                        }
                    }
                ]
            }
            """;

        // Mock the RestTemplate response
        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(mockApiResponse);

        // Call the BookService method
        JSONObject bookDetails = bookService.getBookDetails("Harry Potter");

        // Verify the results
        assertNotNull(bookDetails);
        assertEquals("Harry Potter and the Philosopher's Stone", bookDetails.getString("title"));
        assertEquals("A fantasy novel about a young wizard, Harry Potter.", bookDetails.getString("description"));
    }

    @Test
    public void testGetBookDetails_NoResults() throws Exception {
        // Mock an empty response from the API
        String mockApiResponse = "{\"items\": []}";

        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(mockApiResponse);

        JSONObject bookDetails = bookService.getBookDetails("Nonexistent Book");

        assertNull(bookDetails);
    }



//    @Test
//    public void testGetBookDetailsEndpoint() throws Exception {
//        // Mock Google Books API response for controller test
//        String mockApiResponse = """
//            {
//                "items": [
//                    {
//                        "volumeInfo": {
//                            "title": "Harry Potter and the Philosopher's Stone",
//                            "authors": ["J.K. Rowling"],
//                            "description": "A fantasy novel about a young wizard, Harry Potter."
//                        }
//                    }
//                ]
//            }
//            """;
//
//        when(restTemplate.getForObject(anyString(), eq(String.class))).thenReturn(mockApiResponse);
//
//        // Test the /api/books/details endpoint
//        mockMvc.perform(MockMvcRequestBuilders.get("/api/books/details/Harry Potter"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.content().json("""
//                {
//                    "title": "Harry Potter and the Philosopher's Stone",
//                    "description": "A fantasy novel about a young wizard, Harry Potter."
//                }
//            """));
//    }
}
