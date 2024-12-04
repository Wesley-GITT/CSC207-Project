package use_case.product.list_my_products;

import java.util.Set;

public interface ListMyProductDataAccessInterface {

    /**
     * ListByUserId for ListMyProductDataAccessInterface.
     * @param userId userId
     * @return return
     */
    Set<Integer> listByUserId(int userId);
}
