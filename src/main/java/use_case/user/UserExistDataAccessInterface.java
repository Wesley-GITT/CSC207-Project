package use_case.user;

public interface UserExistDataAccessInterface {

    /**
     * ExistByUsername for UserExistDataAccessInterface.
     * @param username username
     * @return boolean
     */
    boolean existByUsername(String username);

}
