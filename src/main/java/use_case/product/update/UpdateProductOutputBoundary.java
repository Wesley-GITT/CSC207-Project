package use_case.product.update;

public interface UpdateProductOutputBoundary {

    /**
     * PrepareSuccessView for UpdateProductOutputBoundary.
     * @param updateProductOutputData updateProductOutputData.
     */
    void prepareSuccessView(UpdateProductOutputData updateProductOutputData);

    /**
     * PrepareFailView for UpdateProductOutputBoundary.
     * @param errorMessage errorMessage.
     */
    void prepareFailView(String errorMessage);
}
