package use_case.user.list_cart_items;

import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ListCartItemsInteractorTest {

    @Test
    public void successShowCartTest() {
        ListCartItemsInputData inputData = new ListCartItemsInputData("wes", "123");
        ListCartItemsUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");

        Set<Integer> cartItems = new HashSet<Integer>();
        cartItems.add(1);
        cartItems.add(2);

        user.setCartItems(cartItems);
        userRepo.save(user);

        ListCartItemsOutputBoundary successPresenter = new ListCartItemsOutputBoundary() {
            @Override
            public void prepareSuccessView(ListCartItemsOutputData showCartOutputData) {
                assertTrue(showCartOutputData.getCartItems().contains(1));
                assertTrue(showCartOutputData.getCartItems().contains(2));
                assertEquals(showCartOutputData.getCartItems().size(), 2);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ListCartItemsInteractor interactor = new ListCartItemsInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedShowCartTest() {
        ListCartItemsInputData inputData = new ListCartItemsInputData("wes", "123");
        ListCartItemsUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");

        Set<Integer> cartItems = new HashSet<Integer>();
        cartItems.add(1);
        cartItems.add(2);
        user.setCartItems(cartItems);
        userRepo.save(user);

        ListCartItemsOutputBoundary failurePresenter = new ListCartItemsOutputBoundary() {
            @Override
            public void prepareSuccessView(ListCartItemsOutputData showCartOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ListCartItemsInteractor interactor = new ListCartItemsInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
