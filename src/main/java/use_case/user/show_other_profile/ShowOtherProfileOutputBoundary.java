package use_case.user.show_other_profile;

public interface ShowOtherProfileOutputBoundary {

    /**
     * PrepareSuccessView for ShowOtherProfileOutputBoundary.
     * @param showOtherProfileOutputData showOtherProfileOutputData
     */
    void prepareSuccessView(ShowOtherProfileOutputData showOtherProfileOutputData);

    /**
     * PrepareFailView for ShowOtherProfileOutputBoundary.
     * @param errorMessage errorMessage
     */
    void prepareFailView(String errorMessage);
}
