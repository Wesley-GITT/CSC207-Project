package use_case.user.product.remove;

import data_access.user.InMemoryUserDataAccessObject;
import data_access.user.InMemoryProductsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Product;
import org.junit.Test;
import use_case.product.remove.*;
import use_case.user.auth.AuthUserDataAccessInterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class RemoveInteractorTest {

    private final float price = 9.9F;
    @Test
    public void successRemoveProductTest() {
        RemoveProductInputData inputData = new RemoveProductInputData("eric", "123", -1);
        AuthUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();
        RemoveProductUserDataAccessInterface productRepo = new InMemoryProductsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("eric", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        RemoveProductOutputBoundary successPresenter = new RemoveProductOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveProductOutputData RemoveProductOutputData) {
                assertEquals(RemoveProductOutputData.getProductId(), product.getId());
            }

            @Override
            public void prepareFailView(String errorMessage) { fail("Use case failure is unexpected"); }
        };

        RemoveProductInteractor interactor = new RemoveProductInteractor(userRepo, productRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedRemoveProductTest() {
        RemoveProductInputData inputData = new RemoveProductInputData("eric", "123", -1);
        AuthUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();
        RemoveProductUserDataAccessInterface productRepo = new InMemoryProductsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("erica", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        RemoveProductOutputBoundary failurePresenter = new RemoveProductOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveProductOutputData RemoveProductOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        RemoveProductInteractor interactor = new RemoveProductInteractor(userRepo, productRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureProductNotExistRemoveProductTest() {
        RemoveProductInputData inputData = new RemoveProductInputData("eric", "123", -2);
        AuthUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();
        RemoveProductUserDataAccessInterface productRepo = new InMemoryProductsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("eric", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        RemoveProductOutputBoundary failurePresenter = new RemoveProductOutputBoundary() {
            @Override
            public void prepareSuccessView(RemoveProductOutputData RemoveProductOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Product does not exist", errorMessage);
            }
        };

        RemoveProductInteractor interactor = new RemoveProductInteractor(userRepo, productRepo, failurePresenter);
        interactor.execute(inputData);
    }

}
