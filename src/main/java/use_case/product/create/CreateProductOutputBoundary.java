package use_case.product.create;

public interface CreateProductOutputBoundary {

    /**
     * PrepareFailView for CreateProductOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);

    /**
     * PrepareSuccessView for CreateProductOutputBoundary.
     * @param createProductOutputData createProductOutputData
     */
    void prepareSuccessView(CreateProductOutputData createProductOutputData);
}
