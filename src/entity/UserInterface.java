package entity;

public interface UserInterface {
    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    String getName();

    void setName(String name);

    String getAddress();

    void setAddress(String address);

    String getContactInfo();

    void setContactInfo(String contactInfo);

    void changepassword(String password);
}
