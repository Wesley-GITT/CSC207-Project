package use_case.order.create;

public class CreateOrderOutputData {

    private final int orderId;
    private final int productId;

    public CreateOrderOutputData(int orderId, int productId) {
        this.orderId = orderId;
        this.productId = productId;
    }

    public int getOrderId() { return orderId; }

    public int getProductId() {
        return productId;
    }
}
