package use_case.user.show_cart;

import entity.MyUser;

import java.util.Set;

public class showCartInteractor implements showCartInputBoundary {

    private showCartUserDataAccessInterface userDataAccessObject;
    private showCartOutputBoundary updateCartPresenter;

    public showCartInteractor(showCartUserDataAccessInterface userDataAccessObject, showCartOutputBoundary updateCartPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.updateCartPresenter = updateCartPresenter;
    }

    @Override
    public void execute(showCartInputData showCartInputData) {

        final String username = showCartInputData.getUsername();
        final String password = showCartInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            updateCartPresenter.prepareFailView("Authentication Failed");
        } else {
            final MyUser user = userDataAccessObject.get(username, password);
            final Set<Integer> cartItems = user.getCartItems();

            userDataAccessObject.save(user);

            showCartOutputData outputData = new showCartOutputData(cartItems);
            updateCartPresenter.prepareSuccessView(outputData);
        }
    }
}
