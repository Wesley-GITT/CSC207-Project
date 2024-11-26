package use_case.order.view;

import data_access.order.InMemoryOrderOrdersOrdersDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Order;
import entity.OrderFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ViewOrderInteractorTest {

    @Test
    public void successBuyerViewOrderTest() {
        ViewOrderInputData inputData = new ViewOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderOrdersOrdersDataAccessObject orderRepo = new InMemoryOrderOrdersOrdersDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        OrderFactory orderFactory = new OrderFactory();
        Order order = orderFactory.create(0, OrderFactory.BUYER);
        orderRepo.add(order);

        ViewOrderOutputBoundary successPresenter = new ViewOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewOrderOutputData outputData) {
                assertEquals(outputData.getBuyerId(), user.getId());
                assertEquals(outputData.getWho(), OrderFactory.BUYER);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case success is unexpected");
            }
        };

        ViewOrderInteractor interactor = new ViewOrderInteractor(userRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void successSellerViewOrderTest() {
        ViewOrderInputData inputData = new ViewOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderOrdersOrdersDataAccessObject orderRepo = new InMemoryOrderOrdersOrdersDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        OrderFactory orderFactory = new OrderFactory();
        Order order = orderFactory.create(0, OrderFactory.SELLER);
        orderRepo.add(order);

        ViewOrderOutputBoundary successPresenter = new ViewOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewOrderOutputData outputData) {
                assertEquals(outputData.getSellerId(), user.getId());
                assertEquals(outputData.getWho(), OrderFactory.SELLER);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ViewOrderInteractor interactor = new ViewOrderInteractor(userRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureOrderNotExistTest() {
        ViewOrderInputData inputData = new ViewOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderOrdersOrdersDataAccessObject orderRepo = new InMemoryOrderOrdersOrdersDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ViewOrderOutputBoundary successPresenter = new ViewOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Order with ID `0` doesn't exist", errorMessage);
            }
        };

        ViewOrderInteractor interactor = new ViewOrderInteractor(userRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureIncorrectUsernamePasswordPairTest () {
        ViewOrderInputData inputData = new ViewOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderOrdersOrdersDataAccessObject orderRepo = new InMemoryOrderOrdersOrdersDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");
        userRepo.add(user);

        OrderFactory orderFactory = new OrderFactory();
        orderRepo.add(orderFactory.create(user.getId(), OrderFactory.BUYER));

        ViewOrderOutputBoundary successPresenter = new ViewOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ViewOrderInteractor interactor = new ViewOrderInteractor(userRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserNotAuthorizedTest() {
        ViewOrderInputData inputData = new ViewOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderOrdersOrdersDataAccessObject orderRepo = new InMemoryOrderOrdersOrdersDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        userRepo.add(userFactory.create("wes", "123"));
        userRepo.add(userFactory.create("sam", "321"));
        userRepo.add(userFactory.create("kesla", "000"));

        OrderFactory orderFactory = new OrderFactory();
        Order order = orderFactory.create(1, OrderFactory.SELLER);
        orderRepo.add(order);

        ViewOrderOutputBoundary successPresenter = new ViewOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ViewOrderInteractor interactor = new ViewOrderInteractor(userRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }
}
