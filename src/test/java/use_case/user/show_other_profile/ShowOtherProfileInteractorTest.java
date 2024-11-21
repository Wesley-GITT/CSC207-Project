package use_case.user.show_other_profile;

import data_access.user.InMemoryUserDataAccessObject;
import entity.ContactInfo;
import entity.OtherUser;
import entity.OtherUserFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ShowOtherProfileInteractorTest {

    @Test
    public void successShowOtherProfileTest() {
        ShowOtherProfileInputData inputData = new ShowOtherProfileInputData(0);
        InMemoryUserDataAccessObject userRepo = new InMemoryUserDataAccessObject();

        OtherUserFactory userFactory = new OtherUserFactory();
        ContactInfo contactInfo = new ContactInfo("+1 12345678910", "tom@jerry.sh");
        OtherUser user = userFactory.create(0, "wes", contactInfo);

        userRepo.saveOther(user);

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

        OtherUserFactory userFactory = new OtherUserFactory();
        OtherUser user = userFactory.create(2, "sam", new ContactInfo(null, null));

        userRepo.saveOther(user);

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
