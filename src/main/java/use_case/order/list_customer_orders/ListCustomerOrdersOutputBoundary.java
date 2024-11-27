package use_case.order.list_customer_orders;

public interface ListCustomerOrdersOutputBoundary {

    void prepareSuccessView(ListCustomerOrdersOutputData outputData);

    void prepareFailView(String errorMessage);
}
