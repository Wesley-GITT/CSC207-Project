package use_case.product.create;

import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class CreateInteractorTest {

    private final double price = 9.9;

    @Test
    public void successCreateProductTest() {
        CreateProductInputData inputData = new CreateProductInputData("eric", "123", "1", "good", price);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("eric", "123");
        userRepo.add(user);

        CreateProductOutputBoundary successPresenter = new CreateProductOutputBoundary() {
            @Override
            public void prepareSuccessView(CreateProductOutputData createProductOutputData) {
                Product product = productRepo.get(0);
                assertEquals(user.getId(), product.getSellerId());
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
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        CreateProductDataAccessInterface productRepo = new InMemoryProductDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("erica", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.add(user);
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
