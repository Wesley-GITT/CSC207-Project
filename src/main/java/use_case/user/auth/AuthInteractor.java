package use_case.user.auth;

import entity.MyUser;

public class AuthInteractor implements AuthInputBoundary {

    private final AuthUserDataAccessInterface userDataAccessObject;
    private final AuthOutputBoundary authPresenter;

    public AuthInteractor(AuthUserDataAccessInterface userDataAccessObject,
                          AuthOutputBoundary authOutputBoundary) {
        this.userDataAccessObject = userDataAccessObject;
        this.authPresenter = authOutputBoundary;
    }


    @Override
    public void execute(AuthInputData authInputData) {
        final String username = authInputData.getUsername();
        final String password = authInputData.getPassword();

        if (!userDataAccessObject.exist(username)){
            authPresenter.prepareFailView("User `" + username + "` doesn't exist");
        } else if (!userDataAccessObject.isAuthenticated(username, password)) {
            authPresenter.prepareFailView("Incorrect username and/or password");
        } else {
            final MyUser user = userDataAccessObject.get(username, password);
            final AuthOutputData authOutputData = new AuthOutputData(user.getId(), username, password);
            authPresenter.prepareSuccessView(authOutputData);
        }
    }
}
