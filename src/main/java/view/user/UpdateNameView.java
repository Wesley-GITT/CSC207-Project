/*
 * Created by JFormDesigner on Wed Nov 27 23:46:18 EST 2024
 */

package view.user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import interface_adapter.user.update_name.UpdateNameController;
import interface_adapter.user.update_name.UpdateNameState;
import interface_adapter.user.update_name.UpdateNameViewModel;

/**
 * The .
 * @author webster
 */
public class UpdateNameView extends JDialog implements PropertyChangeListener {

    private final String viewName = "update username";

    private final UpdateNameViewModel updateNameViewModel;
    private final UpdateNameController updateNameController;

    public UpdateNameView(Window owner, UpdateNameViewModel updateNameViewModel, UpdateNameController updateNameController) {
        super(owner);
        this.updateNameViewModel = updateNameViewModel;
        this.updateNameController = updateNameController;

        this.updateNameViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        textField1 = new JTextField();
        label1 = new JLabel();
        label3 = new JLabel();
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
            final int tw = 12;
            dialogPane.setBorder(new EmptyBorder(tw, tw, tw, tw));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border
                    .EmptyBorder(0, 0, 0, 0) ,"JFor\u006dDesi\u0067ner \u0045valu\u0061tion",
                    javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, new java.awt
                    .Font("Dia\u006cog", java.awt.Font.BOLD, tw),
                    java.awt.Color.red), dialogPane.getBorder()));
            dialogPane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
                @Override public void propertyChange(java.beans .PropertyChangeEvent e) {if ("bord\u0065r" .equals(e.getPropertyName()))
                        throw new RuntimeException();
                }
            }
            );
            dialogPane.setLayout(new BorderLayout());

            // ======== contentPanel ========
            {
                final double ss = 1.0E-4;
                final int fo = 4;
                final int fi = 5;
                final int nne = 9;
                final int sx = 6;
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout) contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0};
                ((GridBagLayout) contentPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, ss};
                ((GridBagLayout) contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, ss};
                contentPanel.add(textField1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(fi, 0, fi, fo), 0, 0));

                // ---- label1 ----
                label1.setText("New username:");
                contentPanel.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(fo, fo, fi, nne), 0, 0));

                // ---- label3 ----
                label3.setText("Update Username");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 4f));
                contentPanel.add(label3, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(sx, fo, nne, fo), 0, 0));
                final int ss2 = 0xb3261e;
                // ---- label4 ----
                label4.setText("Error Message");
                label4.setForeground(new Color(ss2));
                label4.setVisible(false);
                contentPanel.add(label4, new GridBagConstraints(0, 2, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, fo, 0, fo), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            // ======== buttonBar ========
            {
                final int wr = 12;
                buttonBar.setBorder(new EmptyBorder(wr, 0, 0, 0));

                // ---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancel(e));

                // ---- okButton ----
                okButton.setText("Continue");
                okButton.addActionListener(e -> updateName(e));

                final GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
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
        final int ff = 450;
        final int gg = 180;
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(ff, gg);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:on
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label3;
    private JLabel label4;
    private JPanel buttonBar;
    private JButton cancelButton;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final UpdateNameState state = (UpdateNameState) evt.getNewValue();
        final String username = state.getUsername();
        final String updateNameError = state.getUpdateNameError();

        if (updateNameError != null) {
            label4.setText(updateNameError);
            label4.setVisible(true);
        } else {
            label4.setVisible(false);
        }

        textField1.setText(username);
    }

    private void close() {
        textField1.setText("");
        dispose();
    }

    private void cancel(ActionEvent e) {
        close();
    }

    private void updateName(ActionEvent e) {
        final String username = textField1.getText();
        updateNameController.execute(username);

        close();
    }

    public String getViewName() {
        return viewName;
    }
}
