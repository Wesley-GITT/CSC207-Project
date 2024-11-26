package use_case.order.list_my_orders;

import data_access.order.InMemoryOrderDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Order;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ListMyOrdersInteractorTest {

    private CompositeDataAccessObject compositeDataAccess;
    private InMemoryUserDataAccessObject itemUserDataAccess;
    private InMemoryProductSaveGetDataAccessObject productDataAccess;
    private InMemoryOrderDataAccessObject orderDataAccess;
    private MyUserFactory userFactory;
    private MyUser testUser;
    private Map<String, MyUser> sharedUsersByName;

    @Before
    public void setup() {
        // Shared map for user data
        sharedUsersByName = new HashMap<>();

        // Initialize individual data access objects
        itemUserDataAccess = new InMemoryUserDataAccessObject();
        productDataAccess = new InMemoryProductSaveGetDataAccessObject();
        orderDataAccess = new InMemoryOrderDataAccessObject(sharedUsersByName);

        // Synchronize user data between itemUserDataAccess and orderDataAccess
        compositeDataAccess = new CompositeDataAccessObject(
                itemUserDataAccess, productDataAccess, orderDataAccess
        );

        // Create and save a test user
        userFactory = new MyUserFactory();
        testUser = userFactory.create("Ao", "password123");
        testUser.setId(1);

        // Save user in itemUserDataAccess and shared map
        itemUserDataAccess.save(testUser);
        sharedUsersByName.put(testUser.getUsername(), testUser);

        // Save some orders for the test user
        orderDataAccess.save(new Order(1, 1, 2, 101, null, 0, "123 Test Street"));
        orderDataAccess.save(new Order(2, 1, 3, 102, null, 0, "123 Test Street"));
        orderDataAccess.save(new Order(3, 2, 1, 103, null, 0, "456 Another Street")); // Different buyer
    }

    @Test
    public void testListMyOrdersSuccess() {
        ListMyOrdersInputData inputData = new ListMyOrdersInputData("Ao", "password123");

        ListMyOrdersOutputBoundary presenter = new ListMyOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyOrdersOutputData outputData) {
                List<Integer> productIds = outputData.getProductIds();
                assertNotNull(productIds);
                assertEquals(2, productIds.size());
                assertTrue(productIds.containsAll(List.of(101, 102)));
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure: " + errorMessage);
            }
        };

        ListMyOrdersInteractor interactor = new ListMyOrdersInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);
    }

    @Test
    public void testListMyOrdersAuthenticationFailure() {
        ListMyOrdersInputData inputData = new ListMyOrdersInputData("Ao", "wrongPassword");

        ListMyOrdersOutputBoundary presenter = new ListMyOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyOrdersOutputData outputData) {
                fail("Authentication failure should not lead to success");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ListMyOrdersInteractor interactor = new ListMyOrdersInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);
    }

    @Test
    public void testListMyOrdersNoOrders() {
        // Create a new user
        MyUser newUser = userFactory.create("NewUser", "newpassword");
        newUser.setId(8);

        // Save user in itemUserDataAccess and shared map
        itemUserDataAccess.save(newUser);
        sharedUsersByName.put(newUser.getUsername(), newUser);

        ListMyOrdersInputData inputData = new ListMyOrdersInputData("NewUser", "newpassword");

        ListMyOrdersOutputBoundary presenter = new ListMyOrdersOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyOrdersOutputData outputData) {
                List<Integer> productIds = outputData.getProductIds();
                assertNotNull(productIds);
                assertTrue(productIds.isEmpty());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure: " + errorMessage);
            }
        };

        ListMyOrdersInteractor interactor = new ListMyOrdersInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);
    }
}
