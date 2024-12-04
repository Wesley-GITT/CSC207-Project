package use_case.user.show_my_profile;

public interface ShowMyProfileOutputBoundary {

    /**
     * PrepareSuccessView for ShowMyProfileOutputBoundary.
     * @param showMyProfileOutputData showMyProfileOutputData.
     */
    void prepareSuccessView(ShowMyProfileOutputData showMyProfileOutputData);

    /**
     * PrepareFailView for ShowMyProfileOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);
}
