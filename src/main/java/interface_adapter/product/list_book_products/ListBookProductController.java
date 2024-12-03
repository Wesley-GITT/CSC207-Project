package interface_adapter.product.list_book_products;

import use_case.product.list_book_products.ListBookProductInputBoundary;
import use_case.product.list_book_products.ListBookProductInputData;

/**
 * The controller for the Login Use Case.
 */
public class ListBookProductController {

    private final ListBookProductInputBoundary listBookProductInteractor;

    public ListBookProductController(ListBookProductInputBoundary listBookProductInteractor) {
        this.listBookProductInteractor = listBookProductInteractor;
    }

    public void execute(String bookId) {
        final ListBookProductInputData listBookProductInputData = new ListBookProductInputData(bookId);
        listBookProductInteractor.execute(listBookProductInputData);
    }
}
