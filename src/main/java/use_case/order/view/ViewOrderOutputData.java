package use_case.order.view;

import java.util.Date;

public class ViewOrderOutputData {

    private final int buyerId;
    private final int sellerId;
    private final int productId;
    private final Date orderTime;
    private final int orderStatus;
    private final String deliveryAddress;

    public ViewOrderOutputData(int buyerId, int sellerId, int productId, Date orderTime, int orderStatus, String deliveryAddress) {
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderTime = orderTime;
        this.orderStatus = orderStatus;
        this.deliveryAddress = deliveryAddress;
    }

    // Add getters for all fields
    public int getBuyerId() { return buyerId; }

    public int getSellerId() { return sellerId; }

    public int getProductId() { return productId; }

    public Date getOrderTime() { return orderTime; }

    public int getOrderStatus() { return orderStatus; }

    public String getDeliveryAddress() { return deliveryAddress; }
}
