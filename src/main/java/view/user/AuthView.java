/*
 * Created by JFormDesigner on Wed Nov 27 18:13:39 EST 2024
 */

package view.user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import interface_adapter.user.auth.AuthController;
import interface_adapter.user.auth.AuthState;
import interface_adapter.user.auth.AuthViewModel;

/**
 * JFormDesigner.
 * @author Jing Wei.
 */
public class AuthView extends JDialog implements PropertyChangeListener {

    private final String viewName = "authentication";

    private final AuthViewModel authViewModel;
    private final AuthController authController;

    public AuthView(Window owner, AuthViewModel authViewModel, AuthController authController) {
        super(owner);
        this.authViewModel = authViewModel;
        this.authController = authController;

        this.authViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        label3 = new JLabel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        label4 = new JLabel();
        buttonBar = new JPanel();
        cancelButton = new JButton();
        okButton = new JButton();
        button1 = new JButton();

        // ======== this ========
        setResizable(false);
        final var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        // ======== dialogPane ========
        {
            final int num = 12;
            dialogPane.setBorder(new EmptyBorder(num, num, num, num));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new
                    javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JF\u006frmDes\u0069gner \u0045valua\u0074ion", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("D\u0069alog",
                    java.awt.Font.BOLD, 12), java.awt.Color.red), dialogPane.getBorder()));
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("\u0062order".equals(e.getPropertyName())) throw new RuntimeException();
                }
            });
            dialogPane.setLayout(new BorderLayout());

            // ======== contentPanel ========
            {
                final int num1 = 0;
                final double double1 = 1.0E-4;
                final double double2 = 0.0;
                final double double3 = 1.0;
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] {num1, num1, num1};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] {num1, num1, num1, num1, num1};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] {double2, double3, double1};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[]
                        {double2, double2, double2, double2, double1};

                // ---- label3 ----
                final int ten = 10;
                final int two = 2;
                final int one = 1;
                final int four = 4;
                final int three = 3;
                final int six = 6;
                final int seven = 7;
                final int eight = 8;

                final float fourf = 4f;
                label3.setText("Sign in to your account.");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle()
                        | Font.BOLD, label3.getFont().getSize() + fourf));
                contentPanel.add(label3, new GridBagConstraints(num1, num1, two, one, double2, double2,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(ten, four, six, four), num1, num1));

                //---- label1 ----
                label1.setText("Username:");
                contentPanel.add(label1, new GridBagConstraints(num1, one, one, one, double2, double2,
                        GridBagConstraints.EAST, GridBagConstraints.NONE,
                        new Insets(seven, four, num1, four), num1, num1));
                contentPanel.add(textField1, new GridBagConstraints(one, one, one, one, double2, double2,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(eight, num1, num1, four), num1, num1));

                //---- label2 ----
                label2.setText("Password:");
                contentPanel.add(label2, new GridBagConstraints(num1, two, one, one, double2, double2,
                        GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                        new Insets(seven, four, num1, four), num1, num1));
                contentPanel.add(passwordField1, new GridBagConstraints(one, two, one, one, double2, double2,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(eight, num1, num1, four), num1, num1));

                //---- label4 ----
                final int magicnum = 0xb3261e;
                label4.setText("Error Message");
                label4.setForeground(new Color(magicnum));
                label4.setVisible(false);
                contentPanel.add(label4, new GridBagConstraints(num1, three, two, one, double2, double2,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(num1, six, four, four), num1, num1));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                final int zero = 0;
                final int five = 5;
                final int twelve = 12;
                final int num1 = 170;

                buttonBar.setBorder(new EmptyBorder(twelve, zero, zero, zero));

                // ---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancel(e));

                // ---- okButton ----
                okButton.setText("Continue");
                okButton.addActionListener(e -> signin(e));

                // ---- button1 ----
                button1.setText("Sign Up");
                button1.addActionListener(e -> switchToSignUp(e));

                final GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                        buttonBarLayout.createParallelGroup()
                                .addGroup(buttonBarLayout.createSequentialGroup()
                                        .addComponent(button1)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, num1, Short.MAX_VALUE)
                                        .addComponent(cancelButton)
                                        .addGap(five, five, five)
                                        .addComponent(okButton)
                                        .addContainerGap())
                );
                buttonBarLayout.setVerticalGroup(
                        buttonBarLayout.createParallelGroup()
                                .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(cancelButton)
                                        .addComponent(button1)
                                        .addComponent(okButton))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        final int num2 = 450;
        final int num3 = 255;
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(num2, num3);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:on
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JLabel label3;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JLabel label4;
    private JPanel buttonBar;
    private JButton cancelButton;
    private JButton okButton;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final AuthState state = (AuthState) evt.getNewValue();
        final String loginError = state.getLoginError();
        if (loginError != null) {
            label4.setVisible(true);
            label4.setText(loginError);
            return;
        }
        else {
            label4.setVisible(false);
        }
    }

    public String getViewName() {
        return viewName;
    }

    private void close() {
        textField1.setText("");
        passwordField1.setText("");
        dispose();
    }

    private void switchToSignUp(ActionEvent e) {
        authController.switchToSignUp();
        close();
    }

    private void cancel(ActionEvent e) {
        close();
    }

    private void signin(ActionEvent e) {
        final String username = textField1.getText();
        final String password = String.valueOf(passwordField1.getPassword());

        authController.execute(username, password);
    }
}