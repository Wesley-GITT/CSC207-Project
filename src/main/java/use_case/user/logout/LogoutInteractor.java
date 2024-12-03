package use_case.user.logout;

public class LogoutInteractor implements LogoutInputBoundary {

    private final LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutOutputBoundary logoutPresenter) {
        this.logoutPresenter = logoutPresenter;
    }

    @Override
    public void execute() {
        logoutPresenter.prepareSuccessView();
    }
}
