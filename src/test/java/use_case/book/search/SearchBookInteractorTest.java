package use_case.book.search;

import data_access.book.ApiBookDataAccessObject;
import data_access.book.InMemoryBookDataAccessObject;
import data_access.product.InMemoryProductDataAccessObject;
import entity.BookFactory;
import entity.ProductFactory;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SearchBookInteractorTest {

    @Test
    public void successSearchBookTest() {
        final SearchBookInputData inputData = new SearchBookInputData("harry", 2, 0, false);
        final InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        final ApiBookDataAccessObject bookRepo = new ApiBookDataAccessObject();

        BookFactory bookFactory = new BookFactory();
        // bookRepo.save(bookFactory.create("test1", "Harry Potter and the Philosopher's Stone"));
        // bookRepo.save(bookFactory.create("test2", "Harry Potter and the Chamber of Secrets"));

        SearchBookOutputBoundary successPresenter = new SearchBookOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchBookOutputData searchBookOutputData) {
                final List<String> bookIds = searchBookOutputData.getBookIds();
                assertEquals(2, searchBookOutputData.getEndIndex());
                assertEquals(0, searchBookOutputData.getStartIndex());
                // assertTrue(bookIds.contains("test1"));
                // assertTrue(bookIds.contains("test2"));
                assertEquals(2, bookIds.size());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        SearchBookInteractor interactor = new SearchBookInteractor(productRepo, bookRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void successSearchBookWithProductTest() {
        final SearchBookInputData inputData = new SearchBookInputData("harry", 2, 0, true);
        final InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        final InMemoryBookDataAccessObject bookRepo = new InMemoryBookDataAccessObject();

        final BookFactory bookFactory = new BookFactory();
        bookRepo.save(bookFactory.create("test1", "Harry Potter and the Philosopher's Stone"));
        bookRepo.save(bookFactory.create("test2", "Harry Potter and the Chamber of Secrets"));

        final ProductFactory productFactory = new ProductFactory();
        productRepo.save(productFactory.create("test1", 0));
        productRepo.save(productFactory.create("test1", 1));
        productRepo.save(productFactory.create("test1", 0));

        SearchBookOutputBoundary successPresenter = new SearchBookOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchBookOutputData searchBookOutputData) {
                final List<String> bookIds = searchBookOutputData.getBookIds();
                assertEquals(2, searchBookOutputData.getEndIndex());
                assertEquals(0, searchBookOutputData.getStartIndex());
                assertTrue(bookIds.contains("test1"));
                assertEquals(1, bookIds.size());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        SearchBookInteractor interactor = new SearchBookInteractor(productRepo, bookRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureNegativeStartIndexTest() {
        final SearchBookInputData inputData = new SearchBookInputData("harry", 2, -10, false);
        final InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        final InMemoryBookDataAccessObject bookRepo = new InMemoryBookDataAccessObject();

        SearchBookOutputBoundary failurePresenter = new SearchBookOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchBookOutputData searchBookOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Start index is out of range", errorMessage);
            }
        };

        SearchBookInteractor interactor = new SearchBookInteractor(productRepo, bookRepo, failurePresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureInvalidResMaxNumTest() {
        final SearchBookInputData inputData = new SearchBookInputData("harry", 0, 0, false);
        final InMemoryProductDataAccessObject productRepo = new InMemoryProductDataAccessObject();
        final InMemoryBookDataAccessObject bookRepo = new InMemoryBookDataAccessObject();

        SearchBookOutputBoundary failurePresenter = new SearchBookOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchBookOutputData searchBookOutputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Maximum number of items each search can't be less than 1", errorMessage);
            }
        };

        SearchBookInteractor interactor = new SearchBookInteractor(productRepo, bookRepo, failurePresenter);
        interactor.execute(inputData);
    }
}
