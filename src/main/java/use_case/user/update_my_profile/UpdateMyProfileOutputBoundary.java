package use_case.user.update_my_profile;

public interface UpdateMyProfileOutputBoundary {

    /**
     * PrepareSuccessView for UpdateMyProfileOutputBoundary.
     * @param updateMyProfileOutputData updateMyProfileOutputData
     */
    void prepareSuccessView(UpdateMyProfileOutputData updateMyProfileOutputData);

    /**
     * PrepareFailView for UpdateMyProfileOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);
}
