package interface_adapter.user.reg;

import interface_adapter.ViewModel;

/**
 * The View Model for the Login View.
 */
public class RegViewModel extends ViewModel<RegState> {

    public RegViewModel() {
        super("registration");
        setState(new RegState());
    }

}
