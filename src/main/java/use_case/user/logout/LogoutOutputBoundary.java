package use_case.user.logout;

public interface LogoutOutputBoundary {

    void prepareSuccessView(LogoutOutputData outputData);

    void prepareFailView(String errorMessage);
}
