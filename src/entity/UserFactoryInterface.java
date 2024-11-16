package entity;

public interface UserFactoryInterface {
    User create(String username, String password, String name, String address, String contactInfo);
}
