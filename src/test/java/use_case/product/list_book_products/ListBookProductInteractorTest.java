package use_case.product.list_book_products;

import data_access.book.InMemoryBookDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import entity.BookFactory;
import entity.ProductFactory;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class ListBookProductInteractorTest {

    @Test
    public void successListBookProductTest() {
        final ListBookProductInputData inputData = new ListBookProductInputData("included");
        final InMemoryBookDataAccessObject bookDAO = new InMemoryBookDataAccessObject();
        final InMemoryProductDataAccessObject productDAO = new InMemoryProductDataAccessObject();

        ProductFactory productFactory = new ProductFactory();
        productDAO.add(productFactory.create("included"));
        productDAO.add(productFactory.create("included"));
        productDAO.add(productFactory.create("excluded"));

        BookFactory bookFactory = new BookFactory();
        bookDAO.save(bookFactory.create("included", "Harry Potter 3"));
        bookDAO.save(bookFactory.create("excluded", "Harry Potter 2"));

        final ListBookProductOutputBoundary successPresenter = new ListBookProductOutputBoundary() {
            @Override
            public void prepareSuccessView(ListBookProductOutputData listBookProductOutputData) {
                final Set<Integer> productIds = listBookProductOutputData.getProductIds();
                assertTrue(productIds.contains(0));
                assertTrue(productIds.contains(1));
                assertEquals(productIds.size(), 2);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        final ListBookProductInteractor interactor = new ListBookProductInteractor(
                bookDAO, productDAO, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureBookNotExistTest() {
        final ListBookProductInputData inputData = new ListBookProductInputData("other");
        final InMemoryBookDataAccessObject bookDAO = new InMemoryBookDataAccessObject();
        final InMemoryProductDataAccessObject productDAO = new InMemoryProductDataAccessObject();

        ProductFactory productFactory = new ProductFactory();
        productDAO.add(productFactory.create("included"));

        BookFactory bookFactory = new BookFactory();
        bookDAO.save(bookFactory.create("included", "Harry Potter 3"));

        final ListBookProductOutputBoundary failurePresenter = new ListBookProductOutputBoundary() {
            @Override
            public void prepareSuccessView(ListBookProductOutputData listBookProductOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Book with ID `other` doesn't exist", errorMessage);
            }
        };

        final ListBookProductInteractor interactor = new ListBookProductInteractor(
                bookDAO, productDAO, failurePresenter);
        interactor.execute(inputData);
    }
}
