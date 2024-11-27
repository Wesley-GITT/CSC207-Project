package data_access.book;

import entity.Book;
import entity.BookFactory;
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
import use_case.book.search.SearchBookDataAccessInterface;
import use_case.book.view.ViewBookDataAccessInterface;

import java.io.IOException;
import java.util.*;


public class APIBookDataAccessObject implements ViewBookDataAccessInterface, SearchBookDataAccessInterface {

    private final String baseUrl = "https://www.googleapis.com/books/v1/volumes";

    private String getJSONStringByKey(JSONObject object, String key) {
        if (object.has(key)) {
            return object.getString(key);
        }
        return "";
    }

    @Override
    public Book get(String bookId) {
        HttpGet httpGet = new HttpGet(baseUrl + "/" + bookId);
        try {
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String body = EntityUtils.toString(httpEntity);

            JSONObject jsonQueryResult = new JSONObject(body);
            JSONObject jsonVolumeInfo = jsonQueryResult.getJSONObject("volumeInfo");
            JSONArray jsonAuthors = jsonVolumeInfo.getJSONArray("authors");
            JSONObject jsonImageLinks = jsonVolumeInfo.getJSONObject("imageLinks");

            String id = getJSONStringByKey(jsonQueryResult, "id");
            String title = getJSONStringByKey(jsonVolumeInfo,"title");
            String imageURL = getJSONStringByKey(jsonImageLinks, "thumbnail");
            String publisher = getJSONStringByKey(jsonVolumeInfo,"publisher");
            String publishedDate = getJSONStringByKey(jsonVolumeInfo,"publishedDate");
            String description = getJSONStringByKey(jsonVolumeInfo,"description");
            String language = getJSONStringByKey(jsonVolumeInfo,"language");

            Set<String> authors = new HashSet<>();
            Iterator<Object> jsonAuthorIterator = jsonAuthors.iterator();
            while(jsonAuthorIterator.hasNext()) {
                String author = (String) jsonAuthorIterator.next();
                authors.add(author);
            }

            BookFactory bookFactory = new BookFactory();
            return bookFactory.create(id, title, imageURL, authors, publisher, publishedDate, description, language);

        } catch (IOException | ParseException | JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean exist(String bookId) {
        try {
            HttpGet httpGet = new HttpGet(baseUrl + "/" + bookId);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            if (httpResponse.getCode() == 404) {
                return false;
            } else {
                return true;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<String> search(String keyword, int startIndex, int maxItemNum) {
        try {
            HttpGet httpGet = new HttpGet(baseUrl + "?q=" + keyword + "&startIndex=" + startIndex + "&maxResults=" + maxItemNum);
            CloseableHttpClient httpClient = HttpClients.createDefault();
            CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity httpEntity = httpResponse.getEntity();
            String body = EntityUtils.toString(httpEntity);

            List<String> bookIds = new ArrayList<>();
            JSONObject jsonQueryResult = new JSONObject(body);

            if (jsonQueryResult.has("items")) {
                JSONArray jsonBookItems = jsonQueryResult.getJSONArray("items");
                Iterator<Object> jsonBookItemsIteractor = jsonBookItems.iterator();
                while(jsonBookItemsIteractor.hasNext()) {
                    JSONObject jsonBook = (JSONObject) jsonBookItemsIteractor.next();
                    bookIds.add(getJSONStringByKey(jsonBook, "id"));
                }
            }

            return bookIds;

        } catch (IOException | ParseException | JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
