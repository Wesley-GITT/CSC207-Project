package use_case.order.view;

import entity.Order;
import use_case.order.create.CreateOrderDataAccessInterface;

public class ViewOrderInteractor implements ViewOrderInputBoundary {

    private final CreateOrderDataAccessInterface dataAccess;
    private final ViewOrderOutputBoundary presenter;

    public ViewOrderInteractor(CreateOrderDataAccessInterface dataAccess, ViewOrderOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(ViewOrderInputData inputData) {
        int orderId = inputData.getOrderId();
        Order order = dataAccess.getOrder(orderId);

        if (order == null) {
            presenter.prepareFailView("Order not found.");
            return;
        }

        ViewOrderOutputData outputData = new ViewOrderOutputData(
                order.getBuyerId(),
                order.getSellerId(),
                order.getProductId(),
                order.getOrderTime(),
                order.getOrderStatus(),
                order.getDeliveryAddress()
        );

        presenter.prepareSuccessView(outputData);
    }
}
