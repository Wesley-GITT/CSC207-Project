package use_case.product.list_my_products;

import java.util.Set;

public interface ListProductUserDataAccessInterface {

    Set<Integer> list(int userId);
}
