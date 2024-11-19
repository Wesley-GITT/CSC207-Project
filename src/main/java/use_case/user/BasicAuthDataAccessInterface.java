package use_case.user;

public interface BasicAuthDataAccessInterface {

    boolean isAuthenticated(String username, String password);

}
