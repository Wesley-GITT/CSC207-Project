package use_case.order.cancel_order;

public interface CancelOrderOutputBoundary {

    void prepareSuccessView(CancelOrderOutputData outputData);

    void prepareFailView(String errorMessage);
}
