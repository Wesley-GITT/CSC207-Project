package use_case.product.list_my_products;

import use_case.product.create.CreateProductUserDataAccessInterface;

import java.util.Set;

public interface ListProductUserDataAccessInterface extends CreateProductUserDataAccessInterface {

    Set<Integer> list(int userId);
}
