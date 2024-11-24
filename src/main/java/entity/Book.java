package entity;

import java.math.BigDecimal;
import java.util.Set;

public class Book {

    // Fields from both classes
    private String id; // Unified ID field (can be treated as a string for flexibility)
    private String imageUrl;
    private String title;
    private String author; // From the first class (can coexist with authors Set)
    private Set<String> authors; // From the second class
    private String publisher;
    private String publishedDate;
    private String description;
    private String sampleUrl;
    private String language;
    private Set<String> categories;
    private String subject;
    private String genre;
    private BigDecimal price;
    private String seller;

    // Default constructor
    public Book() {}

    // Comprehensive constructor that includes fields from both classes
    public Book(String id, String imageUrl, String title, String author, Set<String> authors, String publisher,
                String publishedDate, String description, String sampleUrl, String language, Set<String> categories,
                String subject, String genre, BigDecimal price, String seller) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.title = title;
        this.author = author;
        this.authors = authors;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.sampleUrl = sampleUrl;
        this.language = language;
        this.categories = categories;
        this.subject = subject;
        this.genre = genre;
        this.price = price;
        this.seller = seller;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
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

    public String getSubject() {
        return subject;
    }

    public String getGenre() {
        return genre;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getSeller() {
        return seller;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSampleUrl(String sampleUrl) {
        this.sampleUrl = sampleUrl;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    // toString() method for convenient debugging/logging
    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", authors=" + authors +
                ", publisher='" + publisher + '\'' +
                ", publishedDate='" + publishedDate + '\'' +
                ", description='" + description + '\'' +
                ", sampleUrl='" + sampleUrl + '\'' +
                ", language='" + language + '\'' +
                ", categories=" + categories +
                ", subject='" + subject + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", seller='" + seller + '\'' +
                '}';
    }
}
