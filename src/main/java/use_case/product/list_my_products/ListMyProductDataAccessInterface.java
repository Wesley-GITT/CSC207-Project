package use_case.product.list_my_products;

import java.util.Set;

public interface ListMyProductDataAccessInterface {

    Set<Integer> listByUserId(int userId);
}
