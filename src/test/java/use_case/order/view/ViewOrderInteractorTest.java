package use_case.order.view;

import data_access.CompositeDataAccessObject;
import data_access.order.InMemoryOrderDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.Order;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class ViewOrderInteractorTest {

    private CompositeDataAccessObject compositeDataAccess;
    private InMemoryItemsUserDataAccessObject itemUserDataAccess;
    private InMemoryProductDataAccessObject productDataAccess;
    private InMemoryOrderDataAccessObject orderDataAccess;
    private MyUserFactory userFactory;
    private MyUser testUser;
    private Order testOrder;

    @Before
    public void setup() {
        // Shared map for user data
        Map<String, MyUser> sharedUsersByName = new HashMap<>();

        // Initialize individual data access objects
        itemUserDataAccess = new InMemoryItemsUserDataAccessObject();
        productDataAccess = new InMemoryProductDataAccessObject();
        orderDataAccess = new InMemoryOrderDataAccessObject(sharedUsersByName);

        // Synchronize user data between itemUserDataAccess and orderDataAccess
        compositeDataAccess = new CompositeDataAccessObject(
                itemUserDataAccess, productDataAccess, orderDataAccess
        );

        // Create and save a test user
        userFactory = new MyUserFactory();
        testUser = userFactory.create("Ao", "password123");
        testUser.setId(1);
        testUser.setAddress("123 Test Street");

        // Save user in itemUserDataAccess and shared map
        itemUserDataAccess.save(testUser);
        sharedUsersByName.put(testUser.getUsername(), testUser);

        // Create and save a test order
        testOrder = new Order(1, testUser.getId(), 2, 100, new Date(), 0, testUser.getAddress());
        orderDataAccess.saveOrder(testOrder);
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

        ViewOrderInteractor interactor = new ViewOrderInteractor(compositeDataAccess, presenter);
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

        ViewOrderInteractor interactor = new ViewOrderInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);
    }

    @Test
    public void testViewOrderWithoutSaving() {
        // Shared map for user data
        Map<String, MyUser> sharedUsersByName = new HashMap<>();

        // Reinitialize empty data access objects
        itemUserDataAccess = new InMemoryItemsUserDataAccessObject();
        orderDataAccess = new InMemoryOrderDataAccessObject(sharedUsersByName);

        // Reinitialize the composite data access object
        compositeDataAccess = new CompositeDataAccessObject(
                itemUserDataAccess, productDataAccess, orderDataAccess
        );

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

        ViewOrderInteractor interactor = new ViewOrderInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);
    }
}
