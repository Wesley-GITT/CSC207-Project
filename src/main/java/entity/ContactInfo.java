package entity;

import org.json.JSONObject;

public class ContactInfo {

    private String telephone;
    private String email;

    public ContactInfo(String telephone, String email) {
        this.telephone = telephone;
        this.email = email;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Tel: " + this.telephone + "; Email: " + this.email;
    }

    public String toJson() {
         return new JSONObject()
                 .put("telephone", this.telephone)
                 .put("email", this.email)
                 .toString();
    }
}
