package use_case.order.list_my_orders;

public interface ListMyOrdersOutputBoundary {

    void prepareSuccessView(ListMyOrdersOutputData outputData);

    void prepareFailView(String errorMessage);
}
