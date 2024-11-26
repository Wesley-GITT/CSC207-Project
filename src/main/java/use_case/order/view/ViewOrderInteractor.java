package use_case.order.view;

import entity.MyUser;
import entity.Order;
import use_case.user.auth.AuthUserDataAccessInterface;

public class ViewOrderInteractor implements ViewOrderInputBoundary {

    private final AuthUserDataAccessInterface userDataAccessObject;
    private final ViewOrderDataAccessInterface orderDataAccessObject;
    private final ViewOrderOutputBoundary viewOrderPresenter;

    public ViewOrderInteractor(AuthUserDataAccessInterface userDataAccessObject,
                               ViewOrderDataAccessInterface orderDataAccessObject,
                               ViewOrderOutputBoundary viewOrderPresenter) {

        this.userDataAccessObject = userDataAccessObject;
        this.orderDataAccessObject = orderDataAccessObject;
        this.viewOrderPresenter = viewOrderPresenter;
    }

    @Override
    public void execute(ViewOrderInputData inputData) {

        final String username = inputData.getUsername();
        final String password = inputData.getPassword();
        final int orderId = inputData.getOrderId();

        if (orderDataAccessObject.exist(orderId)) {
            viewOrderPresenter.prepareFailView("Order not found");
        }

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            viewOrderPresenter.prepareFailView("Authentication failed");
        }

        final MyUser user = userDataAccessObject.get(username, password);
        final Order order = orderDataAccessObject.get(orderId);

        if (order.getBuyerId() == user.getId()) {
            ViewOrderOutputData outputData = new ViewOrderOutputData(
                    order.getBuyerId(), order.getSellerId(), order.getProductId(), order.getOrderTime(),
                    order.getOrderStatus(), order.getDeliveryAddress(), ViewOrderOutputData.BUYER);

            viewOrderPresenter.prepareSuccessView(outputData);
        } else if (order.getBuyerId() == user.getId()) {
            ViewOrderOutputData outputData = new ViewOrderOutputData(
                    order.getBuyerId(), order.getSellerId(), order.getProductId(), order.getOrderTime(),
                    order.getOrderStatus(), order.getDeliveryAddress(), ViewOrderOutputData.SELLER);

            viewOrderPresenter.prepareSuccessView(outputData);
        }


    }
}
