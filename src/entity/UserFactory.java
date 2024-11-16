package entity;

/**
 * Factory for creating CommonUser objects.
 */
public class UserFactory implements UserFactoryInterface {

    @Override
    public User create(String username, String password, String name, String address, String contactInfo) {
        return new User(username, password, name, address, contactInfo);
    }
}