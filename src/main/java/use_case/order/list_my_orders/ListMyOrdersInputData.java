package use_case.order.list_my_orders;

public class ListMyOrdersInputData {

    private final String username;
    private final String password;

    public ListMyOrdersInputData(String username, String password) {
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
