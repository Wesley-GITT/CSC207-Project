package use_case.user.show_wishlist;

import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class ShowWishlistInteractorTest {

    @Test
    public void successShowWishlistTest() {
        ShowWishlistInputData inputData = new ShowWishlistInputData("wes", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");

        Set<Integer> wishlist = new HashSet<Integer>();
        wishlist.add(1);
        wishlist.add(2);

        user.setWishlist(wishlist);
        userRepo.save(user);

        ShowWishlistOutputBoundary successPresenter = new ShowWishlistOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowWishlistOutputData showCartOutputData) {
                final Set<Integer> wishlist = showCartOutputData.getWishlist();
                assertTrue(wishlist.contains(1));
                assertTrue(wishlist.contains(2));
                assertEquals(wishlist.size(), 2);
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ShowWishlistInteractor interactor = new ShowWishlistInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedShowCartTest() {
        ShowWishlistInputData inputData = new ShowWishlistInputData("wes", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");

        Set<Integer> cartItems = new HashSet<Integer>();
        cartItems.add(1);
        cartItems.add(2);
        user.setWishlist(cartItems);
        userRepo.save(user);

        ShowWishlistOutputBoundary failurePresenter = new ShowWishlistOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowWishlistOutputData showCartOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ShowWishlistInteractor interactor = new ShowWishlistInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}