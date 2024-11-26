package use_case.user.product.create;

import data_access.user.InMemoryItemsUserDataAccessObject;
import data_access.user.InMemoryProductsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Product;
import org.junit.Test;
import use_case.product.create.*;
import use_case.user.auth.AuthUserDataAccessInterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CreateInteractorTest {

    private final float price = 9.9F;
    @Test
    public void successCreateProductTest() {
        CreateProductInputData inputData = new CreateProductInputData("eric", "123", "1", "good", price);
        AuthUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();
        CreateProductUserDataAccessInterface productRepo = new InMemoryProductsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("eric", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        CreateProductOutputBoundary successPresenter = new CreateProductOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateProductOutputData createProductOutputData) {
                assertEquals(createProductOutputData.getProductId(), product.getId());
            }

            @Override
            public void prepareFailView(String errorMessage) { fail("Use case failure is unexpected"); }
        };

        CreateProductInteractor interactor = new CreateProductInteractor(userRepo, productRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedCreateProductTest() {
        CreateProductInputData inputData = new CreateProductInputData("eric", "123", "1", "good", price);
        AuthUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();
        CreateProductUserDataAccessInterface productRepo = new InMemoryProductsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("erica", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        CreateProductOutputBoundary failurePresenter = new CreateProductOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateProductOutputData createProductOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        CreateProductInteractor interactor = new CreateProductInteractor(userRepo, productRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
