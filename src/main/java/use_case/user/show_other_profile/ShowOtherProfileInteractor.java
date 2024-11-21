package use_case.user.show_other_profile;

import entity.OtherUser;

public class ShowOtherProfileInteractor implements ShowOtherProfileInputBoundary {

    private ShowOtherProfileUserDataAccessInterface userDataAccessObject;
    private ShowOtherProfileOutputBoundary showMyProfilePresenter;

    public ShowOtherProfileInteractor(ShowOtherProfileUserDataAccessInterface userDataAccessObject, ShowOtherProfileOutputBoundary showMyProfilePresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.showMyProfilePresenter = showMyProfilePresenter;
    }

    @Override
    public void execute(ShowOtherProfileInputData showOtherProfileInputData) {

        final int id = showOtherProfileInputData.getId();

        if (!userDataAccessObject.doesUserExistById(id)) {
            showMyProfilePresenter.prepareFailView("User with ID `" + id +"` doesn't exist");
        } else {
            final OtherUser user = userDataAccessObject.getOther(id);
            final String username = user.getUsername();
            final String telephone = user.getTelephone();
            final String email = user.getEmail();

            ShowOtherProfileOutputData outputData = new ShowOtherProfileOutputData(username, telephone, email);
            showMyProfilePresenter.prepareSuccessView(outputData);
        }
    }
}
