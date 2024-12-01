/*
 * Created by JFormDesigner on Sun Dec 01 18:54:29 EST 2024
 */

package view.user;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * @author webster
 */
public class Product extends JPanel {
    public Product() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button2 = new JButton();
        button1 = new JButton();
        button3 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(457, 450));
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing. border.
        EmptyBorder( 0, 0, 0, 0) , "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn", javax. swing. border. TitledBorder. CENTER, javax. swing
        . border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .awt .Font .BOLD ,12 ),
        java. awt. Color. red) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( )
        { @Override public void propertyChange (java .beans .PropertyChangeEvent e) {if ("\u0062ord\u0065r" .equals (e .getPropertyName () ))
        throw new RuntimeException( ); }} );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

        //---- label2 ----
        label2.setText("My Product");
        add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 12, 16), 0, 0));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {"Harry Potter and the Philosopher's Stone", "Jack", "30.00", false},
                },
                new String[] {
                    "Book", "Seller", "Price", "Sold Out"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    String.class, String.class, String.class, Boolean.class
                };
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
                };
                @Override
                public Class<?> getColumnClass(int columnIndex) {
                    return columnTypes[columnIndex];
                }
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 12, 0), 0, 0));

        //---- button2 ----
        button2.setText("Remove");
        add(button2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 0, 16), 0, 0));

        //---- button1 ----
        button1.setText("Edit");
        add(button1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 16), 0, 0));

        //---- button3 ----
        button3.setText("Create");
        add(button3, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button1;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
