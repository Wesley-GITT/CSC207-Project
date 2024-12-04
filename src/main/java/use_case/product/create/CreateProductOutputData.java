package use_case.product.create;

public class CreateProductOutputData {

    private final int productId;

    public CreateProductOutputData(int productId) {
        this.productId = productId;
    }

    public int getProductId() {
        return productId;
    }
}
