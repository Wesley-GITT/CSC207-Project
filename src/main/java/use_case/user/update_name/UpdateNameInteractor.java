package use_case.user.update_name;

import entity.MyUser;

public class UpdateNameInteractor implements UpdateNameInputBoundary {

    private UpdateNameUserDataAccessInterface userDataAccessObject;
    private UpdateNameOutputBoundary updateNamePresenter;

    public UpdateNameInteractor(UpdateNameUserDataAccessInterface userDataAccessObject, UpdateNameOutputBoundary updateNamePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.updateNamePresenter = updateNamePresenter;
    }

    @Override
    public void execute(UpdateNameInputData updateNameInputData) {

        final String username = updateNameInputData.getUsername();
        final String password = updateNameInputData.getPassword();
        final String newUsername = updateNameInputData.getNewUsername();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            updateNamePresenter.prepareFailView("Authentication failed");
        } else if (userDataAccessObject.doesUserExist(newUsername)) {
            updateNamePresenter.prepareFailView("Username `" + newUsername + "` is taken");
        } else {
            final String address = updateNameInputData.getNewUsername();
            final MyUser user = userDataAccessObject.get(username, password);

            user.setUsername(address);
            userDataAccessObject.save(user);

            UpdateNameOutputData outputData = new UpdateNameOutputData(address);
            updateNamePresenter.prepareSuccessView(outputData);
        }
    }
}
