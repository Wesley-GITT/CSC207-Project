package use_case.order.list_customer_orders;

public class ListCustomerOrdersInputData {

    private final String username;
    private final String password;

    public ListCustomerOrdersInputData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
