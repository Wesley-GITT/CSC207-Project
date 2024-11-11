package entity;

import jakarta.persistence.*;
import org.apache.catalina.User;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    private String subject;
    private String genre;

    @Column(nullable = false)
    private BigDecimal price;

    private String seller;

    // Constructors, including a parameterized constructor for convenience
    public Book() {}

//    public Book(String title, String author, String subject, String genre, BigDecimal price, String seller) {
//        this.title = title;
//        this.author = author;
//        this.subject = subject;
//        this.genre = genre;
//        this.price = price;
//        this.seller = seller;
//    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
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

    // Setters for mutable properties
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    // toString() method for convenient logging or debugging
    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", seller=" + seller +
                '}';
    }
}
