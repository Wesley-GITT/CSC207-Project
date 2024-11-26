package use_case.order.cancel;

public class CancelOrderOutputData {

    private final int orderId;

    public CancelOrderOutputData(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}
