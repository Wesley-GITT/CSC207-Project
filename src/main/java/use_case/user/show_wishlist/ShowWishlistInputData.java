package use_case.user.show_wishlist;

public class ShowWishlistInputData {

    private final String username;
    private final String password;

    public ShowWishlistInputData(String username, String password) {
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
