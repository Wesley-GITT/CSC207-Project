package use_case.order.cancel_order;

public class CancelOrderOutputData {
    private final int orderId;

    public CancelOrderOutputData(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}
