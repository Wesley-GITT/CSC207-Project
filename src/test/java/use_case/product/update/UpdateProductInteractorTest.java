package use_case.product.update;

import data_access.book.InMemoryBookDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.BookFactory;
import entity.MyUserFactory;
import entity.ProductFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdateProductInteractorTest {

    @Test
    public void successUpdateProductTest() {
        final UpdateProductInputData inputData = new UpdateProductInputData(
                "wes", "123", 0,
                "Excellent", 12.0, false);

        final InMemoryUserDataAccessObject userDAO = new InMemoryUserDataAccessObject();
        final InMemoryBookDataAccessObject bookDAO = new InMemoryBookDataAccessObject();
        final InMemoryProductDataAccessObject productDAO = new InMemoryProductDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        userDAO.add(userFactory.create("wes", "123"));

        ProductFactory productFactory = new ProductFactory();
        productDAO.add(productFactory.create("same", 0));

        BookFactory bookFactory = new BookFactory();
        bookDAO.save(bookFactory.create("same", "Harry Potter 3"));

        final UpdateProductOutputBoundary successPresenter = new UpdateProductOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateProductOutputData updateProductOutputData) {
                final String bookCondition = updateProductOutputData.getBookCondition();
                final Double price = updateProductOutputData.getPrice();
                assertEquals("Excellent", bookCondition);
                assertEquals(12.0, price, 0.01);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        final UpdateProductInteractor interactor = new UpdateProductInteractor(
                userDAO, bookDAO, productDAO, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureIncorrectUsernamePasswordPairTest() {
        final UpdateProductInputData inputData = new UpdateProductInputData(
                "wes", "321", 0, "Excellent", 12.0, false);

        final InMemoryUserDataAccessObject userDAO = new InMemoryUserDataAccessObject();
        final InMemoryBookDataAccessObject bookDAO = new InMemoryBookDataAccessObject();
        final InMemoryProductDataAccessObject productDAO = new InMemoryProductDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        userDAO.add(userFactory.create("wes", "123"));

        ProductFactory productFactory = new ProductFactory();
        productDAO.add(productFactory.create("same", 0));

        BookFactory bookFactory = new BookFactory();
        bookDAO.save(bookFactory.create("same", "Harry Potter 3"));

        final UpdateProductOutputBoundary failurePresenter = new UpdateProductOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateProductOutputData updateProductOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        final UpdateProductInteractor interactor = new UpdateProductInteractor(
                userDAO, bookDAO, productDAO, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserNotAuthorizedTest() {
        final UpdateProductInputData inputData = new UpdateProductInputData(
                "wes", "123", 0, "Excellent", 12.0, true);

        final InMemoryUserDataAccessObject userDAO = new InMemoryUserDataAccessObject();
        final InMemoryBookDataAccessObject bookDAO = new InMemoryBookDataAccessObject();
        final InMemoryProductDataAccessObject productDAO = new InMemoryProductDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        userDAO.add(userFactory.create("wes", "123"));

        ProductFactory productFactory = new ProductFactory();
        productDAO.add(productFactory.create("same", -1));

        BookFactory bookFactory = new BookFactory();
        bookDAO.save(bookFactory.create("same", "Harry Potter 3"));

        final UpdateProductOutputBoundary failurePresenter = new UpdateProductOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateProductOutputData updateProductOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        final UpdateProductInteractor interactor = new UpdateProductInteractor(
                userDAO, bookDAO, productDAO, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureProductNotExistTest() {
        final UpdateProductInputData inputData = new UpdateProductInputData(
                "wes", "123", 1, "Excellent", 12.0, true);

        final InMemoryUserDataAccessObject userDAO = new InMemoryUserDataAccessObject();
        final InMemoryBookDataAccessObject bookDAO = new InMemoryBookDataAccessObject();
        final InMemoryProductDataAccessObject productDAO = new InMemoryProductDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        userDAO.add(userFactory.create("wes", "123"));

        ProductFactory productFactory = new ProductFactory();
        productDAO.add(productFactory.create("same", 0));

        BookFactory bookFactory = new BookFactory();
        bookDAO.save(bookFactory.create("same", "Harry Potter 3"));

        final UpdateProductOutputBoundary failurePresenter = new UpdateProductOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateProductOutputData updateProductOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("ListProductView with ID `1` doesn't exist", errorMessage);
            }
        };

        final UpdateProductInteractor interactor = new UpdateProductInteractor(
                userDAO, bookDAO, productDAO, failurePresenter);
        interactor.execute(inputData);
    }

}
