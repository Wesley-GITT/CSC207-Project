package applications;

import entity.Book;
import use_case.book.search.SearchOutputBoundary;
import use_case.book.search.SearchOutputData;

import java.util.List;

public class ConsoleSearchPresenter implements SearchOutputBoundary {

    @Override
    public void prepareSuccessView(SearchOutputData outputData) {
        List<Book> books = outputData.getBooks();
        System.out.println("Search Results:");
        for (Book book : books) {
            System.out.println("ID: " + book.getId());
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author(s): " + book.getAuthor());
            System.out.println("-------------------------");
        }
    }

    @Override
    public void prepareFailView(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }
}
