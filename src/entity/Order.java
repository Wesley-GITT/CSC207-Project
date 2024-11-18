package entity;

import java.util.Date;

public class Order {

    private int id;
    private int buyerId;
    private int sellerId;
    private int productId;
    private Date orderTime;
    private int orderStatus;
    private String deliveryAddress;

    public Order(int id, int buyerId, int sellerId, int productId, Date orderTime, int orderStatus, String deliveryAddress) {
        this.id = id;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
    }

    public int getId() {
        return id;
    }

    public int getBuyerId() {
        return buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}
