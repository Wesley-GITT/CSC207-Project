package use_case.product;

/*
This interface defines the methods that the ProductInteractor will implement for managing product listings.
 */
public interface ProductInputBoundary {
    ProductOutputData postProduct(ProductInputData inputData);
    ProductOutputData editProduct(ProductInputData inputData);
    ProductOutputData deleteProduct(Integer productId);
}
