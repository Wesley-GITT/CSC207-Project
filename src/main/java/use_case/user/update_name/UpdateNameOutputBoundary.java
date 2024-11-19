package use_case.user.update_name;

public interface UpdateNameOutputBoundary {

    void prepareSuccessView(UpdateNameOutputData updateNameOutputData);

    void prepareFailView(String errorMessage);
}
