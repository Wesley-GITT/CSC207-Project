package use_case.user.update_pwd;

import entity.MyUser;

public class UpdatePasswordInteractor implements UpdatePasswordInputBoundary {

    private UpdatePasswordUserDataAccessInterface userDataAccessObject;
    private UpdatePasswordOutputBoundary updatePasswordPresenter;

    public UpdatePasswordInteractor(UpdatePasswordUserDataAccessInterface userDataAccessObject, UpdatePasswordOutputBoundary updatePasswordPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.updatePasswordPresenter = updatePasswordPresenter;
    }

    @Override
    public void execute(UpdatePasswordInputData updatePasswordInputData) {

        final String username = updatePasswordInputData.getUsername();
        final String originalPassword = updatePasswordInputData.getOrginalPassword();
        final String newPassword = updatePasswordInputData.getNewPassword();
        final String newPasswordRepeated = updatePasswordInputData.getNewPasswordRepeated();

        if (!userDataAccessObject.isAuthenticated(username, originalPassword)) {
            updatePasswordPresenter.prepareFailView("Authentication failed");
        } else if (!newPassword.equals(newPasswordRepeated)) {
            updatePasswordPresenter.prepareFailView("Passwords don't match");
        } else {
            final MyUser user = userDataAccessObject.get(username, originalPassword);
            user.setPassword(newPassword);

            userDataAccessObject.save(user);
            final UpdatePasswordOutputData outputData = new UpdatePasswordOutputData(newPassword);
            updatePasswordPresenter.prepareSuccessView(outputData);
        }
    }
}
