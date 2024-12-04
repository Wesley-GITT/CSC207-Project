package use_case.user.update_name;

public interface UpdateNameOutputBoundary {

    /**
     * PrepareSuccessView for UpdateNameOutputBoundary.
     * @param updateNameOutputData updateNameOutputData
     */
    void prepareSuccessView(UpdateNameOutputData updateNameOutputData);

    /**
     * PrepareFailView for UpdateNameOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);
}
