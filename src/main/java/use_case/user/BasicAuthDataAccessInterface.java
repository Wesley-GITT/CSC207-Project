package use_case.user;

public interface BasicAuthDataAccessInterface {
    /**
     * IsAuthenticated for BasicAuthDataAccessInterface.
     * @param username username
     * @param password password
     * @return boolean
     */
    boolean isAuthenticated(String username, String password);
}
