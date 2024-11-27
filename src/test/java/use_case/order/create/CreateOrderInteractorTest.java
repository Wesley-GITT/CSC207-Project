package use_case.order.create;

import data_access.order.InMemoryOrderDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Product;
import entity.ProductFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateOrderInteractorTest {

    @Test
    public void successCreateOrderTest() {

        CreateOrderInputData inputData = new CreateOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ProductFactory productFactory = new ProductFactory();
        productRepo.save(productFactory.create(0, "abcd12379", 1, "", 0));

        CreateOrderOutputBoundary successPresenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData outputData) {
                assertEquals(outputData.getOrderId(), 0);
                assertEquals(outputData.getProductId(), 0);
                assertTrue(productRepo.get(outputData.getProductId()).getIsSold());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(userRepo, productRepo, orderRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureProductNotExistTest() {
        CreateOrderInputData inputData = new CreateOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        CreateOrderOutputBoundary failurePresenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Product with ID `0` doesn't exist", errorMessage);
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(userRepo, productRepo, orderRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureIncorrectUsernamePasswordPairTest() {
        CreateOrderInputData inputData = new CreateOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");
        userRepo.add(user);

        ProductFactory productFactory = new ProductFactory();
        productRepo.save(productFactory.create(0, "abcd12379", user.getId(), "", 0));

        CreateOrderOutputBoundary failurePresenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(userRepo, productRepo, orderRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserBuyingOwnProductTest() {
        CreateOrderInputData inputData = new CreateOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        ProductFactory productFactory = new ProductFactory();
        productRepo.save(productFactory.create(0, "abcd12379", user.getId(), "", 0));

        CreateOrderOutputBoundary failurePresenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("You can't by your own product", errorMessage);
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(userRepo, productRepo, orderRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureProductIsAlreadySoldTest() {
        CreateOrderInputData inputData = new CreateOrderInputData("wes", "123", 0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        InMemoryOrderDataAccessObject orderRepo = new InMemoryOrderDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        userRepo.add(userFactory.create("wes", "123"));
        userRepo.add(userFactory.create("sam", "123"));

        ProductFactory productFactory = new ProductFactory();
        Product product = productFactory.create(0, "abcd12379", 1, "", 0);
        product.setIsSold(true);
        productRepo.save(product);

        CreateOrderOutputBoundary failurePresenter = new CreateOrderOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateOrderOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Product with ID `0` is already sold", errorMessage);
            }
        };

        CreateOrderInteractor interactor = new CreateOrderInteractor(userRepo, productRepo, orderRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
