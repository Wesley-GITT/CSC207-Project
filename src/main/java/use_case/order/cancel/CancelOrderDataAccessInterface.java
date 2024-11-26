package use_case.order.cancel;

import use_case.order.OrderExistDataAccessInterface;
import use_case.order.OrderGetDataAccessInterface;

public interface CancelOrderDataAccessInterface extends
        OrderExistDataAccessInterface,
        OrderGetDataAccessInterface {

    void remove(int id);
}
