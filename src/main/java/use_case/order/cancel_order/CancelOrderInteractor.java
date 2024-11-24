package use_case.order.cancel_order;

import data_access.CompositeDataAccessObject;
import entity.MyUser;
import entity.Order;

public class CancelOrderInteractor {
    private final CompositeDataAccessObject dataAccess;
    private final CancelOrderOutputBoundary presenter;

    public CancelOrderInteractor(CompositeDataAccessObject dataAccess, CancelOrderOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    public void execute(CancelOrderInputData inputData) {
        String username = inputData.getUsername();
        String password = inputData.getPassword();
        int orderId = inputData.getOrderId();

        if (!dataAccess.isAuthenticated(username, password)) {
            presenter.prepareFailView("Authentication failed.");
            return;
        }

        // Retrieve the user and the order
        MyUser user = dataAccess.get(username, password);
        Order order = dataAccess.getOrder(orderId);

        if (order == null) {
            presenter.prepareFailView("Order not found.");
            return;
        }

        if (order.getBuyerId() != user.getId() && order.getSellerId() != user.getId()) {
            presenter.prepareFailView("User not authorized to cancel this order.");
            return;
        }

        order.setOrderStatus(-1); // assuming -1 represents "Cancelled" for now, modification expected
        dataAccess.saveOrder(order);

        // Prepare the success response
        presenter.prepareSuccessView(new CancelOrderOutputData("Order successfully cancelled."));
    }
}
