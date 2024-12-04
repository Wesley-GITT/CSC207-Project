package use_case.product;

public interface ProductExistDataAccessInterface {

    /**
     * Exist for errorMessage.
     * @param id id
     * @return boolean
     */
    boolean exist(int id);
}
