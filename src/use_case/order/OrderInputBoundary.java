package use_case.order;

/*
This interface defines the methods for managing orders.
 */
public interface OrderInputBoundary {
    OrderOutputData placeOrder(OrderInputData inputData);
    OrderOutputData cancelOrder(Integer orderId);
    OrderOutputData completeOrder(Integer orderId);
}
