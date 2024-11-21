package use_case.user.show_cart;

public class ShowCartInputData {

    private final String username;
    private final String password;

    public ShowCartInputData(String username, String password) {
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
