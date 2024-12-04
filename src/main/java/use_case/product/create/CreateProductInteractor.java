package use_case.product.create;

import entity.MyUser;
import entity.Product;
import use_case.user.auth.AuthUserDataAccessInterface;

public class CreateProductInteractor implements CreateProductInputBoundary {

    private final AuthUserDataAccessInterface userDataAccessObject;
    private final CreateProductDataAccessInterface productDataAccessObject;
    private final CreateProductOutputBoundary createProductPresenter;

    public CreateProductInteractor(AuthUserDataAccessInterface userDataAccessObject,
                                   CreateProductDataAccessInterface productDataAccessObject,
                                   CreateProductOutputBoundary createProductPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.productDataAccessObject = productDataAccessObject;
        this.createProductPresenter = createProductPresenter;
    }

    @Override
    public void execute(CreateProductInputData createProductInputData) {
        final String username = createProductInputData.getUsername();
        final String password = createProductInputData.getPassword();

        if (!userDataAccessObject.isAuthenticated(username, password)) {
            createProductPresenter.prepareFailView("Authentication failed");
        }
        else {
            final MyUser user = userDataAccessObject.get(username, password);
            final Product product = new Product(-1,
                    // need data access
                    createProductInputData.getBookId(),
                    user.getId(),
                    createProductInputData.getBookCondition(),
                    createProductInputData.getPrice(),
                    false);

            productDataAccessObject.add(product);

            final CreateProductOutputData outputData = new CreateProductOutputData(product.getId());
            createProductPresenter.prepareSuccessView(outputData);
        }
    }
}
