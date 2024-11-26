package use_case.order.cancel;

public interface CancelOrderOutputBoundary {

    void prepareSuccessView(CancelOrderOutputData outputData);

    void prepareFailView(String errorMessage);
}
