package interface_adapter.user.update_pwd;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.update_pwd.UpdatePasswordInputBoundary;
import use_case.user.update_pwd.UpdatePasswordInputData;

/**
 * Controller for the Signup Use Case.
 */
public class UpdatePasswordController {

    private final UpdatePasswordInputBoundary updatePasswordInteractor;
    private final ViewManagerModel viewManagerModel;

    public UpdatePasswordController(UpdatePasswordInputBoundary updatePasswordInteractor,
                                    ViewManagerModel viewManagerModel) {
        this.updatePasswordInteractor = updatePasswordInteractor;
        this.viewManagerModel = viewManagerModel;
    }

    /**
     * Execute method for UpdatePasswordController.
     * @param oldPassword oldPassword
     * @param newPassword1 newPassword1
     * @param newPassword2 newPassword2
     */
    public void execute(String oldPassword, String newPassword1, String newPassword2) {
        final ViewManagerState state = viewManagerModel.getState();
        final String username = state.getUsername();
        final UpdatePasswordInputData updatePasswordInputData = new UpdatePasswordInputData(username, oldPassword, newPassword1, newPassword2);

        updatePasswordInteractor.execute(updatePasswordInputData);
    }
}
