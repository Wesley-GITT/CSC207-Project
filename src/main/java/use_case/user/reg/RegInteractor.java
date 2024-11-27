package use_case.user.reg;

import entity.MyUser;
import entity.MyUserFactory;

public class RegInteractor implements RegInputBoundary {

    private final RegUserDataAccessInterface userDataAccessObject;
    private final RegOutputBoundary regPresenter;
    private final MyUserFactory myUserFactory;

    public RegInteractor(RegUserDataAccessInterface userDataAccessObject,
                         RegOutputBoundary regOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.regPresenter = regOutputBoundary;
        this.myUserFactory = new MyUserFactory();
    }


    @Override
    public void execute(RegInputData regInputData) {
        final String username = regInputData.getUsername();
        final String password = regInputData.getPassword();

        if (!regInputData.getPassword().equals(regInputData.getPasswordRepeated())) {
            regPresenter.prepareFailView("Passwords don't match");
        } else if (userDataAccessObject.existByUsername(username)) {
            regPresenter.prepareFailView("User `" + username + "` already exists");
        } else {
            final MyUser user = myUserFactory.create(username, password);
            userDataAccessObject.add(user);

            final RegOutputData regOutputData = new RegOutputData(user.getId(), username, password);
            regPresenter.prepareSuccessView(regOutputData);
        }
    }

    @Override
    public void switchToOriginalView() {
        regPresenter.switchToOriginalView();
    }

    @Override
    public void switchToMyUserView() {
        regPresenter.switchToMyUserView();
    }
}
