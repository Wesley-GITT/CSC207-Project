package use_case.order;

/*
This interface defines the output response handling for orders.
 */
public interface OrderOutputBoundary {
    void presentOrderResult(OrderOutputData outputData);
}