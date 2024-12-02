/*
 * Created by JFormDesigner on Wed Nov 27 22:20:17 EST 2024
 */

package view.user;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * @author webster
 */
public class UpdatePwdView extends JDialog {
    public UpdatePwdView() {
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
        label4 = new JLabel();
        passwordField2 = new JPasswordField();
        label5 = new JLabel();
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
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
            .border.EmptyBorder(0,0,0,0), "JFor\u006dDesi\u0067ner \u0045valu\u0061tion",javax.swing.border.TitledBorder
            .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
            awt.Font.BOLD,12),java.awt.Color.red),dialogPane. getBorder()))
            ;dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
            ){if("bord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
            ;
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- label1 ----
                label1.setText("Old Password:");

                //---- label2 ----
                label2.setText("New Password:");

                //---- label3 ----
                label3.setText("Change your password");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 4f));

                //---- label4 ----
                label4.setText("Error Message");
                label4.setForeground(new Color(0xb3261e));

                //---- label5 ----
                label5.setText("Confirm Password:");

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(label4)
                                        .addComponent(label3))
                                    .addGap(0, 223, Short.MAX_VALUE))
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(label5, GroupLayout.Alignment.TRAILING)
                                        .addComponent(label2, GroupLayout.Alignment.TRAILING)
                                        .addComponent(label1, GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(passwordField1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                        .addComponent(passwordField2, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                        .addComponent(textField1, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE))))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(label4)
                            .addGap(7, 7, 7)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(textField1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordField1, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(contentPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(label5, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                                .addComponent(passwordField2, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");

                //---- okButton ----
                okButton.setText("Continue");

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
        setSize(450, 250);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField textField1;
    private JLabel label1;
    private JLabel label2;
    private JPasswordField passwordField1;
    private JLabel label3;
    private JLabel label4;
    private JPasswordField passwordField2;
    private JLabel label5;
    private JPanel buttonBar;
    private JButton cancelButton;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}