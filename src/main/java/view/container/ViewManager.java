/*
 * Created by JFormDesigner on Mon Dec 02 16:16:09 EST 2024
 */

package view.container;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import interface_adapter.user.logout.LogoutController;
import interface_adapter.user.logout.LogoutPresenter;
import interface_adapter.user.logout.LogoutViewModel;
import use_case.user.logout.LogoutInteractor;
import view.book.BookView;
import view.book.SearchBookView;
import view.product.EditProductView;
import view.product.ListProductView;
import view.user.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.HashMap;
import java.util.Map;

/**
 * @author webster
 */
public class ViewManager extends JFrame implements PropertyChangeListener {

    private final Map<String, JDialog> dialogues;
    // - Dialogues contains:
    // - AuthView authView
    // - RegView regView
    // - UpdateNameView updateNameView
    // - UpdateProfileView updateProfileView
    // - UpdatePwdView updatePwdView
    // - EditProductView editProductView

    // Panels
    private ProfileView profileView;
    private WishlistView wishlistView;
    private ListProductView listProductView;
    private SearchBookView searchBookView;
    private BookView bookView;

    // ViewModel
    private final LogoutViewModel logoutViewModel;
    private final LogoutController logoutController;
    private final ViewManagerModel viewManagerModel;

    public ViewManager(ViewManagerModel viewManagerModel) {

        this.viewManagerModel = viewManagerModel;
        this.logoutViewModel = new LogoutViewModel();
        this.logoutController = new LogoutController(new LogoutInteractor(new LogoutPresenter(viewManagerModel)));
        this.dialogues = new HashMap<>();

        initComponents();

        this.viewManagerModel.addPropertyChangeListener(this);
    }

    public void setViews(AuthView authView, RegView regView, UpdateNameView updateNameView, UpdateProfileView updateProfileView,
                         UpdatePwdView updatePwdView, EditProductView editProductView, ProfileView profileView,
                         WishlistView wishlistView, ListProductView listProductView, SearchBookView searchBookView,
                         BookView bookView){


        this.profileView = profileView;
        this.wishlistView = wishlistView;
        this.listProductView = listProductView;
        this.searchBookView = searchBookView;
        this.bookView = bookView;

        // put these JPanel into top-level JPanel
        panel2.add(profileView.getViewName(), profileView);
        panel2.add(wishlistView.getViewName(), wishlistView);
        panel2.add(listProductView.getViewName(), listProductView);
        panel2.add(searchBookView.getViewName(), searchBookView);
        panel2.add(bookView.getViewName(), bookView);

        this.dialogues.put(authView.getViewName(), authView);
        this.dialogues.put(regView.getViewName(), regView);
        this.dialogues.put(updateNameView.getViewName(), updateNameView);
        this.dialogues.put(updateProfileView.getViewName(), updateProfileView);
        this.dialogues.put(updatePwdView.getViewName(), updatePwdView);
        this.dialogues.put(editProductView.getViewName(), editProductView);
    }

    private void searchMenuItemClicked(ActionEvent e) {
        ViewManagerState state = viewManagerModel.getState();
        state.setViewName("search book");
        viewManagerModel.firePropertyChanged();
    }

    private void signInMenuItemClicked(ActionEvent e) {
        ViewManagerState state = viewManagerModel.getState();
        state.setPopupName("authentication");
        viewManagerModel.firePropertyChanged();
    }

    private void signOutMenuItemClicked(ActionEvent e) {
        logoutController.execute();
    }

    private void profileMenuItemClicked(ActionEvent e) {
        ViewManagerState state = viewManagerModel.getState();
        state.setViewName("my profile");
        viewManagerModel.firePropertyChanged();
    }

    private void wishlistMenuItemClicked(ActionEvent e) {
        ViewManagerState state = viewManagerModel.getState();
        state.setViewName("my wishlist");
        viewManagerModel.firePropertyChanged();
    }

    private void myProductMenuItemClicked(ActionEvent e) {
        ViewManagerState state = viewManagerModel.getState();
        state.setViewName("my wishlist");
        viewManagerModel.firePropertyChanged();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        menuBar1 = new JMenuBar();
        menu2 = new JMenu();
        menuItem2 = new JMenuItem();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem4 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem8 = new JMenuItem();
        panel2 = new JPanel();

        //======== this ========
        setMinimumSize(new Dimension(600, 450));
        var contentPane = getContentPane();
        contentPane.setLayout(new CardLayout());

        //======== menuBar1 ========
        {

            //======== menu2 ========
            {
                menu2.setText("Navigation");

                //---- menuItem2 ----
                menuItem2.setText("Search");
                menuItem2.setAlignmentX(0.0F);
                menuItem2.setMargin(new Insets(3, -6, 3, 0));
                menuItem2.setIconTextGap(0);
                menuItem2.addActionListener(e -> searchMenuItemClicked(e));
                menu2.add(menuItem2);
            }
            menuBar1.add(menu2);

            //======== menu1 ========
            {
                menu1.setText("Account");

                //---- menuItem1 ----
                menuItem1.setText("Sign in/up");
                menuItem1.setAlignmentX(0.0F);
                menuItem1.setMargin(new Insets(3, -6, 3, 0));
                menuItem1.setIconTextGap(0);
                menuItem1.addActionListener(e -> signInMenuItemClicked(e));
                menu1.add(menuItem1);

                //---- menuItem5 ----
                menuItem5.setText("Sign out");
                menuItem5.setAlignmentX(0.0F);
                menuItem5.setMargin(new Insets(3, -6, 3, 0));
                menuItem5.setIconTextGap(0);
                menuItem5.addActionListener(e -> signOutMenuItemClicked(e));
                menu1.add(menuItem5);

                //---- menuItem4 ----
                menuItem4.setText("Profile");
                menuItem4.setAlignmentX(0.0F);
                menuItem4.setMargin(new Insets(3, -6, 3, 0));
                menuItem4.setIconTextGap(0);
                menuItem4.addActionListener(e -> profileMenuItemClicked(e));
                menu1.add(menuItem4);

                //---- menuItem6 ----
                menuItem6.setText("Wishlist");
                menuItem6.setAlignmentX(0.0F);
                menuItem6.setMargin(new Insets(3, -6, 3, 0));
                menuItem6.setIconTextGap(0);
                menuItem6.addActionListener(e -> wishlistMenuItemClicked(e));
                menu1.add(menuItem6);

                //---- menuItem8 ----
                menuItem8.setText("My Product");
                menuItem8.setIconTextGap(0);
                menuItem8.setMargin(new Insets(3, -6, 3, 6));
                menuItem8.addActionListener(e -> myProductMenuItemClicked(e));
                menu1.add(menuItem8);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //======== panel2 ========
        {
            panel2.setMinimumSize(new Dimension(600, 360));
            panel2.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .
            EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing
            . border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,
            java . awt. Color .red ) ,panel2. getBorder () ) ); panel2. addPropertyChangeListener( new java. beans .PropertyChangeListener ( )
            { @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )
            throw new RuntimeException( ) ;} } );
            panel2.setLayout(new CardLayout());
        }
        contentPane.add(panel2, "card1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JMenuBar menuBar1;
    private JMenu menu2;
    private JMenuItem menuItem2;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem5;
    private JMenuItem menuItem4;
    private JMenuItem menuItem6;
    private JMenuItem menuItem8;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void showDialogue(String dialogName) {
        for (String key: dialogues.keySet()) {
            if (key.equals(dialogName)) {
                dialogues.get(key).setVisible(true);
            } else {
                dialogues.get(key).setVisible(false);
            }
        }
    }

    private void disablePrivateViews() {
        menuItem1.setEnabled(true);
        menuItem5.setEnabled(false);
        menuItem4.setEnabled(false);
        menuItem6.setEnabled(false);
        menuItem8.setEnabled(false);
    }

    private void enablePrivateViews() {
        menuItem1.setEnabled(false);
        menuItem5.setEnabled(true);
        menuItem4.setEnabled(true);
        menuItem6.setEnabled(true);
        menuItem8.setEnabled(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final ViewManagerState state = (ViewManagerState) evt.getNewValue();
        final String username = state.getUsername();
        final String password = state.getPassword();
        final String viewName = state.getViewName();
        final String popupName = state.getPopupName();
        final CardLayout cardLayout = (CardLayout) panel2.getLayout();
        
        // non empty viewName means to switch the view
        cardLayout.show(panel2, viewName);

        // clear pop-up name
        showDialogue(popupName);
        state.setPopupName("");

        if (!username.equals("") && !password.equals("")) {
            enablePrivateViews();
        } else {
            disablePrivateViews();
        }
    }
}
