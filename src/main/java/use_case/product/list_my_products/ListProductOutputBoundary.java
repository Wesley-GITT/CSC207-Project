package use_case.product.list_my_products;

public interface ListProductOutputBoundary {

    void prepareSuccessView(ListProductOutputData listProductOutputData);

    void prepareFailView(String errorMessage);
}