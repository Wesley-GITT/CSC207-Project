package use_case.order.create;

import entity.MyUser;
import entity.Order;
import entity.Product;

import java.util.Date;

public class CreateOrderInteractor implements CreateOrderInputBoundary {

    private final CreateOrderDataAccessInterface userDataAccessObject;
    private final CreateOrderOutputBoundary createOrderPresenter;

    public CreateOrderInteractor(CreateOrderDataAccessInterface userDataAccessObject, CreateOrderOutputBoundary createOrderPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.createOrderPresenter = createOrderPresenter;
    }

    @Override
    public void execute(CreateOrderInputData createOrderInputData) {

        final String username = createOrderInputData.getUsername();
        final String password = createOrderInputData.getPassword();
        final int productId = createOrderInputData.getProductId();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            createOrderPresenter.prepareFailView("Authentication failed.");
            return;
        }

        final MyUser user = userDataAccessObject.get(username, password);
        final Product product = userDataAccessObject.getProductById(productId);

        if (product == null) {
            createOrderPresenter.prepareFailView("Product not found.");
            return;
        }

        if (product.isSold()) {
            createOrderPresenter.prepareFailView("Product is already sold.");
            return;
        }

        product.setSold(true);
        userDataAccessObject.saveProduct(product);

        Order order = new Order(1, user.getId(), Integer.parseInt(product.getSellerId()),
                productId, new Date(),0, user.getAddress());

        userDataAccessObject.saveOrder(order);

        CreateOrderOutputData outputData = new CreateOrderOutputData(order.getId());
        createOrderPresenter.prepareSuccessView(outputData);
    }
}