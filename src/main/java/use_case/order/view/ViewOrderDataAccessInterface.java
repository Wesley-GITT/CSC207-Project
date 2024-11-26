package use_case.order.view;

import use_case.order.OrderExistDataAccessInterface;
import use_case.order.OrderGetDataAccessInterface;

public interface ViewOrderDataAccessInterface extends
        OrderExistDataAccessInterface,
        OrderGetDataAccessInterface {

}
