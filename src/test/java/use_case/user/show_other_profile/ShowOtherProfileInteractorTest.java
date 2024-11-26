package use_case.user.show_other_profile;

import data_access.user.InMemoryUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ShowOtherProfileInteractorTest {

    @Test
    public void successShowOtherProfileTest() {
        ShowOtherProfileInputData inputData = new ShowOtherProfileInputData(0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", null);
        user.setId(0);
        user.setTelephone("+1 12345678910");
        user.setEmail("tom@jerry.sh");

        userRepo.save(user);

        ShowOtherProfileOutputBoundary successPresenter = new ShowOtherProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowOtherProfileOutputData showOtherProfileOutputData) {
                assertEquals("wes", showOtherProfileOutputData.getUsername());
                assertEquals("+1 12345678910", showOtherProfileOutputData.getTelephone());
                assertEquals("tom@jerry.sh", showOtherProfileOutputData.getEmail());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ShowOtherProfileInteractor interactor = new ShowOtherProfileInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureUserNotExistShowOtherProfileTest() {
        ShowOtherProfileInputData inputData = new ShowOtherProfileInputData(0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("sam", null);
        user.setId(2);

        userRepo.save(user);

        ShowOtherProfileOutputBoundary failurePresenter = new ShowOtherProfileOutputBoundary() {

            @Override
            public void prepareSuccessView(ShowOtherProfileOutputData showOtherProfileOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("User with ID `0` doesn't exist", errorMessage);
            }
        };

        ShowOtherProfileInteractor interactor = new ShowOtherProfileInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
