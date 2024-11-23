package use_case.order.list_my_orders;

import entity.Order;

import java.util.ArrayList;
import java.util.List;

public class ListMyOrdersInteractor implements ListMyOrdersInputBoundary {

    private final ListMyOrdersDataAccessInterface dataAccess;
    private final ListMyOrdersOutputBoundary presenter;

    public ListMyOrdersInteractor(ListMyOrdersDataAccessInterface dataAccess, ListMyOrdersOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    @Override
    public void execute(ListMyOrdersInputData inputData) {
        String username = inputData.getUsername();
        String password = inputData.getPassword();

        // Check authentication
        if (!dataAccess.isAuthenticated(username, password)) {
            presenter.prepareFailView("Authentication failed.");
            return;
        }

        // Retrieve buyer ID and orders
        int buyerId = dataAccess.getBuyerId(username);
        List<Order> orders = dataAccess.getOrdersByBuyerId(buyerId);

        // Extract product IDs from orders
        List<Integer> productIds = new ArrayList<>();
        for (Order order : orders) {
            productIds.add(order.getProductId());
        }

        // Prepare output data
        ListMyOrdersOutputData outputData = new ListMyOrdersOutputData(productIds);
        presenter.prepareSuccessView(outputData);
    }
}
