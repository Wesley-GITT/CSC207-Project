package use_case.product.list_book_products;

import use_case.book.view.ViewBookDataAccessInterface;

import java.util.Set;

public class ListBookProductInteractor implements ListBookProductInputBoundary {

    private ViewBookDataAccessInterface bookDataAccessObject;
    private ListBookProductDataAccessInterface productDataAccessObject;
    private ListBookProductOutputBoundary listProductPresenter;

    public ListBookProductInteractor(ViewBookDataAccessInterface bookDataAccessObject,
                                     ListBookProductDataAccessInterface productDataAccessObject,
                                     ListBookProductOutputBoundary listProductPresenter) {

        this.bookDataAccessObject = bookDataAccessObject;
        this.productDataAccessObject = productDataAccessObject;
        this.listProductPresenter = listProductPresenter;
    }

    @Override
    public void execute(ListBookProductInputData listBookProductInputData) {
        final String bookId = listBookProductInputData.getBookId();

        if (!bookDataAccessObject.exist(bookId)) {
            listProductPresenter.prepareFailView("Book with ID `" + bookId + "` doesn't exist");
            return;
        }

        final Set<Integer> productIds = productDataAccessObject.listByBookId(bookId);
        final ListBookProductOutputData outputData = new ListBookProductOutputData(productIds);
        listProductPresenter.prepareSuccessView(outputData);
    }
}
