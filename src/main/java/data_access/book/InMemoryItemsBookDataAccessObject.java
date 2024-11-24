package data_access.book;

import entity.Book;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.viewsearchbook.ViewBookDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryItemsBookDataAccessObject implements ViewBookDataAccessInterface, SearchBookDataAccessInterface {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BookRepository bookRepository;

    public InMemoryItemsBookDataAccessObject(RestTemplate restTemplate) {
        this.restTemplate = new RestTemplate(); // Manually create an instance
    }

    @Override
    public Book findBookById(String bookId) {
        String apiKey = "AIzaSyAUVk9spYk1jYZ1A-K-qu8ImmuBxWVcO4I";
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("Google Books API key is not set.");
        }

        String url = "https://www.googleapis.com/books/v1/volumes/" + bookId + "?key=" + apiKey;
        try {
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonResponse = new JSONObject(response);

            JSONObject volumeInfo = jsonResponse.optJSONObject("volumeInfo");
            if (volumeInfo != null) {
                return new Book(
                        bookId,
                        volumeInfo.optJSONObject("imageLinks") != null
                                ? volumeInfo.getJSONObject("imageLinks").optString("thumbnail")
                                : null,
                        volumeInfo.optString("title"),
                        volumeInfo.optJSONArray("authors") != null
                                ? String.join(", ", convertJSONArrayToList(volumeInfo.optJSONArray("authors")))
                                : "Unknown Author",
                        null,
                        volumeInfo.optString("publisher"),
                        volumeInfo.optString("publishedDate"),
                        volumeInfo.optString("description"),
                        volumeInfo.optString("previewLink"),
                        volumeInfo.optString("language"),
                        null,
                        null,
                        null,
                        null,
                        null
                );
            }
        } catch (Exception e) {
            System.err.println("Error fetching book by ID: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Book> searchBooks(String keyword) {
        String apiKey = "AIzaSyAUVk9spYk1jYZ1A-K-qu8ImmuBxWVcO4I";
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("Google Books API key is not set.");
        }

        String url = "https://www.googleapis.com/books/v1/volumes?q=" + keyword + "&key=" + apiKey;
        List<Book> books = new ArrayList<>();

        try {
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonResponse = new JSONObject(response);
            JSONArray items = jsonResponse.optJSONArray("items");

            if (items != null) {
                for (int i = 0; i < items.length(); i++) {
                    JSONObject volumeInfo = items.getJSONObject(i).optJSONObject("volumeInfo");
                    if (volumeInfo != null) {
                        books.add(new Book(
                                items.getJSONObject(i).optString("id"),
                                volumeInfo.optJSONObject("imageLinks") != null
                                        ? volumeInfo.getJSONObject("imageLinks").optString("thumbnail")
                                        : null,
                                volumeInfo.optString("title"),
                                volumeInfo.optJSONArray("authors") != null
                                        ? String.join(", ", convertJSONArrayToList(volumeInfo.optJSONArray("authors")))
                                        : "Unknown Author",
                                null,
                                volumeInfo.optString("publisher"),
                                volumeInfo.optString("publishedDate"),
                                volumeInfo.optString("description"),
                                volumeInfo.optString("previewLink"),
                                volumeInfo.optString("language"),
                                null,
                                null,
                                null,
                                null,
                                null
                        ));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error searching books: " + e.getMessage());
        }

        return books;
    }

    @Override
    public Book getBookDetailsByTitle(String title) {
        String apiKey = "AIzaSyAUVk9spYk1jYZ1A-K-qu8ImmuBxWVcO4I";
        if (apiKey == null || apiKey.isEmpty()) {
            throw new IllegalStateException("Google Books API key is not set.");
        }

        String url = "https://www.googleapis.com/books/v1/volumes?q=" + title.replace(" ", "+") + "&key=" + apiKey;
        try {
            String response = restTemplate.getForObject(url, String.class);
            JSONObject jsonResponse = new JSONObject(response);

            JSONArray items = jsonResponse.optJSONArray("items");
            if (items != null && items.length() > 0) {
                JSONObject volumeInfo = items.getJSONObject(0).optJSONObject("volumeInfo");

                if (volumeInfo != null) {
                    return new Book(
                            items.getJSONObject(0).optString("id"),
                            volumeInfo.optJSONObject("imageLinks") != null
                                    ? volumeInfo.getJSONObject("imageLinks").optString("thumbnail")
                                    : null,
                            volumeInfo.optString("title"),
                            volumeInfo.optJSONArray("authors") != null
                                    ? String.join(", ", convertJSONArrayToList(volumeInfo.optJSONArray("authors")))
                                    : "Unknown Author",
                            null,
                            volumeInfo.optString("publisher"),
                            volumeInfo.optString("publishedDate"),
                            volumeInfo.optString("description"),
                            volumeInfo.optString("previewLink"),
                            volumeInfo.optString("language"),
                            null,
                            null,
                            null,
                            null,
                            null
                    );
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching book details by title: " + e.getMessage());
        }
        return null;
    }

    /**
     * Helper method to convert JSONArray to List<String>.
     */
    private List<String> convertJSONArrayToList(JSONArray jsonArray) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            list.add(jsonArray.optString(i));
        }
        return list;
    }
}
