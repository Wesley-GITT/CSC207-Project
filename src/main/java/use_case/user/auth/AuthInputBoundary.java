package use_case.user.auth;

public interface AuthInputBoundary {

    void execute(AuthInputData authInputData);

    void switchToOriginView();

    void switchToRegView();
}
