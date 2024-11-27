package use_case.product.remove;

public class RemoveProductInputData {

    private final String username;
    private final String password;
    private final int productId;

    public RemoveProductInputData(String username, String password, int productId) {
        this.username = username;
        this.password = password;
        this.productId = productId;
    }

    public String getUsername() { return username;}

    public String getPassword() { return password;}

    public int getProductId() { return productId;}

}
