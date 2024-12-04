package use_case.product.list_my_products;

public interface ListMyProductOutputBoundary {

    /**
     * PrepareSuccessView for ListMyProductOutputBoundary.
     * @param listMyProductOutputData listMyProductOutputData
     */
    void prepareSuccessView(ListMyProductOutputData listMyProductOutputData);

    /**
     * PrepareFailView for ListMyProductOutputBoundary.
     * @param errorMessage errorMessage
     */
    void c(String errorMessage);
}
