package interface_adapter.Logout;

import use_case.user.logout.LogoutInputBoundary;
import use_case.user.logout.LogoutInputData;

public class LogoutController {
    private LogoutInputBoundary logoutUseCaseInteractor;
    public LogoutController(LogoutInputBoundary logoutUseCaseInteractor) {
        this.logoutUseCaseInteractor = logoutUseCaseInteractor;
    }

    public void execute() {
        final LogoutInputData inputData = new LogoutInputData();
        logoutUseCaseInteractor.execute(inputData);
    }
}
