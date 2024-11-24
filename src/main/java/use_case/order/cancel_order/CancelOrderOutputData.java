package use_case.order.cancel_order;

public class CancelOrderOutputData {
    private final String message;

    public CancelOrderOutputData(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
