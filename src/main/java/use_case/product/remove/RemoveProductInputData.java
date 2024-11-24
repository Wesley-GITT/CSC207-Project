package use_case.product.remove;

import java.util.Set;

public class RemoveProductInputData {

    private final String username;
    private final String password;
    private final Set<Integer> products;

    public RemoveProductInputData(String username, String password, Set<Integer> products) {
        this.username = username;
        this.password = password;
        this.products = products;
    }

    public String getUsername() { return username;}

    public String getPassword() { return password;}

    public Set<Integer> getProducts() { return products;}

}
