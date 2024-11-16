package use_case.change_password.interface_adapter;

import use_case.change_password.ChangePasswordInputBoundary;
import use_case.change_password.ChangePasswordInputData;

/**
 * Controller for the Change Password Use Case.
 */
public class ChangePasswordController {
    private final ChangePasswordInputBoundary userChangePasswordUseCaseInteractor;

    public ChangePasswordController(ChangePasswordInputBoundary userChangePasswordUseCaseInteractor) {
        this.userChangePasswordUseCaseInteractor = userChangePasswordUseCaseInteractor;
    }

    /**
     * Executes the Change Password Use Case.
     * @param password the new password
     * @param username the user whose password to change
     */
    public void execute(String username, String password, String name, String address, String contactInfo) {
        final ChangePasswordInputData changePasswordInputData = new ChangePasswordInputData(username, password, name, address, contactInfo);

        userChangePasswordUseCaseInteractor.execute(changePasswordInputData);
    }
}
