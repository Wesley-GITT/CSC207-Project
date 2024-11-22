package use_case.user.update_profile;


import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.MyUser;
import entity.MyUserFactory;
import org.junit.Test;
import use_case.user.update_my_profile.*;

import static org.junit.Assert.*;

public class UpdateMyProfileInteractorTest {

    @Test
    public void successUpdateMyProfileTest() {
        UpdateMyProfileInputData inputData = new UpdateMyProfileInputData(
                "wes", "123",
                "2000 Talbot Road West Windsor, ON, Canada N9A 6S4",
                "+1 12345678910", "tom@jerry.sh");

        UpdateMyProfileUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();
        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "123");

        userRepo.save(user);

        UpdateMyProfileOutputBoundary successPresenter = new UpdateMyProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateMyProfileOutputData updateMyProfileOutputData) {
                assertEquals("2000 Talbot Road West Windsor, ON, Canada N9A 6S4", updateMyProfileOutputData.getAddress());
                assertEquals("+1 12345678910", updateMyProfileOutputData.getTelephone());
                assertEquals("tom@jerry.sh", updateMyProfileOutputData.getEmail());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        assertEquals(userRepo.get("wes", "123").getAddress(), null);
        assertEquals(userRepo.get("wes", "123").getTelephone(), null);
        assertEquals(userRepo.get("wes", "123").getEmail(), null);
        UpdateMyProfileInteractor interactor = new UpdateMyProfileInteractor(userRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNotAuthorizedUpdateMyProfileTest() {
        UpdateMyProfileInputData inputData = new UpdateMyProfileInputData(
                "wes", "123",
                "2000 Talbot Road West Windsor, ON, Canada N9A 6S4",
                "+1 12345678910", "tom@jerry.sh");

        UpdateMyProfileUserDataAccessInterface userRepo = new InMemoryItemsUserDataAccessObject();
        MyUserFactory userFactory = new MyUserFactory();
        MyUser user = userFactory.create("wes", "321");

        userRepo.save(user);

        UpdateMyProfileOutputBoundary failurePresenter = new UpdateMyProfileOutputBoundary() {
            @Override
            public void prepareSuccessView(UpdateMyProfileOutputData updateMyProfileOutputData) {
                fail("User case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Authentication failed", errorMessage);
            }
        };

        UpdateMyProfileInteractor interactor = new UpdateMyProfileInteractor(userRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
