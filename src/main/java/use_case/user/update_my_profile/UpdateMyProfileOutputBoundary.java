package use_case.user.update_my_profile;

public interface UpdateMyProfileOutputBoundary {

    void prepareSuccessView(UpdateMyProfileOutputData updateMyProfileOutputData);

    void prepareFailView(String errorMessage);
}
