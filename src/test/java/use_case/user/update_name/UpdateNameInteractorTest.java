package use_case.user.update_name;

import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class UpdateNameInteractorTest {

    @Test
    public void successUpdateNameTest() {
        UpdateNameInputData inputData = new UpdateNameInputData("wes", "123", "WWWeSSS");
        UpdateNameUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        userRepo.save(user);

        UpdateNameOutputBoundary successPresenter = new UpdateNameOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateNameOutputData outputData) {
                assertEquals("WWWeSSS", outputData.getUsername());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        UpdateNameInteractor interactor = new UpdateNameInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedTest() {
        UpdateNameInputData inputData = new UpdateNameInputData("wes", "123", "WWWeSSS");
        UpdateNameUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");
        userRepo.save(user);

        UpdateNameOutputBoundary failurePresenter = new UpdateNameOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateNameOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        UpdateNameInteractor interactor = new UpdateNameInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserIsTakenTest() {
        UpdateNameInputData inputData = new UpdateNameInputData("wes", "123", "NO!!!");
        UpdateNameUserDataAccessInterface userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user1 = userFactory.create("wes", "123");
        MyUser user2 = userFactory.create("NO!!!", "321");
        userRepo.save(user1);
        userRepo.save(user2);

        UpdateNameOutputBoundary failurePresenter = new UpdateNameOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateNameOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Username `NO!!!` is taken", errorMessage);
            }
        };

        UpdateNameInteractor interactor = new UpdateNameInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}

