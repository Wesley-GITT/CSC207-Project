package use_case.product.remove;

public interface RemoveProductOutputBoundary {

    /**
     * PrepareSuccessView for RemoveProductOutputBoundary.
     * @param removeProductOutputData RemoveProductInputBoundary.
     */
    void prepareSuccessView(RemoveProductOutputData removeProductOutputData);

    /**
     * PrepareFailView for RemoveProductOutputBoundary.
     * @param errorMessage errorMessage.
     */
    void prepareFailView(String errorMessage);
}
