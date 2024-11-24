package applications;

import applications.ConsoleSearchPresenter;
import data_access.book.InMemoryItemsBookDataAccessObject;
import org.springframework.web.client.RestTemplate;
import use_case.book.search.*;

public class SearchBookByIdApplication {

    public static void main(String[] args) {
        SearchBookDataAccessInterface dataAccess = new InMemoryItemsBookDataAccessObject(new RestTemplate());
        SearchOutputBoundary presenter = new ConsoleSearchPresenter();
        SearchInputBoundary interactor = new SearchInteractor(dataAccess, presenter);

        String keyword = "Genshin Impact";
        SearchInputData inputData = new SearchInputData(keyword, null, null, null, null, 0, 10);
        interactor.execute(inputData);
    }
}
