package use_case.product.create;

import use_case.product.create.CreateProductInputBoundary;
import use_case.book.search.SearchInputData;
import use_case.book.search.SearchOutputBoundary;

public class CreateProductInteractor implements CreateProductInputBoundary{

    private final CreateProductDataAccessInterface createProductDataAccessInterface;
    private final CreateProductOutputBoundary createProductOutputBoundary;

    public CreateProductInteractor(CreateProductDataAccessInterface bookDataAccessInterface, CreateProductOutputBoundary createProductOutputBoundary) {
        this.createProductDataAccessInterface = bookDataAccessInterface;
        this.createProductOutputBoundary = createProductOutputBoundary;
    }

    @Override
    public void execute(SearchInputData searchInputData) {

    }
}
