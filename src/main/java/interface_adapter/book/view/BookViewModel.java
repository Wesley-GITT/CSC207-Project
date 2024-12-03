package interface_adapter.book.view;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class BookViewModel extends ViewModel<BookState> {

    public BookViewModel() {
        super("view book");
        setState(new BookState());
    }

}
