package use_case.book.view;

import java.util.Set;

public class ViewBookOutputData {

    private final String id; // Unified ID field (can be treated as a string for flexibility)
    private final String imageUrl;
    private final String title;
    private final Set<String> authors; // From the second class
    private final String publisher;
    private final String publishedDate;
    private final String description;
    private final String sampleUrl;
    private final String language;
    private final Set<String> categories;

    public ViewBookOutputData(String id, String imageUrl, String title, Set<String> authors, String publisher,
                              String publishedDate, String description, String sampleUrl, String language,
                              Set<String> categories) {

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
