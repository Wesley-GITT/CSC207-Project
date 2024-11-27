package entity;

public class ProductFactory {

    public Product create(int id, String bookId, int sellerId, String bookCondition, float price) {
        return new Product(id, bookId, sellerId, bookCondition, price, false);
    }

    public Product create(String bookId, int sellerId) {
        return new Product(-1, bookId, sellerId, "", 0, false);
    }
}
