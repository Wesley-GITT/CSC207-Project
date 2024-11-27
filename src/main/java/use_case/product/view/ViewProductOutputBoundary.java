package use_case.product.view;

public interface ViewProductOutputBoundary {

    void prepareSuccessView(ViewProductOutputData viewProductOutputData);

    void prepareFailView(String errorMessage);
}