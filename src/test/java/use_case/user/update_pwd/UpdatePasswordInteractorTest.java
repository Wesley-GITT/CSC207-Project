package use_case.user.update_pwd;


import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdatePasswordInteractorTest {

    @Test
    public void successUpdatePasswordTest() {
        UpdatePasswordInputData inputData = new UpdatePasswordInputData("wes", "123", "321", "321");
        UpdatePasswordUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.save(user);

        UpdatePasswordOutputBoundary successPresenter = new UpdatePasswordOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdatePasswordOutputData outputData) {
                assertEquals("321", outputData.getPassword());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }

        };

        UpdatePasswordInteractor interactor = new UpdatePasswordInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedTest() {
        UpdatePasswordInputData inputData = new UpdatePasswordInputData("wes", "321", "123", "123");
        UpdatePasswordUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.save(user);

        UpdatePasswordOutputBoundary failurePresenter = new UpdatePasswordOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdatePasswordOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        UpdatePasswordInteractor interactor = new UpdatePasswordInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failurePasswordPairMismatchedTest() {
        UpdatePasswordInputData inputData = new UpdatePasswordInputData("wes", "123", "123", "321");
        UpdatePasswordUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.save(user);

        UpdatePasswordOutputBoundary failurePresenter = new UpdatePasswordOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdatePasswordOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Passwords don't match", errorMessage);
            }
        };

        UpdatePasswordInteractor interactor = new UpdatePasswordInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
