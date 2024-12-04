package entity;

/**
 * The Presenter for the Login Use Case.
 */
public class ProductFactory {

    /**
     * The Presenter for the Login Use Case.
     * @param id :
     * @param bookCondition :
     * @param bookId :
     * @param price :
     * @param sellerId :
     * @return :
     */
    public Product create(int id, String bookId, int sellerId, String bookCondition, double price) {
        return new Product(id, bookId, sellerId, bookCondition, price, false);
    }

    /**
     * The Presenter for the Login Use Case.
     * @param bookId :
     * @return :
     */
    public Product create(String bookId) {
        return new Product(-1, bookId, -1, "", 0, false);
    }

    /**
     * The Presenter for the Login Use Case.
     * @param bookId :
     * @param sellerId :
     * @return :
     */
    public Product create(String bookId, int sellerId) {
        return new Product(-1, bookId, sellerId, "", 0, false);
    }
}
