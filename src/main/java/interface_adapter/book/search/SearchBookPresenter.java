package interface_adapter.book.search;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.book.search.SearchBookOutputBoundary;
import use_case.book.search.SearchBookOutputData;

import java.util.List;

/**
 * The Presenter for the Login Use Case.
 */
public class SearchBookPresenter implements SearchBookOutputBoundary {

    private final SearchBookViewModel searchBookViewModel;
    private final ViewManagerModel viewManagerModel;

    public SearchBookPresenter(SearchBookViewModel searchBookViewModel, ViewManagerModel viewManagerModel) {
        this.searchBookViewModel = searchBookViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView(SearchBookOutputData response) {
        final int startIndex = response.getStartIndex();
        final int endIndex = response.getEndIndex();
        final List<String> bookIds = response.getBookIds();
        final SearchBookState state = searchBookViewModel.getState();

        state.setBookIds(bookIds);
        state.setStartIndex(startIndex);
        state.setEndIndex(endIndex);
        searchBookViewModel.firePropertyChanged();

        final ViewManagerState managerState = viewManagerModel.getState();
        managerState.setViewName("search book");
        searchBookViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        final SearchBookState state = searchBookViewModel.getState();
        state.setSearchBookError(error);
        searchBookViewModel.firePropertyChanged();
    }
}
