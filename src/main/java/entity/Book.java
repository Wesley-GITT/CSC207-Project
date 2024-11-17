package entity;

import java.util.Set;

public class Book {

    private String id;
    private String imageUrl;
    private String title;
    private String publisher;
    private String publishedDate;
    private String description;
    private String sampleUrl;
    private String language;
    private Set<String> authors;
    private Set<String> categories;

    public Book(String id, String imageUrl, String title, String publisher, String publishedDate, String description, String sampleUrl, String language, Set<String> authors, Set<String> categories) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.sampleUrl = sampleUrl;
        this.language = language;
        this.authors = authors;
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

    public Set<String> getAuthors() {
        return authors;
    }

    public Set<String> getCategories() {
        return categories;
    }
}
