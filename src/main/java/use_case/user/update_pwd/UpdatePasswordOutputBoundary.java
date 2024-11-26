package use_case.user.update_pwd;

public interface UpdatePasswordOutputBoundary {

    void prepareSuccessView(UpdatePasswordOutputData updatePasswordOutputData);

    void prepareFailView(String errorMessage);
}
