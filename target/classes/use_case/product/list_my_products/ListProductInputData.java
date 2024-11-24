package use_case.product.list_my_products;

public class ListProductInputData {
    private final String username;
    private final String password;

    public ListProductInputData(String username, String password) {
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
