package use_case.product.remove;

public class RemoveProductOutputData {

    private int productId;

    public RemoveProductOutputData(int id) {
        this.productId = id;
    }

    public int getProductId() {
        return this.productId;
    }

}
