package use_case.product;

/*
This interface defines the method that handles the output after processing a product request.
 */
public interface ProductOutputBoundary {
    void presentProductResult(ProductOutputData outputData);
}
