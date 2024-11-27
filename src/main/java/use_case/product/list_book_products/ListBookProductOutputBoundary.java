package use_case.product.list_book_products;

public interface ListBookProductOutputBoundary {

    void prepareSuccessView(ListBookProductOutputData listBookProductOutputData);

    void prepareFailView(String errorMessage);
}