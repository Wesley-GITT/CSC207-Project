package use_case.book.view;

import data_access.book.InMemoryBookDataAccessObject;
import entity.BookFactory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ViewBookInteractorTest {

    @Test
    public void successViewBookTest() {
        ViewBookInputData inputData = new ViewBookInputData("test1");
        InMemoryBookDataAccessObject bookRepo = new InMemoryBookDataAccessObject();

        BookFactory bookFactory = new BookFactory();
        bookRepo.save(bookFactory.create("test1", "haha"));

        ViewBookOutputBoundary successPresenter = new ViewBookOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewBookOutputData outputData) {
                assertEquals("haha", outputData.getTitle());
            }

            @Override
            public void prepareFailView(String errorMessage) {
                fail("Use case failure is unexpected");
            }
        };

        ViewBookInteractor interactor = new ViewBookInteractor(bookRepo, successPresenter);
        interactor.execute(inputData);
    }

    @Test
    public void failureBookNotExistTest() {
        ViewBookInputData inputData = new ViewBookInputData("test2");
        InMemoryBookDataAccessObject bookRepo = new InMemoryBookDataAccessObject();

        BookFactory bookFactory = new BookFactory();
        bookRepo.save(bookFactory.create("test1", "haha"));

        ViewBookOutputBoundary successPresenter = new ViewBookOutputBoundary() {
            @Override
            public void prepareSuccessView(ViewBookOutputData outputData) {
                fail("Use case success is unexpected");
            }

            @Override
            public void prepareFailView(String errorMessage) {
                assertEquals("Book with ID `test2` doesn't exist", errorMessage);
            }
        };

        ViewBookInteractor interactor = new ViewBookInteractor(bookRepo, successPresenter);
        interactor.execute(inputData);
    }
}
