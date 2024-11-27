package entity;

import java.util.HashSet;
import java.util.Set;

public class BookFactory {

    public Book create(String id, String imageUrl, String title, Set<String> authors, String publisher,
                       String publishedDate,  String description, String language) {

        return new Book(id, imageUrl, title, authors, publisher, publishedDate, description, language);
    }

    public Book create(String id, String title) {
        return new Book(id, "", title, new HashSet<>(), "", "", "", "");
    }
}
