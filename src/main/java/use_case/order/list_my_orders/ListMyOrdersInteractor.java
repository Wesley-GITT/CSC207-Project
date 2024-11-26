package use_case.order.list_my_orders;

import entity.MyUser;
import use_case.user.auth.AuthUserDataAccessInterface;

import java.util.Set;

public class ListMyOrdersInteractor implements ListMyOrdersInputBoundary {

    private final AuthUserDataAccessInterface userDataAccessObject;
    private final ListMyOrderDataAccessInterface orderDataAccessObject;
    private final ListMyOrdersOutputBoundary presenter;

    public ListMyOrdersInteractor(AuthUserDataAccessInterface userDataAccessObject,
                                  ListMyOrderDataAccessInterface orderDataAccessObject,
                                  ListMyOrdersOutputBoundary presenter) {

        this.userDataAccessObject = userDataAccessObject;
        this.orderDataAccessObject = orderDataAccessObject;
        this.presenter = presenter;
    }

    @Override
    public void execute(ListMyOrdersInputData inputData) {
        String username = inputData.getUsername();
        String password = inputData.getPassword();

        // Check authentication
        if (!userDataAccessObject.isAuthenticated(username, password)) {
            presenter.prepareFailView("Authentication failed");
        }

        // Retrieve buyer ID and orders
        final MyUser user = userDataAccessObject.get(username, password);

        // Extract product IDs from orders
        Set<Integer> orderIds = orderDataAccessObject.listMyOrders(user.getId());

        // Prepare output data
        ListMyOrdersOutputData outputData = new ListMyOrdersOutputData(orderIds);
        presenter.prepareSuccessView(outputData);
    }
}
