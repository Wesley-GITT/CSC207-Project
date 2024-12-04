package use_case.user.logout;

public class LogoutInteractor implements LogoutInputBoundary {

    private final LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutOutputBoundary logoutPresenter) {
        this.logoutPresenter = logoutPresenter;
    }

    @Override
    public void execute() {
        // Perform any logout-specific cleanup here
        System.out.println("LogoutInteractor executed: Clearing user session.");

        // Notify the presenter to handle the view update
        logoutPresenter.prepareSuccessView();
    }
}
