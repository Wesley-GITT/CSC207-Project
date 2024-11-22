package entity;

import java.util.Set;

public class BookFactory {

    public Book create(
            String id, String imageUrl, String title, String publisher, String publishedDate, String description, String sampleUrl, String language, Set<String> authors, Set<String> categories) {
        return new Book(id, imageUrl, title, publisher, publishedDate, description, sampleUrl, language, authors, categories);
    }
}
