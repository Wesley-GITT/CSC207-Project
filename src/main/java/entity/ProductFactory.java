package entity;

public class ProductFactory {

    public Product create(int id, String bookId, int sellerId, String bookCondition, double price) {
        return new Product(id, bookId, sellerId, bookCondition, price, false);
    }

    public Product create(String bookId) {
        return new Product(-1, bookId, -1, "", 0, false);
    }

    public Product create(String bookId, int sellerId) {
        return new Product(-1, bookId, sellerId, "", 0, false);
    }
}
