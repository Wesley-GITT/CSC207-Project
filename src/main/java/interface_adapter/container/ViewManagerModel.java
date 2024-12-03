package interface_adapter.container;

import interface_adapter.ViewModel;

/**
 * Model for the View Manager. Its state is the name of the View which
 * is currently active. An initial state of "" is used.
 */
public class ViewManagerModel extends ViewModel<ViewManagerState> {

    public ViewManagerModel() {
        super("View Manager");
        this.setState(new ViewManagerState());
    }
}
