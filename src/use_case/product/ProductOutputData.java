package use_case.product;

/*
This data class represents the response returned after a product operation, such as posting or deleting a product.
 */
public class ProductOutputData {
    private final boolean success;
    private final String message;

    public ProductOutputData(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }
    public String getMessage() {
        return message;
    }
}
