package use_case.product.list_my_products;

public class ListMyProductInputData {
    private final String username;
    private final String password;

    public ListMyProductInputData(String username, String password) {
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
