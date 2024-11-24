package use_case.product.create;

public interface CreateProductOutputBoundary {

    void prepareFailView(String errorMessage);

    void prepareSuccessView(CreateProductOutputData createProductOutputData);
}