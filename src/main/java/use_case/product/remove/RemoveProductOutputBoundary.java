package use_case.product.remove;

public interface RemoveProductOutputBoundary {

    void prepareSuccessView(RemoveProductOutputData removeProductOutputData);

    void prepareFailView(String errorMessage);
}