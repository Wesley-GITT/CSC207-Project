package use_case.product.list_my_products;

public interface ListMyProductOutputBoundary {

    void prepareSuccessView(ListMyProductOutputData listMyProductOutputData);

    void prepareFailView(String errorMessage);
}
