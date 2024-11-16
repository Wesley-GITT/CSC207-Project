package entity;

import java.util.Set;

public class BookFactory {

    public Book create(
            String id, String imageUrl, String title, Set<String> authorIds, Set<String> translatorIds, String lang,
            String publishers, String description, String sampleUrl) {
        return new Book(id, imageUrl, title, authorIds, translatorIds, lang, publishers, description, sampleUrl);
    }
}
