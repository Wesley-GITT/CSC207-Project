package use_case.product.view;

import entity.Product;


public class ViewProductInteractor implements ViewProductInputBoundary {

    private final ViewProductDataAccessInterface productDataAccessObject;
    private final ViewProductOutputBoundary viewProductPresenter;

    public ViewProductInteractor(ViewProductDataAccessInterface productDataAccessObject, ViewProductOutputBoundary viewProductPresenter) {
        this.productDataAccessObject = productDataAccessObject;
        this.viewProductPresenter = viewProductPresenter;
    }

    @Override
    public void execute(ViewProductInputData viewProductInputData) {
        final int productId = viewProductInputData.getProductId();
        if (!productDataAccessObject.exist(productId)) {
            viewProductPresenter.prepareFailView("Product with ID `" + productId + "` doesn't exist");
            return;
        }

        final Product product = productDataAccessObject.get(productId);
        final String bookId = product.getBookId();
        final int sellerId = product.getSellerId();
        final String bookCondition = product.getBookCondition();
        final double price = product.getPrice();
        final boolean isSold = product.getIsSold();

        ViewProductOutputData outputData = new ViewProductOutputData(
                productId,bookId, sellerId,
                bookCondition, price, isSold);

        viewProductPresenter.prepareSuccessView(outputData);
    }
}
