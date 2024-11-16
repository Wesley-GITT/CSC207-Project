package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Book implements BookInterface{

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
    @Override
    public Integer getId() { return id; }
    @Override
    public void setId(Integer id) { this.id = id; }

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

}