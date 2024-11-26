package use_case.user.show_other_profile;

public interface ShowOtherProfileOutputBoundary {

    void prepareSuccessView(ShowOtherProfileOutputData showOtherProfileOutputData);

    void prepareFailView(String errorMessage);
}
