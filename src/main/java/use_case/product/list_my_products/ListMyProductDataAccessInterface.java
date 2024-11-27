package use_case.product.list_my_products;

import use_case.product.create.CreateProductDataAccessInterface;

import java.util.Set;

public interface ListMyProductDataAccessInterface extends CreateProductDataAccessInterface {

    Set<Integer> list(int userId);
}
