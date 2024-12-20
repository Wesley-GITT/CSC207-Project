package use_case.user.show_my_profile;

import entity.MyUser;

public class ShowMyProfileInteractor implements ShowMyProfileInputBoundary {

    private ShowMyProfileUserDataAccessInterface userDataAccessObject;
    private ShowMyProfileOutputBoundary showMyProfilePresenter;

    public ShowMyProfileInteractor(ShowMyProfileUserDataAccessInterface userDataAccessObject,
                                   ShowMyProfileOutputBoundary showMyProfilePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.showMyProfilePresenter = showMyProfilePresenter;
    }

    @Override
    public void execute(ShowMyProfileInputData showMyProfileInputData) {

        final String username = showMyProfileInputData.getUsername();
        final String password = showMyProfileInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            showMyProfilePresenter.prepareFailView("Authentication failed");
        }
        else {
            final MyUser user = userDataAccessObject.get(username, password);
            final String telephone = user.getTelephone();
            final String email = user.getEmail();

            final ShowMyProfileOutputData outputData = new ShowMyProfileOutputData(username, telephone, email);
            showMyProfilePresenter.prepareSuccessView(outputData);
        }
    }
}
