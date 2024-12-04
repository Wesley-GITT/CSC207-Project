package interface_adapter.user.logout;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import use_case.user.logout.LogoutOutputBoundary;

/**
 * The Presenter for the Login Use Case.
 */
public class LogoutPresenter implements LogoutOutputBoundary {

    private final ViewManagerModel viewManagerModel;

    public LogoutPresenter(ViewManagerModel viewManagerModel) {
        this.viewManagerModel = viewManagerModel;
    }

//    @Override
//    public void prepareSuccessView() {
//        // clear username and password and go home if inside user personal page
//        String viewName = this.viewManagerModel.getState().getViewName();
//        if (viewName.equals("my profile") || viewName.equals("wishlist")) {
//            viewName = "home";
//        }
//
//        ViewManagerState state = viewManagerModel.getState();
//        state.setViewName(viewName);
//        viewManagerModel.firePropertyChanged();
//    }
    @Override
    public void prepareSuccessView() {
        // Clear username and password and navigate to the "home" view
        ViewManagerState state = viewManagerModel.getState();
        state.setUsername("");
        state.setPassword("");
        state.setViewName("home"); // Always navigate to "home"
        viewManagerModel.firePropertyChanged();
    }
}
