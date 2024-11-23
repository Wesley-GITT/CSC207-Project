package use_case.order.view;

import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.Order;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

public class ViewOrderInteractorTest {

    private InMemoryItemsUserDataAccessObject dataAccess;
    private MyUserFactory userFactory;
    private MyUser testUser;
    private Order testOrder;

    @Before
    public void setup() {

        dataAccess = new InMemoryItemsUserDataAccessObject();

        userFactory = new MyUserFactory();
        testUser = userFactory.create("Ao", "password123");
        testUser.setId(1);
        testUser.setAddress("123 Test Street");
        dataAccess.save(testUser);

        testOrder = new Order(1, testUser.getId(),2,100, new Date()
                , 0, testUser.getAddress());
        dataAccess.saveOrder(testOrder);
    }

    @Test
    public void testViewOrderSuccess() {

        ViewOrderInputData inputData = new ViewOrderInputData(1);

        ViewOrderOutputBoundary presenter = new ViewOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewOrderOutputData outputData) {
                assertNotNull(outputData);
                assertEquals(1, outputData.getBuyerId());
                assertEquals(2, outputData.getSellerId());
                assertEquals(100, outputData.getProductId());
                assertEquals("123 Test Street", outputData.getDeliveryAddress());
                assertEquals(0, outputData.getOrderStatus());
                assertNotNull(outputData.getOrderTime());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure: " + errorMessage);
            }
        };

        ViewOrderInteractor interactor = new ViewOrderInteractor(dataAccess, presenter);
        interactor.execute(inputData);
    }

    @Test
    public void testViewOrderWithInvalidOrderId() {

        ViewOrderInputData inputData = new ViewOrderInputData(-1);

        ViewOrderOutputBoundary presenter = new ViewOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewOrderOutputData outputData) {
                fail("Use case succeeded unexpectedly for an invalid order ID.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Order not found.", errorMessage);
            }
        };

        ViewOrderInteractor interactor = new ViewOrderInteractor(dataAccess, presenter);
        interactor.execute(inputData);
    }

    @Test
    public void testViewOrderWithoutSaving() {
        // Simulate a scenario where no orders are saved
        dataAccess = new InMemoryItemsUserDataAccessObject();

        ViewOrderInputData inputData = new ViewOrderInputData(1);

        ViewOrderOutputBoundary presenter = new ViewOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewOrderOutputData outputData) {
                fail("Use case succeeded unexpectedly when no orders were saved.");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Order not found.", errorMessage);
            }
        };

        ViewOrderInteractor interactor = new ViewOrderInteractor(dataAccess, presenter);
        interactor.execute(inputData);
    }
}
