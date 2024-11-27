package use_case.order.create;

import data_access.CompositeDataAccessObject;
import data_access.order.InMemoryOrderDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Order;
import entity.Product;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class CreateOrderInteractorTest {

    private CompositeDataAccessObject compositeDataAccess;
    private InMemoryItemsUserDataAccessObject itemUserDataAccess;
    private InMemoryProductDataAccessObject productDataAccess;
    private InMemoryOrderDataAccessObject orderDataAccess;
    private MyUserFactory userFactory;
    private MyUser testUser;
    private Product testProduct;

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

        userFactory = new MyUserFactory();
        testUser = userFactory.create("Ao", "password123");
        testUser.setId(1);
        testUser.setAddress("123 Test Street");

        // Save user in itemUserDataAccess and shared map
        itemUserDataAccess.save(testUser);
        sharedUsersByName.put(testUser.getUsername(), testUser);

        testProduct = new Product(1, "book1", "2", "new", 100.0f, false);
        productDataAccess.saveProduct(testProduct);
    }

    @Test
    public void testCreateOrderSuccess() {
        CreateOrderInputData inputData = new CreateOrderInputData("Ao", "password123", 1);

        CreateOrderOutputBoundary presenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData createOrderOutputData) {
                assertEquals(1, createOrderOutputData.getProductId());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Unexpected failure: " + errorMessage);
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);

        // Verify product is marked as sold
        Product updatedProduct = productDataAccess.getProductById(1);
        assertNotNull(updatedProduct);
        assertTrue(updatedProduct.isSold());

        // Verify order is saved
        Order savedOrder = orderDataAccess.getOrder(1);
        assertNotNull(savedOrder);
        assertEquals(1, savedOrder.getBuyerId());
        assertEquals(1, savedOrder.getProductId());
        assertEquals("123 Test Street", savedOrder.getDeliveryAddress());
    }

    @Test
    public void testCreateOrderAuthenticationFailure() {
        CreateOrderInputData inputData = new CreateOrderInputData("Ao", "wrongPassword", 1);

        CreateOrderOutputBoundary presenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData createOrderOutputData) {
                fail("Use case succeeded unexpectedly");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed.", errorMessage);
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);

        // Verify product is not sold
        Product unchangedProduct = productDataAccess.getProductById(1);
        assertFalse(unchangedProduct.isSold());

        // Verify no order is created
        assertNull(orderDataAccess.getOrder(1));
    }

    @Test
    public void testCreateOrderProductNotFound() {
        CreateOrderInputData inputData = new CreateOrderInputData("Ao", "password123", 99);

        CreateOrderOutputBoundary presenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData createOrderOutputData) {
                fail("Use case succeeded unexpectedly");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Product not found.", errorMessage);
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);

        // Verify no order is created
        assertNull(orderDataAccess.getOrder(1));
    }

    @Test
    public void testCreateOrderProductAlreadySold() {
        testProduct.setSold(true);
        productDataAccess.saveProduct(testProduct);

        CreateOrderInputData inputData = new CreateOrderInputData("Ao", "password123", 1);

        CreateOrderOutputBoundary presenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData createOrderOutputData) {
                fail("Use case succeeded unexpectedly");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Product is already sold.", errorMessage);
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(compositeDataAccess, presenter);
        interactor.execute(inputData);

        // Verify product is still marked as sold
        Product unchangedProduct = productDataAccess.getProductById(1);
        assertTrue(unchangedProduct.isSold());

        // Verify no new order is created
        assertNull(orderDataAccess.getOrder(1));
    }
}
