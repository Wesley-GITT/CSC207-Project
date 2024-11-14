package entity;

import jakarta.persistence.Entity;

@Entity
public class Book implements BookInterface {
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
    public Book() {}

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
    @Override
    public String getId() { return id; }
    @Override
    public void setId(String id) { this.id = id; }

    @Override
    public String getTitle() { return title; }
    @Override
    public void setTitle(String title) { this.title = title; }

    @Override
    public String getAuthor() { return author; }
    @Override
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String getCondition() { return condition; }
    @Override
    public void setCondition(String condition) { this.condition = condition; }

    @Override
    public double getPrice() { return price; }
    @Override
    public void setPrice(double price) { this.price = price; }

    @Override
    public String getDescription() { return description; }
    @Override
    public void setDescription(String description) { this.description = description; }

    @Override
    public String getImageUrl() { return imageUrl; }
    @Override
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    @Override
    public String getSeller() { return seller; }
    @Override
    public void setSeller(String seller) { this.seller = seller; }

    @Override
    public String getListed() { return listed; }
    @Override
    public void setListed(String listed) { this.listed = listed; }
}