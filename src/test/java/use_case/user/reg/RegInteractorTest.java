package use_case.user.reg;


import data_access.user.InMemoryUserDataAccessObjectMy;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegInteractorTest {

    @Test
    public void successUserRegistrationTest() {
        RegInputData inputData = new RegInputData("wes", "123", "123");
        RegUserDataAccessInterface userRepo = new InMemoryUserDataAccessObjectMy();

        RegOutputBoundary successPresenter = new RegOutputBoundary() {
            @Override
            public void prepareSuccessView(RegOutputData outputData) {
                assertEquals("wes", outputData.getUsername());
                assertEquals("123", outputData.getPassword());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }

            @Override
            public void switchToOriginalView() {
                // this might be expected
            }

            @Override
            public void switchToMyUserView() {
                // this might be expected
            }
        };

        RegInteractor interactor = new RegInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserAlreadyExistTest() {
        RegInputData inputData = new RegInputData("wes", "123", "123");
        RegUserDataAccessInterface userRepo = new InMemoryUserDataAccessObjectMy();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.add(user);

        RegOutputBoundary failurePresenter = new RegOutputBoundary() {
            @Override
            public void prepareSuccessView(RegOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("User `wes` already exists", errorMessage);
            }

            @Override
            public void switchToOriginalView() {
                // this might be expected
            }

            @Override
            public void switchToMyUserView() {
                // this might be expected
            }
        };

        RegInteractor interactor = new RegInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureIncorrectUsernamePasswordPairTest() {
        RegInputData inputData = new RegInputData("wes", "123", "321");
        RegUserDataAccessInterface userRepo = new InMemoryUserDataAccessObjectMy();

        RegOutputBoundary failurePresenter = new RegOutputBoundary() {
            @Override
            public void prepareSuccessView(RegOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Passwords don't match", errorMessage);
            }

            @Override
            public void switchToOriginalView() {
                // this might be expected
            }

            @Override
            public void switchToMyUserView() {
                // this might be expected
            }
        };

        RegInteractor interactor = new RegInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
