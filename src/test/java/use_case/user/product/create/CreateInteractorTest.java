package use_case.user.product.create;

import data_access.user.InMemoryProductsUserDataAccessObject;
import use_case.product.create.CreateProductInputData;
import use_case.product.create.CreateProductUserDataAccessInterface;

public class CreateInteractorTest {
    private final float price = 9.9F;
    CreateProductInputData inputData = new CreateProductInputData("eric", "123", "1", "good", price);
    CreateProductUserDataAccessInterface userRepo = new InMemoryProductsUserDataAccessObject();
}
