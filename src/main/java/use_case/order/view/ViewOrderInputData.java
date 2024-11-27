package use_case.order.view;

public class ViewOrderInputData {

    private final String username;
    private final String password;
    private final int orderId;

    public ViewOrderInputData(String username, String password, int orderId) {
        this.username = username;
        this.password = password;
        this.orderId = orderId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getOrderId() {
        return orderId;
    }
}
