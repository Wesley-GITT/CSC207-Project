package use_case.order.list_customer_orders;

import data_access.order.InMemoryOrderDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.OrderFactory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ListCustomerOrdersInteractorTest {

    @Test
    public void successListCustomerOrdersTest() {
        ListCustomerOrdersInputData inputData = new ListCustomerOrdersInputData("wes", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        OrderFactory orderFactory = new OrderFactory();
        orderRepo.add(orderFactory.create(user.getId(), OrderFactory.SELLER));
        orderRepo.add(orderFactory.create(user.getId(), OrderFactory.SELLER));
        orderRepo.add(orderFactory.create(user.getId(), OrderFactory.BUYER));
        orderRepo.add(orderFactory.create(100, OrderFactory.SELLER));

        Set<Integer> orderIds = new HashSet<>();
        orderIds.add(0);
        orderIds.add(1);

        ListCustomerOrdersOutputBoundary successPresenter = new ListCustomerOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListCustomerOrdersOutputData outputData) {
                assertEquals(outputData.getOrderIds(), orderIds);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ListCustomerOrdersInteractor interactor = new ListCustomerOrdersInteractor(userRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserNotAuthorizedTest() {
        ListCustomerOrdersInputData inputData = new ListCustomerOrdersInputData("wes", "321");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ListCustomerOrdersOutputBoundary failurePresenter = new ListCustomerOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListCustomerOrdersOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ListCustomerOrdersInteractor interactor = new ListCustomerOrdersInteractor(userRepo, orderRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
