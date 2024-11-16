package entity;

import jakarta.persistence.Entity;

@Entity
public class Book {
    private String id;
    private String title;
    private String author;
    private String condition;
    private double price;
    private String description;
    private String imageUrl;
    private String seller;
    private String listed;

    // Constructor
    public Book(String id, String title, String author, String condition,
                double price, String description, String imageUrl,
                String seller, String listed) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.condition = condition;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.seller = seller;
        this.listed = listed;
    }

    // Getters and setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getCondition() { return condition; }
    public void setCondition(String condition) { this.condition = condition; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getSeller() { return seller; }
    public void setSeller(String seller) { this.seller = seller; }

    public String getListed() { return listed; }
    public void setListed(String listed) { this.listed = listed; }
}