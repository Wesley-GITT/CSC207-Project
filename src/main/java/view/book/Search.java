/*
 * Created by JFormDesigner on Sun Dec 01 17:18:22 EST 2024
 */

package view.book;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * @author webster
 */
public class Search extends JPanel {
    public Search() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        panel1 = new JPanel();
        textField1 = new JTextField();
        button1 = new JButton();
        panel2 = new JPanel();

        //======== this ========
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax
        . swing. border. EmptyBorder( 0, 0, 0, 0) , "JF\u006frmDesi\u0067ner Ev\u0061luatio\u006e", javax. swing
        . border. TitledBorder. CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .
        Font ("Dialo\u0067" ,java .awt .Font .BOLD ,12 ), java. awt. Color. red
        ) , getBorder( )) );  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override
        public void propertyChange (java .beans .PropertyChangeEvent e) {if ("borde\u0072" .equals (e .getPropertyName (
        ) )) throw new RuntimeException( ); }} );
        setLayout(new CardLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new LineBorder(new Color(0xf5f5f5), 3));
            panel1.setForeground(new Color(0xf5f5f5));
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {333, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {28, 300, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};
            panel1.add(textField1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 3, 3), 0, 0));

            //---- button1 ----
            button1.setText("Search");
            panel1.add(button1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 3, 0), 0, 0));

            //======== panel2 ========
            {
                panel2.setAutoscrolls(true);
                panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
            }
            panel1.add(panel2, new GridBagConstraints(0, 1, 2, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        add(panel1, "card1");
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JPanel panel1;
    private JTextField textField1;
    private JButton button1;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
