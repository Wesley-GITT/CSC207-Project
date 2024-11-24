package data_access;

import data_access.order.InMemoryOrderDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import data_access.user.InMemoryItemsUserDataAccessObject;
import entity.MyUser;
import entity.Order;
import entity.Product;
import use_case.order.create.CreateOrderDataAccessInterface;
import use_case.order.list_my_orders.ListMyOrdersDataAccessInterface;

import java.util.List;

public class CompositeDataAccessObject implements
        CreateOrderDataAccessInterface,
        ListMyOrdersDataAccessInterface {

    private final InMemoryItemsUserDataAccessObject userDataAccess;
    private final InMemoryProductDataAccessObject productDataAccess;
    private final InMemoryOrderDataAccessObject orderDataAccess;

    public CompositeDataAccessObject(
            InMemoryItemsUserDataAccessObject userDataAccess,
            InMemoryProductDataAccessObject productDataAccess,
            InMemoryOrderDataAccessObject orderDataAccess) {
        this.userDataAccess = userDataAccess;
        this.productDataAccess = productDataAccess;
        this.orderDataAccess = orderDataAccess;
    }

    // User-related methods
    @Override
    public boolean isAuthenticated(String username, String password) {
        return userDataAccess.isAuthenticated(username, password);
    }

    @Override
    public MyUser get(String username, String password) {
        return userDataAccess.get(username, password);
    }

    @Override
    public void save(MyUser user) {
        userDataAccess.save(user);
    }

    // Product-related methods
    @Override
    public Product getProductById(int productId) {
        return productDataAccess.getProductById(productId);
    }

    @Override
    public void saveProduct(Product product) {
        productDataAccess.saveProduct(product);
    }

    // Order-related methods
    @Override
    public Order getOrder(int orderId) {
        return orderDataAccess.getOrder(orderId);
    }

    @Override
    public void saveOrder(Order order) {
        orderDataAccess.saveOrder(order);
    }

    @Override
    public int getBuyerId(String username) {
        return orderDataAccess.getBuyerId(username);
    }

    @Override
    public List<Order> getOrdersByBuyerId(int buyerId) {
        return orderDataAccess.getOrdersByBuyerId(buyerId);
    }
}
