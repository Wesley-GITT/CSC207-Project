package entity;

public interface BookInterface {
    // Getters and setters
    Integer getId();

    void setId(Integer id);

    String getTitle();

    void setTitle(String title);

    String getAuthor();

    void setAuthor(String author);

    String getCondition();

    void setCondition(String condition);

    double getPrice();

    void setPrice(double price);

    String getDescription();

    void setDescription(String description);

    String getImageUrl();

    void setImageUrl(String imageUrl);

    String getSeller();

    void setSeller(String seller);

}
