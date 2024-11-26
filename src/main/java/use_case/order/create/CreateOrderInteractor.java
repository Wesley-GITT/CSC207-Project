package use_case.order.create;

import entity.MyUser;
import entity.Order;
import entity.Product;
import use_case.product.update.UpdateProductDataAccessInterface;
import use_case.user.auth.AuthUserDataAccessInterface;

import java.util.Calendar;
import java.util.TimeZone;

public class CreateOrderInteractor implements CreateOrderInputBoundary {

    private final AuthUserDataAccessInterface userDataAccessObject;
    private final UpdateProductDataAccessInterface productDataAccessInterface;
    private final CreateOrderDataAccessInterface orderDataAccessObject;
    private final CreateOrderOutputBoundary createOrderPresenter;

    public CreateOrderInteractor(AuthUserDataAccessInterface userDataAccessObject,
                                 UpdateProductDataAccessInterface productDataAccessInterface,
                                 CreateOrderDataAccessInterface orderDataAccessObject,
                                 CreateOrderOutputBoundary createOrderPresenter) {

        this.userDataAccessObject = userDataAccessObject;
        this.productDataAccessInterface = productDataAccessInterface;
        this.orderDataAccessObject = orderDataAccessObject;
        this.createOrderPresenter = createOrderPresenter;
    }

    @Override
    public void execute(CreateOrderInputData createOrderInputData) {

        final String username = createOrderInputData.getUsername();
        final String password = createOrderInputData.getPassword();
        final int productId = createOrderInputData.getProductId();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            createOrderPresenter.prepareFailView("Authentication failed");
            return;
        }

        if (!productDataAccessInterface.exist(productId)) {
            createOrderPresenter.prepareFailView("Product with ID `" + productId + "` doesn't exist");
            return;
        }

        final Product product = productDataAccessInterface.get(productId);
        final MyUser user = userDataAccessObject.get(username, password);

        if (user.getId() == product.getSellerId()) {
            createOrderPresenter.prepareFailView("You can't by your own product");
            return;
        }

        if (product.getIsSold()) {
            createOrderPresenter.prepareFailView("Product with ID `" + productId + "` is already sold");
            return;
        }

        Order order = new Order(-1, user.getId(), product.getSellerId(),
                productId,Calendar.getInstance(TimeZone.getTimeZone("UTC")), user.getAddress());
        orderDataAccessObject.add(order);

        product.setIsSold(true);
        productDataAccessInterface.save(product);

        final CreateOrderOutputData outputData = new CreateOrderOutputData(order.getId(), productId);
        createOrderPresenter.prepareSuccessView(outputData);
    }
}