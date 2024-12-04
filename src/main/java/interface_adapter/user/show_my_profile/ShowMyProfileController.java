package interface_adapter.user.show_my_profile;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.show_my_profile.ShowMyProfileInputBoundary;
import use_case.user.show_my_profile.ShowMyProfileInputData;

/**
 * Controller for the Signup Use Case.
 */
public class ShowMyProfileController {

    private final ShowMyProfileInputBoundary showMyProfileInteractor;
    private final ViewManagerModel viewManagerModel;

    public ShowMyProfileController(ShowMyProfileInputBoundary showMyProfileInteractor,
                                   ViewManagerModel viewManagerModel) {
        this.showMyProfileInteractor = showMyProfileInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Execute Method for ShowMyProfileController.
     */
    public void execute() {
        final ViewManagerState storage = viewManagerModel.getState();
        final String username = storage.getUsername();
        final String password = storage.getPassword();
        final ShowMyProfileInputData showMyProfileInputData = new ShowMyProfileInputData(username, password);

        showMyProfileInteractor.execute(showMyProfileInputData);
    }
}
