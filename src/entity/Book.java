package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String author;
    private String condition;
    private double price;
    @Column(length = 2000)
    private String description;
    private String imageUrl;
    private String seller;


    public Book() {}

    // Constructor
    public Book(Integer id, String title, String author, String condition,
                double price, String description, String imageUrl,
                String seller) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.condition = condition;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.seller = seller;
    }

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

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
}