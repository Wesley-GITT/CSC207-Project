/*
 * Created by JFormDesigner on Wed Nov 27 22:20:17 EST 2024
 */

package view.user;

import interface_adapter.user.update_my_profile.UpdateMyProfileState;
import interface_adapter.user.update_pwd.UpdatePasswordController;
import interface_adapter.user.update_pwd.UpdatePasswordViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author webster
 */
public class UpdatePwdView extends JDialog implements PropertyChangeListener {

    private final String viewName = "update password";

    private final UpdatePasswordViewModel updatePasswordViewModel;
    private final UpdatePasswordController updatePasswordController;

    public UpdatePwdView(Window owner, UpdatePasswordViewModel updatePasswordViewModel, UpdatePasswordController updatePasswordController) {
        super(owner);
        this.updatePasswordViewModel = updatePasswordViewModel;
        this.updatePasswordController = updatePasswordController;

        this.updatePasswordViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        passwordField1 = new JPasswordField();
        label1 = new JLabel();
        label2 = new JLabel();
        passwordField2 = new JPasswordField();
        label3 = new JLabel();
        passwordField3 = new JPasswordField();
        label5 = new JLabel();
        label4 = new JLabel();
        buttonBar = new JPanel();
        cancelButton = new JButton();
        okButton = new JButton();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border
            . EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax
            . swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,
            12 ), java. awt. Color. red) ,dialogPane. getBorder( )) ); dialogPane. addPropertyChangeListener (new java. beans
            . PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .
            getPropertyName () )) throw new RuntimeException( ); }} );
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                contentPanel.add(passwordField1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(5, 0, 5, 4), 0, 0));

                //---- label1 ----
                label1.setText("Old Password:");
                contentPanel.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(4, 4, 5, 9), 0, 0));

                //---- label2 ----
                label2.setText("New Password:");
                contentPanel.add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(4, 4, 5, 9), 0, 0));
                contentPanel.add(passwordField2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(5, 0, 5, 4), 0, 0));

                //---- label3 ----
                label3.setText("Change your password");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 4f));
                contentPanel.add(label3, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(10, 4, 11, 4), 0, 0));
                contentPanel.add(passwordField3, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(5, 0, 5, 4), 0, 0));

                //---- label5 ----
                label5.setText("Confirm Password:");
                contentPanel.add(label5, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(4, 4, 5, 9), 0, 0));

                //---- label4 ----
                label4.setText("Error Message");
                label4.setForeground(new Color(0xb3261e));
                label4.setVisible(false);
                contentPanel.add(label4, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 4, 0, 4), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancel(e));

                //---- okButton ----
                okButton.setText("Continue");
                okButton.addActionListener(e -> updatePassword(e));

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addContainerGap(251, Short.MAX_VALUE)
                            .addComponent(cancelButton)
                            .addGap(5, 5, 5)
                            .addComponent(okButton)
                            .addContainerGap())
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(okButton))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(450, 255);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:on
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPasswordField passwordField1;
    private JLabel label1;
    private JLabel label2;
    private JPasswordField passwordField2;
    private JLabel label3;
    private JPasswordField passwordField3;
    private JLabel label5;
    private JLabel label4;
    private JPanel buttonBar;
    private JButton cancelButton;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


    public String getViewName() {
        return viewName;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final UpdateMyProfileState state = (UpdateMyProfileState) evt.getNewValue();
        final String updateProfileError = state.getUpdateProfileError();
        if (updateProfileError != null) {
            label4.setText(updateProfileError);
            label4.setVisible(true);
        } else {
            label4.setVisible(false);
        }
    }

    private void close() {
        passwordField1.setText("");
        passwordField2.setText("");
        passwordField3.setText("");
        dispose();
    }

    private void cancel(ActionEvent e) {
        close();
    }

    private void updatePassword(ActionEvent e) {
        final String oldPassword = String.valueOf(passwordField1.getPassword());
        final String newPassword1 = String.valueOf(passwordField2.getPassword());
        final String newPassword2 = String.valueOf(passwordField3.getPassword());

        updatePasswordController.execute(oldPassword, newPassword1, newPassword2);
        close();
    }
}
