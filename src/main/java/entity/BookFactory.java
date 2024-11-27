package entity;

import java.util.Set;

public class BookFactory {

    public Book create(String id, String imageUrl, String title, Set<String> authors, String publisher,
                       String publishedDate,  String description, String sampleUrl, String language,
                       Set<String> categories) {

        return new Book(id, imageUrl, title, authors, publisher, publishedDate, description, sampleUrl,
                language, categories);
    }
}
