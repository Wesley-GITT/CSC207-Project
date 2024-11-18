package entity;

import java.util.Set;

public class OtherUser implements User {

    protected String username;
    protected ContactInfo contactInfo;
    protected Set<Integer> productIds;

    public OtherUser(String username, ContactInfo contactInfo, Set<Integer> productIds) {
        this.username = username;
        this.contactInfo = contactInfo;
        this.productIds = productIds;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return contactInfo.getEmail();
    }

    public String getTelephone() {
        return contactInfo.getTelephone();
    }

    public Set<Integer> getProductIds() {
        return productIds;
    }
}
