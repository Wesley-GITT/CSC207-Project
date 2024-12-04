package interface_adapter.user.show_other_profile;

import use_case.user.show_other_profile.ShowOtherProfileInputBoundary;
import use_case.user.show_other_profile.ShowOtherProfileInputData;

/**
 * Controller for the Signup Use Case.
 */
public class ShowOtherProfileController {

    private final ShowOtherProfileInputBoundary showOtherProfileInteractor;

    public ShowOtherProfileController(ShowOtherProfileInputBoundary showOtherProfileInteractor) {
        this.showOtherProfileInteractor = showOtherProfileInteractor;
    }

    /**
     * Execute method for ShowOtherProfileController.
     * @param userId userId.
     */
    public void execute(int userId) {
        final ShowOtherProfileInputData showOtherProfileInputData = new ShowOtherProfileInputData(userId);

        showOtherProfileInteractor.execute(showOtherProfileInputData);
    }
}
