/*
 * Created by JFormDesigner on Wed Nov 27 23:42:47 EST 2024
 */

package view.user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import interface_adapter.user.update_my_profile.UpdateMyProfileController;
import interface_adapter.user.update_my_profile.UpdateMyProfileState;
import interface_adapter.user.update_my_profile.UpdateMyProfileViewModel;

/**
 * The.
 * @author webster
 */
public class UpdateProfileView extends JDialog implements PropertyChangeListener {
    private final String viewName = "update profile";

    private final UpdateMyProfileViewModel updateMyProfileViewModel;
    private final UpdateMyProfileController updateMyProfileController;

    public UpdateProfileView(Window owner, UpdateMyProfileViewModel updateMyProfileViewModel, UpdateMyProfileController updateMyProfileController) {
        super(owner);
        this.updateMyProfileViewModel = updateMyProfileViewModel;
        this.updateMyProfileController = updateMyProfileController;

        this.updateMyProfileViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label2 = new JLabel();
        textField1 = new JTextField();
        label3 = new JLabel();
        textField2 = new JTextField();
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
            final int tt = 12;
            dialogPane.setBorder(new EmptyBorder(tt, tt, tt, tt));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
                .border.EmptyBorder(0, 0, 0, 0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",
                    javax.swing.border.TitledBorder
                .CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font ("Dia\u006cog", java
                    .awt.Font.BOLD, tt), java.awt.Color.red), dialogPane.getBorder()));
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("bord\u0065r".equals (e.getPropertyName())) throw new RuntimeException();
                }
            }
            );
            dialogPane.setLayout(new BorderLayout());

            // ======== contentPanel ========
            {
                final double ss = 1.0E-4;
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, ss};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, ss};

                final int fi = 5;
                final int fo = 4;
                final int ni = 9;
                final int ten = 10;
                final int ele = 11;
                // ---- label2 ----
                label2.setText("Telephone:");
                contentPanel.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(fo, fo, fi, ni), 0, 0));
                contentPanel.add(textField1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(fi, 0, fi, fo), 0, 0));

                final float ff = 4f;
                // ---- label3 ----
                label3.setText("Update profile");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + ff));
                contentPanel.add(label3, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(ten, fo, ele, fo), 0, 0));
                contentPanel.add(textField2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(fi, 0, fi, fo), 0, 0));

                // ---- label5 ----
                label5.setText("Email:");
                contentPanel.add(label5, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(fo, fo, fi, ni), 0, 0));

                // ---- label4 ----
                final int kl = 0xb3261e;
                final int hre = 3;
                label4.setText("Error Message");
                label4.setForeground(new Color(kl));
                label4.setVisible(false);
                contentPanel.add(label4, new GridBagConstraints(0, hre, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, fo, 0, fo), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            // ======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                // ---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancel(e));

                // ---- okButton ----
                okButton.setText("Continue");
                okButton.addActionListener(e -> updateProfile(e));

                final int fii = 5;
                final int tll = 251;
                final GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addContainerGap(tll, Short.MAX_VALUE)
                            .addComponent(cancelButton)
                            .addGap(fii, fii, fii)
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
        setSize(450, 220);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label2;
    private JTextField textField1;
    private JLabel label3;
    private JTextField textField2;
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
        final String email = state.getEmail();
        final String telephone = state.getTelephone();
        final String updateProfileError = state.getUpdateProfileError();
        if (updateProfileError != null) {
            label4.setText(updateProfileError);
            label4.setVisible(true);
        } else {
            label4.setVisible(false);
        }

        textField1.setText(email);
        textField2.setText(telephone);
    }

    private void close() {
        textField1.setText("");
        textField2.setText("");
        dispose();
    }

    private void cancel(ActionEvent e) {
        close();
    }

    private void updateProfile(ActionEvent e) {
        final String telephone = textField1.getText();
        final String email = textField2.getText();

        updateMyProfileController.execute(telephone, email);
        close();
    }
}
