package use_case.product.update;

public interface UpdateProductOutputBoundary {

    void prepareSuccessView(UpdateProductOutputData updateProductOutputData);

    void prepareFailView(String errorMessage);
}