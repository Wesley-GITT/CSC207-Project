package use_case.user.update_cart;

import entity.MyUser;

import java.util.Set;

public class UpdateCartInteractor implements UpdateCartInputBoundary {

    private UpdateCartUserDataAccessInterface userDataAccessObject;
    private UpdateCartOutputBoundary updateCartPresenter;

    public UpdateCartInteractor(UpdateCartUserDataAccessInterface userDataAccessObject, UpdateCartOutputBoundary updateCartPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.updateCartPresenter = updateCartPresenter;
    }

    @Override
    public void execute(UpdateCartInputData updateCartInputData) {

        final String username = updateCartInputData.getUsername();
        final String password = updateCartInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            updateCartPresenter.prepareFailView("Authentication failed");
        } else {
            final Set<Integer> cartItems = updateCartInputData.getCartItems();
            final MyUser user = userDataAccessObject.get(username, password);

            user.setCartItems(cartItems);
            userDataAccessObject.save(user);

            UpdateCartOutputData outputData = new UpdateCartOutputData(cartItems);
            updateCartPresenter.prepareSuccessView(outputData);
        }
    }
}
