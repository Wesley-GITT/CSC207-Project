package use_case.order.list_customer_orders;

import entity.MyUser;
import use_case.user.auth.AuthUserDataAccessInterface;

import java.util.Set;

public class ListCustomerOrdersInteractor {
    private final AuthUserDataAccessInterface userDataAccessObject;
    private final ListCustomerOrderDataAccessInterface orderDataAccessInterface;
    private final ListCustomerOrdersOutputBoundary listCustomerOrdersPresenter;

    public ListCustomerOrdersInteractor(AuthUserDataAccessInterface userDataAccessObject,
                                        ListCustomerOrderDataAccessInterface orderDataAccessInterface,
                                        ListCustomerOrdersOutputBoundary listCustomerOrdersPresenter) {

        this.userDataAccessObject = userDataAccessObject;
        this.orderDataAccessInterface = orderDataAccessInterface;
        this.listCustomerOrdersPresenter = listCustomerOrdersPresenter;
    }

    public void execute(ListCustomerOrdersInputData inputData) {
        final String username = inputData.getUsername();
        final String password = inputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            listCustomerOrdersPresenter.prepareFailView("Authentication failed");
        }

        // Retrieve the seller's ID
        final MyUser user = userDataAccessObject.get(username, password);

        // Retrieve orders where the seller is the logged-in user
        Set<Integer> orderIds = orderDataAccessInterface.listCustomOrders(user.getId());

        final ListCustomerOrdersOutputData outputData = new ListCustomerOrdersOutputData(orderIds);
        listCustomerOrdersPresenter.prepareSuccessView(outputData);
    }
}
