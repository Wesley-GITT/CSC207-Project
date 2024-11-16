package entity;

public interface OrderInterface {
    Integer getId();

    void setId(Integer id);

    Book getBook();

    void setBook(Book book);

    String getBuyer();

    void setBuyer(String buyer);

    String getStatus();

    void setStatus(String status);
}
