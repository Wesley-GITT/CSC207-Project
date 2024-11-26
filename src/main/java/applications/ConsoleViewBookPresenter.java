package applications;

import entity.Book;
import use_case.book.viewsearchbook.ViewBookOutputBoundary;
import use_case.book.viewsearchbook.ViewBookOutputData;

public class ConsoleViewBookPresenter implements ViewBookOutputBoundary {

    @Override
    public void prepareSuccessView(ViewBookOutputData outputData) {
        Book book = outputData.getBook();
        System.out.println("Book Details:");
        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author(s): " + book.getAuthor());
        System.out.println("Publisher: " + book.getPublisher());
        System.out.println("Published Date: " + book.getPublishedDate());
        System.out.println("Description: " + book.getDescription());
        System.out.println("Language: " + book.getLanguage());
        System.out.println("Genre: " + book.getGenre());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Seller: " + book.getSeller());
    }

    @Override
    public void prepareFailView(String errorMessage) {
        System.err.println("Error: " + errorMessage);
    }
}
