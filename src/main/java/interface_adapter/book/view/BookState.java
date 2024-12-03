package interface_adapter.book.view;

import java.util.Set;

/**
 * The state for the Login View Model.
 */
public class BookState {
    private String id;
    private String imageUrl;
    private String title;
    private Set<String> authors; // From the second class
    private String publisher;
    private String publishedDate;
    private String description;
    private String language;
    private String viewBookError;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getViewBookError() {
        return viewBookError;
    }

    public void setViewBookError(String viewBookError) {
        this.viewBookError = viewBookError;
    }
}
