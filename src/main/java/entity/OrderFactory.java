package entity;

import java.util.Calendar;

public class OrderFactory {

    public final static int BUYER = 0;
    public final static int SELLER = 1;

    public Order create(int id, int buyerId, int sellerId, int productId, Calendar orderTime, String deliveryAddress) {
        return new Order(id, buyerId, sellerId, productId, orderTime, deliveryAddress);
    }

    public Order create(int userId, int who) {
        if (who == BUYER) {
            return new Order(-1, userId, -1, -1, Calendar.getInstance(), "");
        } else if (who == SELLER) {
            return new Order(-1, -1, userId, -1, Calendar.getInstance(), "");
        } else {
            return null;
        }
    }
}
