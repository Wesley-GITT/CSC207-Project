package use_case.user.show_cart;

import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ShowCartInteractorTest {

    @Test
    public void successShowCartTest() {
        ShowCartInputData inputData = new ShowCartInputData("wes", "123");
        ShowCartUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");

        Set<Integer> cartItems = new HashSet<Integer>();
        cartItems.add(1);
        cartItems.add(2);

        user.setCartItems(cartItems);
        userRepo.save(user);

        ShowCartOutputBoundary successPresenter = new ShowCartOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowCartOutputData showCartOutputData) {
                assertTrue(showCartOutputData.getCartItems().contains(1));
                assertTrue(showCartOutputData.getCartItems().contains(2));
                assertEquals(showCartOutputData.getCartItems().size(), 2);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ShowCartInteractor interactor = new ShowCartInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedShowCartTest() {
        ShowCartInputData inputData = new ShowCartInputData("wes", "123");
        ShowCartUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");

        Set<Integer> cartItems = new HashSet<Integer>();
        cartItems.add(1);
        cartItems.add(2);
        user.setCartItems(cartItems);
        userRepo.save(user);

        ShowCartOutputBoundary failurePresenter = new ShowCartOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowCartOutputData showCartOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ShowCartInteractor interactor = new ShowCartInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
