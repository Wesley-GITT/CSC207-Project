package use_case.product;

import Repository.BookRepository;
import entity.Book;

import java.util.Optional;

/*
This inteactor handles product operations and interacts with the repository to persist data.
 */
public abstract class ProductInteractor implements ProductInputBoundary {
    private final BookRepository bookRepository;
    private final ProductOutputBoundary productOutputBoundary;

    protected ProductInteractor(BookRepository bookRepository, ProductOutputBoundary productOutputBoundary) {
        this.bookRepository = bookRepository;
        this.productOutputBoundary = productOutputBoundary;
    }

    @Override
    public ProductOutputData postProduct(ProductInputData productInputData) {
        Book book = new Book(productInputData.getProductId(), productInputData.getTitle(), productInputData.getAuthor(),
                productInputData.getCondition(), productInputData.getPrice(), productInputData.getDescription(),
                productInputData.getImageUrl(), productInputData.getSeller());
        bookRepository.save(book);

        ProductOutputData productOutputData = new ProductOutputData(true, "Product posted!");
        productOutputBoundary.presentProductResult(productOutputData);
        return productOutputData;
    }

    @Override
    public ProductOutputData editProduct(ProductInputData productInputData) {
        Book book = bookRepository.findByID(productInputData.getProductId());
        if (book == null) {
            return new ProductOutputData(false, "Product not found!");
        }

        book.setId(productInputData.getProductId());
        book.setTitle(productInputData.getTitle());
        book.setAuthor(productInputData.getAuthor());
        book.setCondition(productInputData.getCondition());
        book.setPrice(productInputData.getPrice());
        book.setDescription(productInputData.getDescription());
        book.setImageUrl(productInputData.getImageUrl());

        bookRepository.save(book);

        return new ProductOutputData(true, "Product updated!");
    }

    @Override
    public ProductOutputData deleteProduct(Integer productId) {
        if (!bookRepository.existsById(productId)) {
            return new ProductOutputData(false, "Product not found.");
        }
        bookRepository.deleteById(productId);
        return new ProductOutputData(true, "Product deleted successfully.");
    }
}