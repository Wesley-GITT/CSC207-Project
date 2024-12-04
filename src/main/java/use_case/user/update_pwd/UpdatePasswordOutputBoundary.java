package use_case.user.update_pwd;

public interface UpdatePasswordOutputBoundary {

    /**
     * PrepareSuccessView for UpdatePasswordOutputBoundary.
     * @param updatePasswordOutputData updatePasswordOutputData
     */
    void prepareSuccessView(UpdatePasswordOutputData updatePasswordOutputData);

    /**
     * PrepareFailView for UpdatePasswordOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);
}
