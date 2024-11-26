package use_case.order.view;

public interface ViewOrderOutputBoundary {

    void prepareSuccessView(ViewOrderOutputData outputData);

    void prepareFailView(String errorMessage);
}
