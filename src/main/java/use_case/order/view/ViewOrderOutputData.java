package use_case.order.view;

import java.util.Calendar;

public class ViewOrderOutputData {

    public final static int BUYER = 0;
    public final static int SELLER = 1;

    private final int buyerId;
    private final int sellerId;
    private final int productId;
    private final Calendar orderTime;
    private final int orderStatus;
    private final String deliveryAddress;
    private final int who;


    public ViewOrderOutputData(int buyerId, int sellerId, int productId, Calendar orderTime, int orderStatus, String deliveryAddress, int who) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
        this.who = who;
    }

    // Add getters for all fields
    public int getBuyerId() { return buyerId; }

    public int getSellerId() { return sellerId; }

    public int getProductId() { return productId; }

    public Calendar getOrderTime() { return orderTime; }

    public int getOrderStatus() { return orderStatus; }

    public String getDeliveryAddress() { return deliveryAddress; }

    public int getWho() {
        return who;
    }
}
