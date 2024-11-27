package entity;

import java.util.Set;

public class Book {

    // Fields from both classes
    private String id; // Unified ID field (can be treated as a string for flexibility)
    private String imageUrl;
    private String title;
    private Set<String> authors; // From the second class
    private String publisher;
    private String publishedDate;
    private String description;
    private String sampleUrl;
    private String language;
    private Set<String> categories;

    public Book(String id, String imageUrl, String title, Set<String> authors, String publisher, String publishedDate,
                String description, String sampleUrl, String language, Set<String> categories) {

        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.sampleUrl = sampleUrl;
        this.language = language;
        this.categories = categories;
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

    public String getSampleUrl() {
        return sampleUrl;
    }

    public String getLanguage() {
        return language;
    }

    public Set<String> getCategories() {
        return categories;
    }
}