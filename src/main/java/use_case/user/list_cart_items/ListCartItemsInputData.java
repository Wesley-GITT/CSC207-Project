package use_case.user.list_cart_items;

public class ListCartItemsInputData {

    private final String username;
    private final String password;

    public ListCartItemsInputData(String username, String password) {
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
