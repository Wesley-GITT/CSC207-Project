package use_case.user.auth;


import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthInteractorTest {

    @Test
    public void successUserAuthenticationTest() {
        AuthInputData inputData = new AuthInputData("wes", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.save(user);

        AuthOutputBoundary successPresenter = new AuthOutputBoundary() {
            @Override
            public void prepareSuccessView(AuthOutputData outputData) {
                assertEquals("wes", outputData.getUsername());
                assertEquals("123", outputData.getPassword());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        AuthInteractor interactor = new AuthInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserNotExistTest() {
        AuthInputData inputData = new AuthInputData("wes", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("sam", "123");
        userRepo.save(user);

        AuthOutputBoundary failurePresenter = new AuthOutputBoundary() {
            @Override
            public void prepareSuccessView(AuthOutputData outputData) { fail("Use case success is unexpected"); }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("User `wes` doesn't exist", errorMessage);
            }
        };

        AuthInteractor interactor = new AuthInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureIncorrectUsernamePasswordPairTest() {
        AuthInputData inputData = new AuthInputData("wes", "123");
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");
        userRepo.save(user);

        AuthOutputBoundary failurePresenter = new AuthOutputBoundary() {
            @Override
            public void prepareSuccessView(AuthOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Incorrect username and/or password", errorMessage);
            }
        };

        AuthInteractor interactor = new AuthInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
