package use_case.order.list_my_orders;

import data_access.order.InMemoryOrderOrdersOrdersDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.OrderFactory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ListMyOrdersInteractorTest {

    @Test
    public void successListMyOrdersTest() {
        ListMyOrdersInputData inputData = new ListMyOrdersInputData("wes", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderOrdersOrdersDataAccessObject orderRepo = new InMemoryOrderOrdersOrdersDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        OrderFactory orderFactory = new OrderFactory();
        orderRepo.add(orderFactory.create(user.getId(), OrderFactory.BUYER));
        orderRepo.add(orderFactory.create(user.getId(), OrderFactory.BUYER));
        orderRepo.add(orderFactory.create(user.getId(), OrderFactory.SELLER));
        orderRepo.add(orderFactory.create(100, OrderFactory.BUYER));

        Set<Integer> orderIds = new HashSet<>();
        orderIds.add(0);
        orderIds.add(1);

        ListMyOrdersOutputBoundary successPresenter = new ListMyOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyOrdersOutputData outputData) {
                assertEquals(outputData.getOrderIds(), orderIds);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ListMyOrdersInteractor interactor = new ListMyOrdersInteractor(userRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserNotAuthorizedTest() {
        ListMyOrdersInputData inputData = new ListMyOrdersInputData("wes", "321");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderOrdersOrdersDataAccessObject orderRepo = new InMemoryOrderOrdersOrdersDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ListMyOrdersOutputBoundary failurePresenter = new ListMyOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyOrdersOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ListMyOrdersInteractor interactor = new ListMyOrdersInteractor(userRepo, orderRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
