package use_case.product.list_book_products;

import use_case.product.create.CreateProductDataAccessInterface;

import java.util.Set;

public interface ListBookProductDataAccessInterface extends CreateProductDataAccessInterface {

    Set<Integer> listByBookId(String bookId);
}
