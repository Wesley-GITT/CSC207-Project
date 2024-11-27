package use_case.product.update;

import entity.MyUser;
import entity.Product;
import use_case.book.view.ViewBookDataAccessInterface;
import use_case.user.auth.AuthUserDataAccessInterface;


public class UpdateProductInteractor implements UpdateProductInputBoundary {
    private final AuthUserDataAccessInterface userDataAccessObject;
    private final ViewBookDataAccessInterface bookDataAccessObject;
    private final UpdateProductDataAccessInterface productDataAccessObject;
    private final UpdateProductOutputBoundary updateProductPresenter;

    public UpdateProductInteractor(AuthUserDataAccessInterface userDataAccessObject,
                                   ViewBookDataAccessInterface bookDataAccessObject,
                                   UpdateProductDataAccessInterface productDataAccessObject,
                                   UpdateProductOutputBoundary updateProductPresenter) {

        this.userDataAccessObject = userDataAccessObject;
        this.bookDataAccessObject = bookDataAccessObject;
        this.productDataAccessObject = productDataAccessObject;
        this.updateProductPresenter = updateProductPresenter;
    }

    @Override
    public void execute(UpdateProductInputData updateProductInputData) {
        final String username = updateProductInputData.getUsername();
        final String password = updateProductInputData.getPassword();
        final int productId = updateProductInputData.getProductId();
        final String bookId = updateProductInputData.getBookId();
        final String bookCondition = updateProductInputData.getBookCondition();
        final double price = updateProductInputData.getPrice();

        if (!productDataAccessObject.exist(productId)) {
            updateProductPresenter.prepareFailView("Product with ID `" + productId + "` doesn't exist");
            return;
        }

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            updateProductPresenter.prepareFailView("Authentication failed");
            return;
        }

        final MyUser user = userDataAccessObject.get(username, password);
        final Product product = productDataAccessObject.get(productId);

        if (user.getId() != product.getSellerId()) {
            updateProductPresenter.prepareFailView("Authentication failed");
            return;
        }

        if (!bookDataAccessObject.exist(bookId)) {
            updateProductPresenter.prepareFailView("Book with ID `" + bookId + "` doesn't exist");
            return;
        }

        product.setBookId(bookId);
        product.setBookCondition(bookCondition);
        product.setPrice(price);

        productDataAccessObject.save(product);
        final boolean isSold = product.getIsSold();

        UpdateProductOutputData outputData = new UpdateProductOutputData(productId, bookId, bookCondition, price, isSold);
        updateProductPresenter.prepareSuccessView(outputData);
    }
}
