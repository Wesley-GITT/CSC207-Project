package use_case.user.product.list_my_products;

import data_access.user.InMemoryItemsUserDataAccessObject;
import data_access.product.InMemoryProductsDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Product;
import org.junit.Test;
import use_case.product.list_my_products.*;
import use_case.user.auth.AuthUserDataAccessInterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ListMyProductInteractorTest {

    private final float price = 9.9F;
    @Test
    public void successListProductsTest() {
        ListProductInputData inputData = new ListProductInputData("eric", "123");
        AuthUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();
        ListProductDataAccessInterface productRepo = new InMemoryProductsDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("eric", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        ListProductOutputBoundary successPresenter = new ListProductOutputBoundary() {
            @Override
            public void prepareSuccessView(ListProductOutputData listProductOutputData) {
                assertEquals(listProductOutputData.getProducts().size(), 1);
            }

            @Override
            public void prepareFailView(String errorMessage) { fail("Use case failure is unexpected"); }
        };

        ListProductInteractor interactor = new ListProductInteractor(userRepo, productRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedListProductTest() {
        ListProductInputData inputData = new ListProductInputData("eric", "123");
        AuthUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();
        ListProductDataAccessInterface productRepo = new InMemoryProductsDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("erica", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        ListProductOutputBoundary failurePresenter = new ListProductOutputBoundary() {
            @Override
            public void prepareSuccessView(ListProductOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ListProductInteractor interactor = new ListProductInteractor(userRepo, productRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
