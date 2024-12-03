package interface_adapter.user.update_name;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.update_name.UpdateNameInputBoundary;
import use_case.user.update_name.UpdateNameInputData;

/**
 * Controller for the Signup Use Case.
 */
public class UpdateNameController {

    private final UpdateNameInputBoundary updateNameInteractor;
    private final ViewManagerModel viewManagerModel;

    public UpdateNameController(UpdateNameInputBoundary updateNameInteractor, ViewManagerModel viewManagerModel) {
        this.updateNameInteractor = updateNameInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    public void execute(String newUsername) {
        final ViewManagerState state = viewManagerModel.getState();
        final String username = state.getUsername();
        final String password = state.getPassword();
        final UpdateNameInputData updateNameInputData = new UpdateNameInputData(username, password, newUsername);

        updateNameInteractor.execute(updateNameInputData);
    }
}
