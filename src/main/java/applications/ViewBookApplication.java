package applications;

import applications.ConsoleViewBookPresenter;
import data_access.book.InMemoryItemsBookDataAccessObject;
import org.springframework.web.client.RestTemplate;
import use_case.book.viewsearchbook.*;

public class ViewBookApplication {

    public static void main(String[] args) {
        ViewBookDataAccessInterface dataAccess = new InMemoryItemsBookDataAccessObject(new RestTemplate());
        ViewBookOutputBoundary presenter = new ConsoleViewBookPresenter();
        ViewBookInputBoundary interactor = new ViewBookInteractor(dataAccess, presenter);

        String bookId = "YOUR_BOOK_ID_HERE";
        ViewBookInputData inputData = new ViewBookInputData(bookId);
        interactor.execute(inputData);
    }
}
