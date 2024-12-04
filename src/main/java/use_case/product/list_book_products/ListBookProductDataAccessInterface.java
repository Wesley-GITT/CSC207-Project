package use_case.product.list_book_products;

import java.util.Set;

import use_case.product.create.CreateProductDataAccessInterface;

public interface ListBookProductDataAccessInterface extends CreateProductDataAccessInterface {

    Set<Integer> listByBookId(String bookId);
}
