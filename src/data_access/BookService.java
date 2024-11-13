package data_access;

import entity.Book;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import repository.BookRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookRepository bookRepository;

    public BookService(RestTemplate restTemplate) {
        this.restTemplate = new RestTemplate();  // Manually create an instance
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.searchBooks(keyword);
    }

    public JSONObject getBookDetails(String title) {
        // Replace with your actual API Key
        String apiKey = "AIzaSyAUVk9spYk1jYZ1A-K-qu8ImmuBxWVcO4I";  // Replace with your actual API Key
        String url = "https://www.googleapis.com/books/v1/volumes?q=" + title.replace(" ", "+") + "&key=" + apiKey;

        try {
            // Make the API call and parse the response
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonResponse = new JSONObject(response);

            // Extract items from the JSON response
            JSONArray items = jsonResponse.optJSONArray("items");

            // If there are results, process the first book
            if (items != null && items.length() > 0) {
                JSONObject bookInfo = items.getJSONObject(0).optJSONObject("volumeInfo");

                if (bookInfo != null) {
                    // Extract details from the "volumeInfo" object
                    String titleResult = bookInfo.optString("title");
                    String author = bookInfo.optJSONArray("authors") != null ?
                            bookInfo.optJSONArray("authors").join(", ") : "Unknown Author";
                    String description = bookInfo.optString("description", "No description available.");
                    String publisher = bookInfo.optString("publisher", "Unknown Publisher");
                    String publishedDate = bookInfo.optString("publishedDate", "Unknown Date");
                    String genre = bookInfo.optString("categories", "Unknown Genre");
                    String previewLink = bookInfo.optString("previewLink", "No preview available.");
                    String isbn = bookInfo.optJSONArray("industryIdentifiers") != null ?
                            bookInfo.optJSONArray("industryIdentifiers").getJSONObject(0).optString("identifier") : "No ISBN available";

                    // Print details to console (You can log or save these details to your Book object)
                    System.out.println("Title: " + titleResult);
                    System.out.println("Author(s): " + author);
                    System.out.println("Description: " + description);
                    System.out.println("Publisher: " + publisher);
                    System.out.println("Published Date: " + publishedDate);
                    System.out.println("Genre: " + genre);
                    System.out.println("Preview Link: " + previewLink);
                    System.out.println("ISBN: " + isbn);

                    // Create a JSON object with the extracted details (returning this or passing it to another service)
                    JSONObject bookDetails = new JSONObject();
                    bookDetails.put("title", titleResult);
                    bookDetails.put("author", author);
                    bookDetails.put("description", description);
                    bookDetails.put("publisher", publisher);
                    bookDetails.put("publishedDate", publishedDate);
                    bookDetails.put("genre", genre);
                    bookDetails.put("previewLink", previewLink);
                    bookDetails.put("isbn", isbn);

                    // Return the details as a JSONObject
                    return bookDetails;
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching or parsing book details: " + e.getMessage());
        }

        return null; // Return null if there was an issue or no results found
    }
}
