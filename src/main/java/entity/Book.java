
package entity;

import java.util.Set;

/**
 * The Presenter for the Login Use Case.
 */
public class Book {

    private String id;
    private String imageUrl;
    private String title;
    private Set<String> authors;
    private String publisher;
    private String publishedDate;
    private String description;
    private String language;

    public Book(String id, String imageUrl, String title, Set<String> authors, String publisher,
                String publishedDate, String description, String language) {

        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.language = language;
    }

    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

}
