package data_access.book;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.*;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import entity.Book;
import entity.BookFactory;
import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.view.ViewBookDataAccessInterface;

/**
 * API.
 */
public class ApiBookDataAccessObject implements ViewBookDataAccessInterface, SearchBookDataAccessInterface {

    private final String baseUrl = "https://www.googleapis.com/books/v1/volumes";
    // private final String pos = "&key=AIzaSyCjFtxl0aJp-HONN6lpsYNCyCi-1Mqoi0I";

    private String getJSONStringByKey(JSONObject object, String key) {
        if (object.has(key)) {
            return object.getString(key);
        }
        return "";
    }

    @Override
    public Book get(String bookId) {
        final HttpGet httpGet = new HttpGet(baseUrl + "/" + bookId);
        try {
            final CloseableHttpClient httpClient = HttpClients.createDefault();
            final CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            final HttpEntity httpEntity = httpResponse.getEntity();
            final String body = EntityUtils.toString(httpEntity);

            final JSONObject jsonQueryResult = new JSONObject(body);
            final JSONObject jsonVolumeInfo = jsonQueryResult.getJSONObject("volumeInfo");
            final JSONArray jsonAuthors = jsonVolumeInfo.getJSONArray("authors");
            final JSONObject jsonImageLinks = jsonVolumeInfo.getJSONObject("imageLinks");

            final String id = getJSONStringByKey(jsonQueryResult, "id");
            final String title = getJSONStringByKey(jsonVolumeInfo, "title");
            final String imageURL = getJSONStringByKey(jsonImageLinks, "thumbnail");
            final String publisher = getJSONStringByKey(jsonVolumeInfo, "publisher");
            final String publishedDate = getJSONStringByKey(jsonVolumeInfo, "publishedDate");
            final String description = getJSONStringByKey(jsonVolumeInfo, "description");
            final String language = getJSONStringByKey(jsonVolumeInfo, "language");

            final Set<String> authors = new HashSet<>();
            final Iterator<Object> jsonAuthorIterator = jsonAuthors.iterator();
            while (jsonAuthorIterator.hasNext()) {
                final String author = (String) jsonAuthorIterator.next();
                authors.add(author);
            }

            final BookFactory bookFactory = new BookFactory();
            return bookFactory.create(id, imageURL, title, authors, publisher, publishedDate, description, language);

        }
        catch (IOException | ParseException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * API.
     */
    @Override
    public boolean exist(String bookId) {
        try {
            final int error = 404;
            final HttpGet httpGet = new HttpGet(baseUrl + "/" + bookId);
            final CloseableHttpClient httpClient = HttpClients.createDefault();
            final CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getCode() == error) {
                return false;
            }
            else {
                return true;
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> search(String keyword, int startIndex, int maxItemNum) {
        try {
            final HttpGet httpGet = new HttpGet(baseUrl + "?q=" + URLEncoder.encode(keyword) + "&startIndex=" + startIndex + "&maxResults=" + maxItemNum);
            final CloseableHttpClient httpClient = HttpClients.createDefault();
            final CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            final HttpEntity httpEntity = httpResponse.getEntity();
            final String body = EntityUtils.toString(httpEntity);

            final List<String> bookIds = new ArrayList<>();
            final JSONObject jsonQueryResult = new JSONObject(body);

            if (jsonQueryResult.has("items")) {
                final JSONArray jsonBookItems = jsonQueryResult.getJSONArray("items");
                final Iterator<Object> jsonBookItemsIteractor = jsonBookItems.iterator();
                while (jsonBookItemsIteractor.hasNext()) {
                    final JSONObject jsonBook = (JSONObject) jsonBookItemsIteractor.next();
                    bookIds.add(getJSONStringByKey(jsonBook, "id"));
                }
            }

            return bookIds;

        }
        catch (IOException | ParseException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
