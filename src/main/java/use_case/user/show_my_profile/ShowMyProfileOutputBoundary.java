package use_case.user.show_my_profile;

public interface ShowMyProfileOutputBoundary {

    void prepareSuccessView(ShowMyProfileOutputData showMyProfileOutputData);

    void prepareFailView(String errorMessage);
}
