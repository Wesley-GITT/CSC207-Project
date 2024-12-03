package use_case.user.reg;

public interface RegInputBoundary {

    void execute(RegInputData regInputData);

    void switchToSignIn();
}
