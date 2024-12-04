package interface_adapter.user.logout;

import use_case.user.logout.LogoutInputBoundary;

/**
 * The controller for the Login Use Case.
 */
public class LogoutController {

    private final LogoutInputBoundary logoutInteractor;

    public LogoutController(LogoutInputBoundary logoutInteractor) {
        this.logoutInteractor = logoutInteractor;
    }

    /**
     * Execute method for LogoutController.
     */
    public void execute() {
        logoutInteractor.execute();
    }
}
