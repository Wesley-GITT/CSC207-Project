package entity;

import java.util.Set;

public interface User {

    String getUsername();

    String getEmail();

    String getTelephone();

    Set<Integer> getProductIds();
}
