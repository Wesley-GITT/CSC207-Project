package use_case.order.list_my_orders;

import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ListMyOrdersInteractorTest {

    private InMemoryItemsUserDataAccessObject dataAccess;
    private MyUserFactory userFactory;
    private MyUser testUser;

    @Before
    public void setup() {
        // Initialize the data access object
        dataAccess = new InMemoryItemsUserDataAccessObject();

        // Create and save a test user
        userFactory = new MyUserFactory();
        testUser = userFactory.create("Ao", "password123");
        testUser.setId(1);
        dataAccess.save(testUser);

        // Create and save orders
        dataAccess.saveOrder(new Order(1, 1, 2, 101, null, 0, "123 Street"));
        dataAccess.saveOrder(new Order(2, 1, 3, 102, null, 0, "123 Street"));
        dataAccess.saveOrder(new Order(3, 2, 1, 103, null, 0, "456 Street")); // Different buyer
    }

    @Test
    public void testListMyOrdersSuccess() {
        // Input for a valid user
        ListMyOrdersInputData inputData = new ListMyOrdersInputData("Ao", "password123");

        // Mock presenter
        ListMyOrdersOutputBoundary presenter = new ListMyOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyOrdersOutputData outputData) {
                List<Integer> productIds = outputData.getProductIds();

                // Validate the output
                assertNotNull("Product IDs list should not be null", productIds);
                assertEquals("Should have exactly 2 orders", 2, productIds.size());
                assertTrue("Product IDs should contain 101 and 102",
                        productIds.containsAll(List.of(101, 102)));
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure: " + errorMessage);
            }
        };

        // Create and execute the interactor
        ListMyOrdersInteractor interactor = new ListMyOrdersInteractor(dataAccess, presenter);
        interactor.execute(inputData);
    }

    @Test
    public void testListMyOrdersAuthenticationFailure() {
        // Input with wrong password
        ListMyOrdersInputData inputData = new ListMyOrdersInputData("Ao", "wrongPassword");

        // Mock presenter
        ListMyOrdersOutputBoundary presenter = new ListMyOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyOrdersOutputData outputData) {
                fail("Authentication failure should not lead to success");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed.", errorMessage);
            }
        };

        // Create and execute the interactor
        ListMyOrdersInteractor interactor = new ListMyOrdersInteractor(dataAccess, presenter);
        interactor.execute(inputData);
    }

    @Test
    public void testListMyOrdersNoOrders() {
        // Create and save a new user with no orders
        MyUser newUser = userFactory.create("NewUser", "newpassword");
        newUser.setId(8);
        dataAccess.save(newUser);

        // Input for the new user
        ListMyOrdersInputData inputData = new ListMyOrdersInputData("NewUser", "newpassword");

        // Mock presenter
        ListMyOrdersOutputBoundary presenter = new ListMyOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyOrdersOutputData outputData) {
                List<Integer> productIds = outputData.getProductIds();

                // Validate the output
                assertNotNull("Product IDs list should not be null", productIds);
                assertTrue("Product IDs list should be empty", productIds.isEmpty());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure: " + errorMessage);
            }
        };

        // Create and execute the interactor
        ListMyOrdersInteractor interactor = new ListMyOrdersInteractor(dataAccess, presenter);
        interactor.execute(inputData);
    }
}
