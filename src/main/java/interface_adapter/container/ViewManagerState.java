package interface_adapter.container;

public class ViewManagerState {

    private String username = "";
    private String password = "";
    private String viewName = "";
    private String popupName = "";

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getViewName() {
        return viewName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    public String getPopupName() {
        return popupName;
    }

    public void setPopupName(String popupName) {
        this.popupName = popupName;
    }
}
