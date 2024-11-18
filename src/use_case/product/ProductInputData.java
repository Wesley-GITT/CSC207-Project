package use_case.product;

/*
This data class encapsulates the input data needed for posting, editing, or deleting a product.
 */
public class ProductInputData {
    private Integer productId;
    private String title;
    private String author;
    private String condition;
    private double price;
    private String description;
    private String imageUrl;
    private String seller;

    public ProductInputData(String title, String author, String condition, double price, String description, String imageUrl, String seller) {
        this.title = title;
        this.author = author;
        this.condition = condition;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.seller = seller;
    }

    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSeller() {
        return seller;
    }
    public void setSeller(String seller) {
        this.seller = seller;
    }
}