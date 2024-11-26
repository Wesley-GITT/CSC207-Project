package use_case.order.cancel;

import data_access.order.InMemoryOrderDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.*;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;


public class CancelOrderInteractorTest {

    @Test
    public void successListCustomerOrdersTest() {
        CancelOrderInputData inputData = new CancelOrderInputData("wes", "123", 0);
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.create(0,"fdjj34jf", 1, "", 0);

        OrderFactory orderFactory = new OrderFactory();
        orderRepo.add(orderFactory.create(-1, user.getId(), product.getSellerId(), product.getId(), Calendar.getInstance(), "hidsinke, 39 St, Cadkie"));

        CancelOrderOutputBoundary successPresenter = new CancelOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CancelOrderOutputData outputData) {
                assertEquals(outputData.getOrderId(), 0);
                assertFalse(orderRepo.exist(0));
                assertFalse(product.getIsSold());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        CancelOrderInteractor interactor = new CancelOrderInteractor(userRepo, productRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureIncorrectUsernamePasswordPairTest() {
        CancelOrderInputData inputData = new CancelOrderInputData("wes", "321", 0);
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.create(0,"fdjj34jf", 1, "", 0);

        OrderFactory orderFactory = new OrderFactory();
        orderRepo.add(orderFactory.create(-1, user.getId(), product.getSellerId(), product.getId(), Calendar.getInstance(), "hidsinke, 39 St, Cadkie"));

        CancelOrderOutputBoundary successPresenter = new CancelOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CancelOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        CancelOrderInteractor interactor = new CancelOrderInteractor(userRepo, productRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotBuyerTest() {
        CancelOrderInputData inputData = new CancelOrderInputData("wes", "123", 0);
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.create(0,"fdjj34jf", 1, "", 0);

        OrderFactory orderFactory = new OrderFactory();
        orderRepo.add(orderFactory.create(-1, 10, product.getSellerId(), product.getId(), Calendar.getInstance(), "hidsinke, 39 St, Cadkie"));

        CancelOrderOutputBoundary successPresenter = new CancelOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CancelOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        CancelOrderInteractor interactor = new CancelOrderInteractor(userRepo, productRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureOrderNotExistTest() {
        CancelOrderInputData inputData = new CancelOrderInputData("wes", "123", 10);
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.create(0,"fdjj34jf", 1, "", 0);

        OrderFactory orderFactory = new OrderFactory();
        orderRepo.add(orderFactory.create(-1, 10, product.getSellerId(), product.getId(), Calendar.getInstance(), "hidsinke, 39 St, Cadkie"));

        CancelOrderOutputBoundary successPresenter = new CancelOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CancelOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Order with ID `10` doesn't exist", errorMessage);
            }
        };

        CancelOrderInteractor interactor = new CancelOrderInteractor(userRepo, productRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }
}
