/*
 * Created by JFormDesigner on Mon Dec 02 22:44:09 EST 2024
 */

package view.book;

import interface_adapter.book.search.SearchBookController;
import interface_adapter.book.search.SearchBookState;
import interface_adapter.book.search.SearchBookViewModel;
import interface_adapter.book.view.BookController;
import interface_adapter.book.view.BookViewModel;
import interface_adapter.container.ViewManagerModel;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

/**
 * @author webster
 */
public class SearchBookView extends JPanel implements PropertyChangeListener {

    private final String viewName = "search book";

    private final SearchBookViewModel searchBookViewModel;
    private final SearchBookController searchBookController;
    private final BookViewModel bookViewModel;
    private final BookController bookController;
    private final ViewManagerModel viewManagerModel;
    private String keyword = "";
    private boolean withProduct = false;

    public SearchBookView(SearchBookViewModel searchBookViewModel, SearchBookController searchBookController,
                          BookViewModel bookViewModel, BookController bookController, ViewManagerModel viewManagerModel) {
        this.searchBookViewModel = searchBookViewModel;
        this.searchBookController = searchBookController;
        this.bookViewModel = bookViewModel;
        this.bookController = bookController;
        this.viewManagerModel = viewManagerModel;

        this.searchBookViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        panel1 = new JPanel();
        textField1 = new JTextField();
        button1 = new JButton();
        label1 = new JLabel();
        checkBox1 = new JCheckBox();
        scrollPane1 = new JScrollPane();
        panel3 = new JPanel();
        panel2 = new JPanel();
        label2 = new JLabel();
        progressBar1 = new JProgressBar();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );
        setLayout(new CardLayout());

        //======== panel1 ========
        {
            panel1.setBorder(new LineBorder(new Color(0xf5f5f5), 3));
            panel1.setForeground(new Color(0xf5f5f5));
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 333, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {28, 0, 303, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
            panel1.add(textField1, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 3, 3), 0, 0));

            //---- button1 ----
            button1.setText("Search");
            button1.addActionListener(e -> searchButtonClicked(e));
            panel1.add(button1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTHEAST, GridBagConstraints.NONE,
                new Insets(0, 0, 3, 0), 0, 0));

            //---- label1 ----
            label1.setText("Show results:");
            panel1.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 3, 3), 0, 0));

            //---- checkBox1 ----
            checkBox1.setText("with sale");
            panel1.add(checkBox1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 3, 3), 0, 0));

            //======== scrollPane1 ========
            {
                scrollPane1.setBorder(null);
                scrollPane1.setBackground(new Color(0xf5f5f5));

                //======== panel3 ========
                {
                    panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
                }
                scrollPane1.setViewportView(panel3);
            }
            panel1.add(scrollPane1, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 3, 0), 0, 0));

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {105, 0, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {1.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- label2 ----
                label2.setText("Searching");
                label2.setFont(new Font("Consolas", Font.PLAIN, 11));
                panel2.add(label2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(2, 0, 0, 5), 0, 0));

                //---- progressBar1 ----
                progressBar1.setValue(100);
                progressBar1.setMinimumSize(new Dimension(5, 4));
                panel2.add(progressBar1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(4, 0, 4, 0), 0, 0));
            }
            panel1.add(panel2, new GridBagConstraints(1, 3, 2, 1, 0.0, 0.0,
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
    private JLabel label1;
    private JCheckBox checkBox1;
    private JScrollPane scrollPane1;
    private JPanel panel3;
    private JPanel panel2;
    private JLabel label2;
    private JProgressBar progressBar1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final SearchBookState state = (SearchBookState) evt.getNewValue();
        final String error = state.getSearchBookError();
        final List<String> bookIds = state.getBookIds();

        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to perform a search: " + error);
            return;
        }

        panel3.removeAll();

        for (String bookId: bookIds) {
            panel3.add(new SearchedItemView(bookViewModel, bookController, viewManagerModel));
            bookController.execute(bookId);
        }

        label2.setText("Done");
        progressBar1.setIndeterminate(false);
    }

    private void searchButtonClicked(ActionEvent e) {
        final String keyword = textField1.getText();
        final boolean withProduct = checkBox1.isSelected();
        this.keyword = keyword;
        this.withProduct = withProduct;

        if (keyword == "") {
            searchBookController.execute(keyword, 0, withProduct);
            label2.setText("Searching");
            progressBar1.setIndeterminate(true);
        }
    }

    public String getViewName() {
        return viewName;
    }
}
