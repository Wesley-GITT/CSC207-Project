package use_case.user.update_my_profile;

import entity.MyUser;

public class UpdateMyProfileInteractor implements UpdateMyProfileInputBoundary {

    private UpdateMyProfileUserDataAccessInterface userDataAccessObject;
    private UpdateMyProfileOutputBoundary updateMyProfilePresenter;

    public UpdateMyProfileInteractor(UpdateMyProfileUserDataAccessInterface userDataAccessObject, UpdateMyProfileOutputBoundary updateMyProfilePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.updateMyProfilePresenter = updateMyProfilePresenter;
    }

    @Override
    public void execute(UpdateMyProfileInputData updateMyProfileInputData) {

        final String username = updateMyProfileInputData.getUsername();
        final String password = updateMyProfileInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            updateMyProfilePresenter.prepareFailView("Authentication failed");
        } else {
            final String address = updateMyProfileInputData.getAddress();
            final String telephone = updateMyProfileInputData.getTelephone();
            final String email = updateMyProfileInputData.getEmail();

            final MyUser user = userDataAccessObject.get(username, password);
            user.setAddress(address);
            user.setTelephone(telephone);
            user.setEmail(email);
            userDataAccessObject.save(user);

            UpdateMyProfileOutputData outputData = new UpdateMyProfileOutputData(address, telephone, email);
            updateMyProfilePresenter.prepareSuccessView(outputData);
        }
    }
}