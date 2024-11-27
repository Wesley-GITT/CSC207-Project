package use_case.order.create;

public interface CreateOrderOutputBoundary {

    void prepareSuccessView(CreateOrderOutputData createOrderOutputData);

    void prepareFailView(String errorMessage);
}
