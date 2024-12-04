/*
 * Created by JFormDesigner on Sun Dec 01 18:39:51 EST 2024
 */

package view.user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import interface_adapter.user.show_my_profile.ShowMyProfileController;
import interface_adapter.user.show_my_profile.ShowMyProfileState;
import interface_adapter.user.show_my_profile.ShowMyProfileViewModel;
import interface_adapter.user.update_my_profile.UpdateMyProfileState;
import interface_adapter.user.update_my_profile.UpdateMyProfileViewModel;
import interface_adapter.user.update_name.UpdateNameState;
import interface_adapter.user.update_name.UpdateNameViewModel;

/**
 * ProfileView.
 * @author webster
 */
public class ProfileView extends JPanel implements PropertyChangeListener {

    private final String viewName = "my profile";

    private final ShowMyProfileViewModel showMyProfileViewModel;
    private final ShowMyProfileController showMyProfileCotroller;
    private final UpdateNameViewModel updateNameViewModel;
    private final UpdateMyProfileViewModel updateMyProfileViewModel;
    private final ViewManagerModel viewManagerModel;

    public ProfileView(
            ShowMyProfileViewModel showMyProfileViewModel, ShowMyProfileController showMyProfileCotroller,
            UpdateNameViewModel updateNameViewModel, UpdateMyProfileViewModel updateMyProfileViewModel,
            ViewManagerModel viewManagerModel) {

        this.showMyProfileViewModel = showMyProfileViewModel;
        this.showMyProfileCotroller = showMyProfileCotroller;
        this.updateNameViewModel = updateNameViewModel;
        this.updateMyProfileViewModel = updateMyProfileViewModel;
        this.viewManagerModel = viewManagerModel;

        this.showMyProfileViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void thisComponentShown(ComponentEvent e) {
        showMyProfileCotroller.execute();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:on
        // Generated using JFormDesigner Evaluation license - Jing Wei
        label2 = new JLabel();
        label3 = new JLabel();
        button2 = new JButton();
        button3 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        button1 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(457, 450));
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                thisComponentShown(e);
            }
        });
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.
        border.EmptyBorder(0,0,0,0), "JF\u006frmDes\u0069gner \u0045valua\u0074ion",
                javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder.BOTTOM,
                new java.awt.Font("D\u0069alog",java.awt.Font.BOLD,12),
                java.awt.Color.red), getBorder())); addPropertyChangeListener
                (new java.beans.PropertyChangeListener()
                {@Override public void propertyChange(java.beans.PropertyChangeEvent e)
                {if("\u0062order".equals(e.getPropertyName()))throw new RuntimeException();}});
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};

        //---- label2 ----
        label2.setText("Basics");
        add(label2, new GridBagConstraints(0, 0, 1, 3, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 12, 16), 0, 0));

        //---- label3 ----
        label3.setText("Logged in as: <Username>");
        add(label3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 12, 16), 0, 0));

        //---- button2 ----
        button2.setText("Change Username");
        button2.addActionListener(e -> changeUsernameButtonClicked(e));
        add(button2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 12, 0), 0, 0));

        //---- button3 ----
        button3.setText("Change Password");
        button3.addActionListener(e -> changePasswordButtonClicked(e));
        add(button3, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 12, 0), 0, 0));

        //---- label1 ----
        label1.setText("My Profile");
        add(label1, new GridBagConstraints(0, 3, 1, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 12, 16), 0, 0));

        //---- textField1 ----
        textField1.setText("Email: <Email>");
        textField1.setEditable(false);
        add(textField1, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 0), 0, 0));

        //---- textField2 ----
        textField2.setText("Telephone: <Telephone>");
        textField2.setEditable(false);
        add(textField2, new GridBagConstraints(1, 4, 2, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 0), 0, 0));

        //---- button1 ----
        button1.setText("Edit my profile");
        button1.addActionListener(e -> editMyProfileButtonClicked(e));
        add(button1, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:on
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JLabel label2;
    private JLabel label3;
    private JButton button2;
    private JButton button3;
    private JLabel label1;
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void propertyChangeMyProfile(ShowMyProfileState state) {
        final String username = state.getUsername();
        final String email = state.getEmail();
        final String telephone = state.getTelephone();

        label3.setText("Logged in as: " + username);
        textField1.setText("Email: " + email);
        textField2.setText("Telephone: " + telephone);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        propertyChangeMyProfile((ShowMyProfileState) evt.getNewValue());
    }

    private void changePasswordButtonClicked(ActionEvent e) {
        final ViewManagerState state = viewManagerModel.getState();
        state.setPopupName("update password");
        viewManagerModel.firePropertyChanged();
    }

    private void changeUsernameButtonClicked(ActionEvent e) {
        final ShowMyProfileState state = showMyProfileViewModel.getState();
        final UpdateNameState newState = updateNameViewModel.getState();
        newState.setUsername(state.getUsername());
        updateMyProfileViewModel.firePropertyChanged();

        final ViewManagerState managerState = viewManagerModel.getState();
        managerState.setPopupName("update username");
        viewManagerModel.firePropertyChanged();
    }

    private void editMyProfileButtonClicked(ActionEvent e) {
        final ShowMyProfileState state = showMyProfileViewModel.getState();
        final UpdateMyProfileState newState = updateMyProfileViewModel.getState();
        newState.setTelephone(state.getTelephone());
        newState.setEmail(state.getEmail());
        updateMyProfileViewModel.firePropertyChanged();

        final ViewManagerState managerState = viewManagerModel.getState();
        managerState.setPopupName("update profile");
        viewManagerModel.firePropertyChanged();
    }


    public String getViewName() {
        return viewName;
    }
}
