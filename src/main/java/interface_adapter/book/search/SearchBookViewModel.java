package interface_adapter.book.search;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class SearchBookViewModel extends ViewModel<SearchBookState> {

    public SearchBookViewModel() {
        super("search book");
        setState(new SearchBookState());
    }

}
