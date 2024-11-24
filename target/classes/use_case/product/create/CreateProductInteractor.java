package use_case.product.create;

import entity.MyUser;
import entity.Product;


public class CreateProductInteractor implements CreateProductInputBoundary{

    private final CreateProductUserDataAccessInterface userDataAccessObject;
    private final CreateProductOutputBoundary createProductPresenter;

    public CreateProductInteractor(CreateProductUserDataAccessInterface bookDataAccessInterface, CreateProductOutputBoundary createProductOutputBoundary) {
        this.userDataAccessObject = bookDataAccessInterface;
        this.createProductPresenter = createProductOutputBoundary;
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
            final Product product = new Product(createProductInputData.getProductId(),
                    createProductInputData.getBookId(),
                    createProductInputData.getSellerId(),
                    createProductInputData.getBookCondition(),
                    createProductInputData.getPrice(),
                    createProductInputData.isSold());

            if (product.isSold()) {
                createProductPresenter.prepareFailView("Why do post a sold product?.");
            }

            userDataAccessObject.save(user);
            userDataAccessObject.saveProduct(product);

            CreateProductOutputData outputData = new CreateProductOutputData(product.getId());
            createProductPresenter.prepareSuccessView(outputData);
        }
    }
}
