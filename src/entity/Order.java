package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

public class Order implements OrderInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book; // Reference to the book being bought

    private String buyer; // Reference to the buyer's username or ID
    private String status; // e.g., "Pending", "Completed", "Canceled"

    // Default constructor
    public Order() {}

    // Parameterized constructor
    public Order(Book book, String buyer, String status) {
        this.book = book;
        this.buyer = buyer;
        this.status = status;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Book getBook() {
        return book;
    }
    @Override
    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String getBuyer() {
        return buyer;
    }
    @Override
    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Override
    public String getStatus() {
        return status;
    }
    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}
