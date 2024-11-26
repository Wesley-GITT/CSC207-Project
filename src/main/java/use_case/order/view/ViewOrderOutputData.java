package use_case.order.view;

import java.util.Calendar;

public class ViewOrderOutputData {

    private final int buyerId;
    private final int sellerId;
    private final int productId;
    private final Calendar orderTime;
    private final String deliveryAddress;
    private final int who;


    public ViewOrderOutputData(int buyerId, int sellerId, int productId, Calendar orderTime, String deliveryAddress, int who) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderTime = orderTime;
        this.deliveryAddress = deliveryAddress;
        this.who = who;
    }

    // Add getters for all fields
    public int getBuyerId() { return buyerId; }

    public int getSellerId() { return sellerId; }

    public int getProductId() { return productId; }

    public Calendar getOrderTime() { return orderTime; }

    public String getDeliveryAddress() { return deliveryAddress; }

    public int getWho() {
        return who;
    }
}
