package use_case.user.update_cart;

import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class UpdateCartInteractorTest {

    @Test
    public void successUpdateCartTest() {
        Set<Integer> cartItems1 = new HashSet<>();
        cartItems1.add(3);
        cartItems1.add(4);

        UpdateCartInputData inputData = new UpdateCartInputData("wes", "123", cartItems1);
        UpdateCartUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        Set<Integer> cartItems2 = new HashSet<Integer>();
        cartItems2.add(1);
        cartItems2.add(3);
        user.setCartItems(cartItems2);
        userRepo.save(user);

        UpdateCartOutputBoundary successPresenter = new UpdateCartOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateCartOutputData updateCartOutputData) {
                Set<Integer> cartItems = updateCartOutputData.getCartItems();
                assertTrue(cartItems.contains(3));
                assertTrue(cartItems.contains(4));
                assertFalse(cartItems.contains(1));
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        UpdateCartInteractor interactor = new UpdateCartInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserNotAuthorizedUpdateCartTest() {
        UpdateCartInputData inputData = new UpdateCartInputData("wes", "123", new HashSet<>());
        UpdateCartUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");

        userRepo.save(user);

        UpdateCartOutputBoundary failurePresenter = new UpdateCartOutputBoundary() {

            @Override
            public void prepareSuccessView(UpdateCartOutputData updateCartOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        UpdateCartInteractor interactor = new UpdateCartInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
