package interface_adapter.book.view;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.book.view.ViewBookOutputBoundary;
import use_case.book.view.ViewBookOutputData;

/**
 * The Presenter for the Login Use Case.
 */
public class BookPresenter implements ViewBookOutputBoundary {

    private final BookViewModel bookViewModel;
    private final ViewManagerModel viewManagerModel;

    public BookPresenter(BookViewModel bookViewModel, ViewManagerModel viewManagerModel) {
        this.bookViewModel = bookViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(ViewBookOutputData response) {
        final BookState state = bookViewModel.getState();
        state.setId(response.getId());
        state.setTitle(response.getTitle());
        state.setAuthors(response.getAuthors());
        state.setImageUrl(response.getImageUrl());
        state.setLanguage(response.getLanguage());
        state.setDescription(response.getDescription());
        state.setPublisher(response.getPublisher());
        state.setPublishedDate(response.getPublishedDate());
        bookViewModel.firePropertyChanged();

        final ViewManagerState managerState = viewManagerModel.getState();
        managerState.setViewName("view book");
        bookViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final BookState state = bookViewModel.getState();
        state.setViewBookError(error);
        bookViewModel.firePropertyChanged();
    }
}
