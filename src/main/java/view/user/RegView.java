/*
 * Created by JFormDesigner on Wed Nov 27 19:06:40 EST 2024
 */

package view.user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import interface_adapter.user.reg.RegController;
import interface_adapter.user.reg.RegState;
import interface_adapter.user.reg.RegViewModel;

/**
 * The .
 * @author Jing Wei
 */
public class RegView extends JDialog implements PropertyChangeListener {

    private final String viewName = "registration";

    private final RegViewModel regViewModel;
    private final RegController regController;

    public RegView(Window owner, RegViewModel regViewModel, RegController regController) {
        super(owner);
        this.regViewModel = regViewModel;
        this.regController = regController;

        this.regViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        textField1 = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        passwordField1 = new JPasswordField();
        label3 = new JLabel();
        passwordField2 = new JPasswordField();
        label5 = new JLabel();
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
            final int tw = 12;
            dialogPane.setBorder(new EmptyBorder(tw, tw, tw, tw));
            dialogPane.setBorder (new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder
                    (new javax.swing.border.EmptyBorder(0, 0, 0, 0) ,
                            "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",
                            javax.swing.border.TitledBorder.CENTER,
                            javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font ("Dia\u006cog",java.awt.Font
                            .BOLD, tw), java.awt.Color.red), dialogPane.getBorder()));
            dialogPane.addPropertyChangeListener(new java. beans. PropertyChangeListener() {
                @Override public void propertyChange(java.beans.PropertyChangeEvent e) {
                    if ("\u0062ord\u0065r".equals (e.getPropertyName())) throw new RuntimeException();
                }
            }
            );
            dialogPane.setLayout(new BorderLayout());

            // ======== contentPanel ========
            {
                final int ii = 97;
                final double nn = 1.0E-4;
                final int fi = 5;
                final int fo = 4;
                final int nne = 9;
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] {ii, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, nn};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 0.0, nn};
                contentPanel.add(textField1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(fi, 0, fi, fo), 0, 0));

                // ---- label1 ----
                label1.setText("Username:");
                contentPanel.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(fo, fo, fi, nne), 0, 0));

                // ---- label2 ----
                label2.setText("Password:");
                contentPanel.add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(fo, fo, fi, nne), 0, 0));
                contentPanel.add(passwordField1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(fi, 0, fi, fo), 0, 0));

                final int te = 10;
                final int ll = 11;
                final int thre = 3;
                final float qq = 4f;
                // ---- label3 ----
                label3.setText("Create an account.");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD,
                        label3.getFont().getSize() + qq));
                contentPanel.add(label3, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(te, fo, ll, fo), 0, 0));
                contentPanel.add(passwordField2, new GridBagConstraints(1, thre, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(fi, 0, fi, fo), 0, 0));

                // ---- label5 ----
                label5.setText("Confirm Password:");
                contentPanel.add(label5, new GridBagConstraints(0, thre, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(fo, fo, fi, nne), 0, 0));

                final int kl = 0xb3261e;
                // ---- label4 ----
                label4.setText("Error Message");
                label4.setForeground(new Color(kl));
                label4.setVisible(false);
                contentPanel.add(label4, new GridBagConstraints(0, fo, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, fo, 0, fo), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            // ======== buttonBar ========
            {
                final int we = 12;
                buttonBar.setBorder(new EmptyBorder(we, 0, 0, 0));

                // ---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancel(e));

                // ---- okButton ----
                okButton.setText("Continue");
                okButton.addActionListener(e -> signup(e));

                // ---- button1 ----
                button1.setText("Sign In");
                button1.addActionListener(e -> switchToSignIn(e));

                final GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                final int uu = 5;
                final int err = 177;
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addComponent(button1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, err, Short.MAX_VALUE)
                            .addComponent(cancelButton)
                            .addGap(uu, uu, uu)
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
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(450, 285);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY // GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JLabel label3;
    private JPasswordField passwordField2;
    private JLabel label5;
    private JLabel label4;
    private JPanel buttonBar;
    private JButton cancelButton;
    private JButton okButton;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final RegState state = (RegState) evt.getNewValue();
        final String signupError = state.getRegisterError();
        if (signupError != null) {
            label4.setText(signupError);
            label4.setVisible(true);
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
        passwordField2.setText("");
        dispose();
    }

    private void cancel(ActionEvent e) {
        close();
    }

    private void signup(ActionEvent e) {
        final String username = textField1.getText();
        final String password1 = String.valueOf(passwordField1.getPassword());
        final String password2 = String.valueOf(passwordField2.getPassword());

        regController.execute(username, password1, password2);
    }

    private void switchToSignIn(ActionEvent e) {
        regController.switchToSignIn();
        close();
    }
}
