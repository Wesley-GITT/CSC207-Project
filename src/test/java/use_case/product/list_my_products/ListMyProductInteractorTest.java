package use_case.product.list_my_products;

import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import entity.Product;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ListMyProductInteractorTest {

    private final double price = 9.9F;
    @Test
    public void successListProductsTest() {
        ListMyProductInputData inputData = new ListMyProductInputData("eric", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("eric", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        ListMyProductOutputBoundary successPresenter = new ListMyProductOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyProductOutputData listProductOutputData) {
                assertEquals(listProductOutputData.getProductIds().size(), 1);
            }

            @Override
            public void prepareFailView(String errorMessage) { fail("Use case failure is unexpected"); }
        };

        ListMyProductInteractor interactor = new ListMyProductInteractor(userRepo, productRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedListProductTest() {
        ListMyProductInputData inputData = new ListMyProductInputData("eric", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();
        InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("erica", "123");

        Product product = new Product(-1, "1", user.getId(), "good", price, false);

        userRepo.save(user);
        productRepo.add(product);

        ListMyProductOutputBoundary failurePresenter = new ListMyProductOutputBoundary() {
            @Override
            public void prepareSuccessView(ListMyProductOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ListMyProductInteractor interactor = new ListMyProductInteractor(userRepo, productRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
