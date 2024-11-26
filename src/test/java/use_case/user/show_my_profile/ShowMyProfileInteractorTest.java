package use_case.user.show_my_profile;

import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ShowMyProfileInteractorTest {

    @Test
    public void successShowMyProfileTest() {
        ShowMyProfileInputData inputData = new ShowMyProfileInputData("wes", "123");
        ShowMyProfileUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");
        user.setAddress("2000 Talbot Road West Windsor, ON, Canada N9A 6S4");
        user.setTelephone("+1 12345678910");
        user.setEmail("tom@jerry.sh");

        userRepo.save(user);

        ShowMyProfileOutputBoundary successPresenter = new ShowMyProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(ShowMyProfileOutputData showMyProfileOutputData) {
                assertEquals("2000 Talbot Road West Windsor, ON, Canada N9A 6S4", showMyProfileOutputData.getAddress());
                assertEquals("+1 12345678910", showMyProfileOutputData.getTelephone());
                assertEquals("tom@jerry.sh", showMyProfileOutputData.getEmail());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ShowMyProfileInteractor interactor = new ShowMyProfileInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedShowMyProfileTest() {
        ShowMyProfileInputData inputData = new ShowMyProfileInputData("wes", "123");
        ShowMyProfileUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();

        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");

        userRepo.save(user);

        ShowMyProfileOutputBoundary failurePresenter = new ShowMyProfileOutputBoundary() {

            @Override
            public void prepareSuccessView(ShowMyProfileOutputData showMyProfileOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        ShowMyProfileInteractor interactor = new ShowMyProfileInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
