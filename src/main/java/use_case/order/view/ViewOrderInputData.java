package use_case.order.view;

public class ViewOrderInputData {

    private final int orderId;

    public ViewOrderInputData(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }
}
