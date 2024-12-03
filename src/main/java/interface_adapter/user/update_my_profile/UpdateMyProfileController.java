package interface_adapter.user.update_my_profile;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.update_my_profile.UpdateMyProfileInputBoundary;
import use_case.user.update_my_profile.UpdateMyProfileInputData;

/**
 * Controller for the Signup Use Case.
 */
public class UpdateMyProfileController {

    private final UpdateMyProfileInputBoundary updateMyProfileInteractor;
    private final ViewManagerModel viewManagerModel;

    public UpdateMyProfileController(UpdateMyProfileInputBoundary updateMyProfileInteractor, ViewManagerModel viewManagerModel) {
        this.updateMyProfileInteractor = updateMyProfileInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    public void execute(String telephone, String email) {
        final ViewManagerState state = viewManagerModel.getState();
        final String username = state.getUsername();
        final String password = state.getPassword();
        final UpdateMyProfileInputData updateMyProfileInputData = new UpdateMyProfileInputData(username, password, telephone, email);

        updateMyProfileInteractor.execute(updateMyProfileInputData);
    }
}
