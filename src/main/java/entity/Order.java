package entity;

import java.util.Calendar;

public class Order {

    private int id;
    private int buyerId;
    private int sellerId;
    private int productId;
    private Calendar orderTime;
    private String deliveryAddress;

    public Order(int id, int buyerId, int sellerId, int productId, Calendar orderTime, String deliveryAddress) {
        this.id = id;
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderTime = orderTime;
        this.deliveryAddress = deliveryAddress;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }

    public int getBuyerId() {
        return buyerId;
    }

    public int getSellerId() {
        return sellerId;
    }

    public int getProductId() {
        return productId;
    }

    public Calendar getOrderTime() {
        return orderTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }
}