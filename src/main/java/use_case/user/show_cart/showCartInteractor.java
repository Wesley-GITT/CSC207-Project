package use_case.user.show_cart;

import entity.MyUser;

import java.util.Set;

public class ShowCartInteractor implements ShowCartInputBoundary {

    private ShowCartUserDataAccessInterface userDataAccessObject;
    private ShowCartOutputBoundary updateCartPresenter;

    public ShowCartInteractor(ShowCartUserDataAccessInterface userDataAccessObject, ShowCartOutputBoundary updateCartPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.updateCartPresenter = updateCartPresenter;
    }

    @Override
    public void execute(ShowCartInputData showCartInputData) {

        final String username = showCartInputData.getUsername();
        final String password = showCartInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            updateCartPresenter.prepareFailView("Authentication failed");
        } else {
            final MyUser user = userDataAccessObject.get(username, password);
            final Set<Integer> cartItems = user.getCartItems();

            userDataAccessObject.save(user);

            ShowCartOutputData outputData = new ShowCartOutputData(cartItems);
            updateCartPresenter.prepareSuccessView(outputData);
        }
    }
}
