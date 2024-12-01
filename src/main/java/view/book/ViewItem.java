/*
 * Created by JFormDesigner on Sun Dec 01 17:36:26 EST 2024
 */

package view.book;

import java.awt.*;
import javax.swing.*;

/**
 * @author webster
 */
public class ViewItem extends JPanel {
    public ViewItem() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        comboBox1 = new JComboBox<>();
        button1 = new JButton();
        panel1 = new JPanel();
        label5 = new JLabel();
        label6 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== this ========
        setMinimumSize(new Dimension(457, 450));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0, 1.0E-4};

        //---- label1 ----
        label1.setText("<image>");
        add(label1, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 12, 16), 0, 0));

        //---- label2 ----
        label2.setText("<title> - <author>");
        add(label2, new GridBagConstraints(1, 0, 2, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 0), 0, 0));

        //---- textField1 ----
        textField1.setText("<description>");
        textField1.setEditable(false);
        add(textField1, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 0), 0, 0));

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "<Select a product below>"
        }));
        add(comboBox1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 16), 0, 0));

        //---- button1 ----
        button1.setText("Add to wishlist");
        add(button1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 0), 0, 0));

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(400, 600));
            panel1.setAutoscrolls(true);
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

            //---- label5 ----
            label5.setText("<seller's username> - sold at <price>");
            panel1.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label6 ----
            label6.setText("Contact Information");
            panel1.add(label6, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- textField3 ----
            textField3.setText("<Contact Information>");
            textField3.setEditable(false);
            panel1.add(textField3, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- label4 ----
            label4.setText("Book Condition");
            panel1.add(label4, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

            //======== scrollPane1 ========
            {

                //---- textPane1 ----
                textPane1.setText("<Book Condition>");
                textPane1.setEditable(false);
                scrollPane1.setViewportView(textPane1);
            }
            panel1.add(scrollPane1, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel1, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JComboBox<String> comboBox1;
    private JButton button1;
    private JPanel panel1;
    private JLabel label5;
    private JLabel label6;
    private JTextField textField3;
    private JLabel label4;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
