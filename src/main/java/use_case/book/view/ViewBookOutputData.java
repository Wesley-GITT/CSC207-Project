package use_case.book.view;

import java.util.Set;

public class ViewBookOutputData {

    private final String id;
    private final String imageUrl;
    private final String title;
    private final Set<String> authors; // From the second class
    private final String publisher;
    private final String publishedDate;
    private final String description;
    private final String language;

    public ViewBookOutputData(String id, String imageUrl, String title, Set<String> authors, String publisher,
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
