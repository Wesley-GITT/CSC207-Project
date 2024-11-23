package use_case.order.create;

public class CreateOrderOutputData {

    private final int productId;

    public CreateOrderOutputData(int productId) {
        this.productId = productId;
    }

    public int getProductId() { return productId; }
}
