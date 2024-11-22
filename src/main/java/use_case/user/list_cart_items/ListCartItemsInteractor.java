package use_case.user.list_cart_items;

import entity.MyUser;

import java.util.Set;

public class ListCartItemsInteractor implements ListCartItemsInputBoundary {

    private ListCartItemsUserDataAccessInterface userDataAccessObject;
    private ListCartItemsOutputBoundary updateCartPresenter;

    public ListCartItemsInteractor(ListCartItemsUserDataAccessInterface userDataAccessObject, ListCartItemsOutputBoundary updateCartPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.updateCartPresenter = updateCartPresenter;
    }

    @Override
    public void execute(ListCartItemsInputData listCartItemsInputData) {

        final String username = listCartItemsInputData.getUsername();
        final String password = listCartItemsInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            updateCartPresenter.prepareFailView("Authentication failed");
        } else {
            final MyUser user = userDataAccessObject.get(username, password);
            final Set<Integer> cartItems = user.getCartItems();

            userDataAccessObject.save(user);

            ListCartItemsOutputData outputData = new ListCartItemsOutputData(cartItems);
            updateCartPresenter.prepareSuccessView(outputData);
        }
    }
}
