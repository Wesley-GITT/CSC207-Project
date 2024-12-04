/*
 * Created by JFormDesigner on Wed Nov 27 22:20:17 EST 2024
 */

package view.user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.zip.ZipEntry;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import interface_adapter.user.update_pwd.UpdatePasswordController;
import interface_adapter.user.update_pwd.UpdatePasswordState;
import interface_adapter.user.update_pwd.UpdatePasswordViewModel;

/** UpdatePwdView.
 * @author webster
 */
public class UpdatePwdView extends JDialog implements PropertyChangeListener {

    private final String viewName = "update password";

    private final UpdatePasswordViewModel updatePasswordViewModel;
    private final UpdatePasswordController updatePasswordController;

    public UpdatePwdView(Window owner, UpdatePasswordViewModel updatePasswordViewModel,
                         UpdatePasswordController updatePasswordController) {
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

        // ======== this ========
        setResizable(false);
        final var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // ======== dialogPane ========
        {
            final int zero = 0;
            final int twelve = 12;
            final double dzero = 0.0;
            final int one = 1;
            final int four = 4;
            dialogPane.setBorder(new EmptyBorder(twelve, twelve, twelve, twelve));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(
                    new javax.swing.border.EmptyBorder(zero, zero, zero, zero),
                    "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax.swing.border.TitledBorder
                    .CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dia\u006cog",
                    java.awt.Font.BOLD, twelve), java.awt.Color.red), dialogPane.getBorder()));
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("\u0062ord\u0065r".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });
            dialogPane.setLayout(new BorderLayout());

            // ======== contentPanel ========
            {
                final int five = 5;
                final int two = 2;
                final int three = 3;
                final int nine = 9;
                final double done = 1.0;
                final double magic = 1.0E-4;
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] {zero, zero, zero};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] {zero, zero, zero, zero, zero, zero};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] {dzero, done, magic};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] {dzero, dzero, dzero, dzero,
                        dzero, magic};
                contentPanel.add(passwordField1, new GridBagConstraints(one, one, one, one, dzero, dzero,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(five, zero, five, four), zero, zero));

                // ---- label1 ----
                label1.setText("Old Password:");
                contentPanel.add(label1, new GridBagConstraints(zero, one, one, one, dzero, dzero,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(four, four, five, nine), zero, zero));

                // ---- label2 ----
                label2.setText("New Password:");
                contentPanel.add(label2, new GridBagConstraints(zero, two, one, one, dzero, dzero,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(four, four, five, nine), zero, zero));
                contentPanel.add(passwordField2, new GridBagConstraints(one, two, one, one, dzero, dzero,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(five, zero, five, four), zero, zero));

                // ---- label3 ----
                final int ten = 10;
                final int eleven = 11;
                final float fourf = 4f;
                label3.setText("Change your password");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD,
                        label3.getFont().getSize() + fourf));
                contentPanel.add(label3, new GridBagConstraints(zero, zero, two, one, dzero, dzero,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(ten, four, eleven, four), zero, zero));
                contentPanel.add(passwordField3, new GridBagConstraints(one, three, one, one, dzero, dzero,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(five, zero, five, four), zero, zero));

                // ---- label5 ----
                label5.setText("Confirm Password:");
                contentPanel.add(label5, new GridBagConstraints(zero, three, one, one, dzero, dzero,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(four, four, five, nine), zero, zero));

                // ---- label4 ----
                label4.setText("Error Message");
                final int mag1 = 0xb3261e;
                label4.setForeground(new Color(mag1));
                label4.setVisible(false);
                contentPanel.add(label4, new GridBagConstraints(zero, four, two, one, dzero, dzero,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(zero, four, zero, four), zero, zero));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            // ======== buttonBar ========
            {
                final int five = 5;
                buttonBar.setBorder(new EmptyBorder(twelve, zero, zero, zero));

                // ---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancel(e));

                // ---- okButton ----
                okButton.setText("Continue");
                okButton.addActionListener(e -> updatePassword(e));

                final GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                final int gapNum = 251;
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                        buttonBarLayout.createParallelGroup()
                                .addGroup(buttonBarLayout.createSequentialGroup()
                                        .addContainerGap(gapNum, Short.MAX_VALUE)
                                        .addComponent(cancelButton)
                                        .addGap(five, five, five)
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
        final int s1 = 450;
        final int s2 = 300;
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(s1, s2);
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
        final UpdatePasswordState state = (UpdatePasswordState) evt.getNewValue();
        final String updateProfileError = state.getUpdatePasswordError();
        if (updateProfileError != null) {
            label4.setText(updateProfileError);
            label4.setVisible(true);
        }
        else {
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
    }
}
