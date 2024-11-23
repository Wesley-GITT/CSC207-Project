package use_case.order.create;

import entity.Order;
import entity.Product;
import use_case.user.BasicAuthDataAccessInterface;
import use_case.user.UserGetDataAccessInterface;
import use_case.user.UserSaveDataAccessInterface;

public interface CreateOrderDataAccessInterface extends
        BasicAuthDataAccessInterface,
        UserGetDataAccessInterface,
        UserSaveDataAccessInterface {

    Order getOrder(int orderId);

    void saveOrder(Order order);

    Product getProductById(int productId);

    void saveProduct(Product product);
}