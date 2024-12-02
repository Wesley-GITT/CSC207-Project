package interface_adapter.MainPage;

import interface_adapter.ViewModel;

/**
 * The View Model for the Main View.
 */
public class MainPageViewModel extends ViewModel<MainPageState> {

    public MainPageViewModel() {
        super("Main Page");
        setState(new MainPageState());
    }

}
