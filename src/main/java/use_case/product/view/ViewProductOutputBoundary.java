package use_case.product.view;

public interface ViewProductOutputBoundary {

    /**
     * PrepareSuccessView for ViewProductOutputBoundary.
     * @param viewProductOutputData viewProductOutputData
     */
    void prepareSuccessView(ViewProductOutputData viewProductOutputData);

    /**
     * PrepareFailView for ViewProductOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);
}
