package use_case.user.show_cart;

import java.util.Set;

public class showCartInputData {

    private final String username;
    private final String password;

    public showCartInputData(String username, String password, Set<Integer> cartItems) {
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
