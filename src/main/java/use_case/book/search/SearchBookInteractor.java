package use_case.book.search;

import use_case.product.list_book_products.ListBookProductDataAccessInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SearchBookInteractor implements SearchBookInputBoundary {

    private final ListBookProductDataAccessInterface productDataAccessObject;
    private final SearchBookDataAccessInterface bookDataAccessObject;
    private final SearchBookOutputBoundary searchBookPresenter;

    public SearchBookInteractor(ListBookProductDataAccessInterface productDataAccessObject,
                                SearchBookDataAccessInterface bookDataAccessObject,
                                SearchBookOutputBoundary searchBookPresenter) {

        this.productDataAccessObject = productDataAccessObject;
        this.bookDataAccessObject = bookDataAccessObject;
        this.searchBookPresenter = searchBookPresenter;
    }

    @Override
    public void execute(SearchBookInputData inputData) {
        final String keyword = inputData.getKeyword();
        final int resMaxNumEachSearch = inputData.getResMaxNumEachSearch();
        final boolean withProduct = inputData.isWithProduct();
        final int startIndex = inputData.getStartIndex();
        int endIndex = startIndex;

        if (startIndex < 0) {
            searchBookPresenter.prepareFailView("Start index is out of range");
            return;
        }

        if (resMaxNumEachSearch < 1) {
            searchBookPresenter.prepareFailView("Maximum number of items each search can't be less than 1");
            return;
        }

        try {
            List<String> result = new ArrayList<>();
            while (result.size() < resMaxNumEachSearch) {
                List<String> bookIds = bookDataAccessObject.search(keyword, endIndex, 40);
                if (bookIds.size() == 0) {
                    break;
                }

                for (String bookId : bookIds) {
                    Set<Integer> productIds = productDataAccessObject.listByBookId(bookId);
                    if (withProduct) {
                        if (!productIds.isEmpty()) {
                            result.add(bookId);
                        }
                    } else {
                        result.add(bookId);
                    }

                    endIndex++;
                    if (result.size() >= resMaxNumEachSearch) {
                        break;
                    }
                }
                if (result.size() >= resMaxNumEachSearch) {
                    break;
                }
            }

            SearchBookOutputData outputData = new SearchBookOutputData(
                    result, startIndex, endIndex, resMaxNumEachSearch);
            searchBookPresenter.prepareSuccessView(outputData);
        } catch (RuntimeException e) {
            searchBookPresenter.prepareFailView("API Connection Error");
        }
    }
}
