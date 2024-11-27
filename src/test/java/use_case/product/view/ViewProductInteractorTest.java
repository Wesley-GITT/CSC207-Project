package use_case.product.view;

import data_access.product.InMemoryProductDataAccessObject;
import entity.ProductFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ViewProductInteractorTest {

    @Test
    public void successViewProductTest(){
        final ViewProductInputData inputData = new ViewProductInputData(0);
        final InMemoryProductDataAccessObject productDAO = new InMemoryProductDataAccessObject();

        final ProductFactory productFactory = new ProductFactory();
        productDAO.add(productFactory.create("test1"));

        final ViewProductOutputBoundary successPresenter = new ViewProductOutputBoundary() {

            @Override
            public void prepareSuccessView(ViewProductOutputData viewProductOutputData) {
                assertEquals("test1", viewProductOutputData.getBookId());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ViewProductInteractor interactor = new ViewProductInteractor(productDAO, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureProductNotExistTest(){
        final ViewProductInputData inputData = new ViewProductInputData(1);
        final InMemoryProductDataAccessObject productDAO = new InMemoryProductDataAccessObject();

        final ProductFactory productFactory = new ProductFactory();
        productDAO.add(productFactory.create("test1"));

        final ViewProductOutputBoundary failurePresenter = new ViewProductOutputBoundary() {

            @Override
            public void prepareSuccessView(ViewProductOutputData viewProductOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Product with ID `1` doesn't exist", errorMessage);
            }
        };

        ViewProductInteractor interactor = new ViewProductInteractor(productDAO, failurePresenter);
        interactor.execute(inputData);
    }

}
