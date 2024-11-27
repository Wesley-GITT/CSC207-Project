package use_case.order.cancel;

import entity.MyUser;
import entity.Order;
import entity.Product;
import use_case.product.update.UpdateProductDataAccessInterface;
import use_case.user.auth.AuthUserDataAccessInterface;

public class CancelOrderInteractor {

    private final AuthUserDataAccessInterface userDataAccessObject;
    private final UpdateProductDataAccessInterface productDataAccessObject;
    private final CancelOrderDataAccessInterface orderDataAccessObject;
    private final CancelOrderOutputBoundary cancelOrderPresenter;


    public CancelOrderInteractor(AuthUserDataAccessInterface userDataAccessObject,
                                 UpdateProductDataAccessInterface productDataAccessObject,
                                 CancelOrderDataAccessInterface orderDataAccessObject,
                                 CancelOrderOutputBoundary cancelOrderPresenter) {

        this.userDataAccessObject = userDataAccessObject;
        this.productDataAccessObject = productDataAccessObject;
        this.orderDataAccessObject = orderDataAccessObject;
        this.cancelOrderPresenter = cancelOrderPresenter;
    }

    public void execute(CancelOrderInputData inputData) {
        final String username = inputData.getUsername();
        final String password = inputData.getPassword();
        final int orderId = inputData.getOrderId();

        // Retrieve the user and the order
        if (!orderDataAccessObject.exist(orderId)) {
            cancelOrderPresenter.prepareFailView("Order with ID `" + orderId +"` doesn't exist");
            return;
        }

        final MyUser user = userDataAccessObject.get(username, password);
        final Order order = orderDataAccessObject.get(orderId);

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            cancelOrderPresenter.prepareFailView("Authentication failed");
            return;
        }

        if (user.getId() != order.getBuyerId()) {
            cancelOrderPresenter.prepareFailView("Authentication failed");
            return;
        }

        final int productId = order.getProductId();
        if (productDataAccessObject.exist(productId)) {
            Product product = productDataAccessObject.get(productId);
            product.setIsSold(false);
            return;
        }

        orderDataAccessObject.remove(orderId);

        final CancelOrderOutputData outputData = new CancelOrderOutputData(orderId);
        cancelOrderPresenter.prepareSuccessView(outputData);
    }
}
