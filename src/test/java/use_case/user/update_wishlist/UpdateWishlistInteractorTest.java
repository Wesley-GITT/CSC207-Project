package use_case.user.update_wishlist;

import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class UpdateWishlistInteractorTest {

    @Test
    public void successUpdateCartTest() {
        Set<Integer> cartItems1 = new HashSet<>();
        cartItems1.add(3);
        cartItems1.add(4);

        UpdateWishlistInputData inputData = new UpdateWishlistInputData("wes", "123", cartItems1);
        UpdateWishlistDataAccessInterface userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        Set<Integer> wishlist = new HashSet<Integer>();
        wishlist.add(1);
        wishlist.add(3);
        user.setWishlist(wishlist);
        userRepo.save(user);

        UpdateWishlistOutputBoundary successPresenter = new UpdateWishlistOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateWishlistOutputData updateWishlistOutputData) {
                Set<Integer> wishlist = updateWishlistOutputData.getWishlist();
                assertTrue(wishlist.contains(3));
                assertTrue(wishlist.contains(4));
                assertFalse(wishlist.contains(1));
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        UpdateWishlistInteractor interactor = new UpdateWishlistInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserNotAuthorizedUpdateCartTest() {
        UpdateWishlistInputData inputData = new UpdateWishlistInputData("wes", "123", new HashSet<>());
        UpdateWishlistDataAccessInterface userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");

        userRepo.save(user);

        UpdateWishlistOutputBoundary failurePresenter = new UpdateWishlistOutputBoundary() {

            @Override
            public void prepareSuccessView(UpdateWishlistOutputData updateWishlistOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        UpdateWishlistInteractor interactor = new UpdateWishlistInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}