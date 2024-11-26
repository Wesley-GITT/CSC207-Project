package use_case.order.create;

public class CreateOrderOutputData {

    private final int orderId;

    public CreateOrderOutputData(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() { return orderId; }
}
