package use_case.order.list_customer_orders;

import data_access.CompositeDataAccessObject;
import entity.MyUser;
import entity.Order;

import java.util.ArrayList;
import java.util.List;

public class ListCustomerOrdersInteractor {
    private final CompositeDataAccessObject dataAccess;
    private final ListCustomerOrdersOutputBoundary presenter;

    public ListCustomerOrdersInteractor(CompositeDataAccessObject dataAccess, ListCustomerOrdersOutputBoundary presenter) {
        this.dataAccess = dataAccess;
        this.presenter = presenter;
    }

    public void execute(ListCustomerOrdersInputData inputData) {
        String username = inputData.getUsername();
        String password = inputData.getPassword();

        if (!dataAccess.isAuthenticated(username, password)) {
            presenter.prepareFailView("Authentication failed.");
            return;
        }

        // Retrieve the seller's ID
        MyUser seller = dataAccess.get(username, password);
        int sellerId = seller.getId();

        // Retrieve orders where the seller is the logged-in user
        List<Order> orders = dataAccess.getOrdersBySellerId(sellerId);

        // Extract product IDs
        List<Integer> productIds = new ArrayList<>();
        for (Order order : orders) {
            productIds.add(order.getProductId());
        }

        presenter.prepareSuccessView(new ListCustomerOrdersOutputData(productIds));
    }
}
