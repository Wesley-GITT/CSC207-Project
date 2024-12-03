/*
 * Created by JFormDesigner on Mon Dec 02 22:44:09 EST 2024
 */

package view.book;

import interface_adapter.book.search.SearchBookController;
import interface_adapter.book.search.SearchBookState;
import interface_adapter.book.search.SearchBookViewModel;
import interface_adapter.book.view.BookController;
import interface_adapter.book.view.BookState;
import interface_adapter.book.view.BookViewModel;
import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import view.ViewUtility;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * @author webster
 */
public class SearchBookView extends JPanel implements PropertyChangeListener {

    class DataRow {

        private final String bookId;
        private final String title;
        private final String authors;
        private final String description;
        private final String publisher;
        private final String pulishedDate;
        private final String language;

        public DataRow(String bookId, String title, String authors, String description, String publisher, String pulishedDate, String language) {
            this.bookId = bookId;
            this.title = title;
            this.authors = authors;
            this.description = description;
            this.publisher = publisher;
            this.pulishedDate = pulishedDate;
            this.language = language;
        }

        public String getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthors() {
            return authors;
        }

        public String getDescription() {
            return description;
        }

        public String getPublisher() {
            return publisher;
        }

        public String getPulishedDate() {
            return pulishedDate;
        }

        public String getLanguage() {
            return language;
        }
    }

    private final String viewName = "search book";

    private final SearchBookViewModel searchBookViewModel;
    private final SearchBookController searchBookController;
    private final BookViewModel bookViewModel;
    private final BookController bookController;
    private final ViewManagerModel viewManagerModel;
    private String keyword = "";
    private boolean withProduct = false;
    private int startIndex = 0;

    private final List<DataRow> data = new ArrayList<>();

    public SearchBookView(SearchBookViewModel searchBookViewModel, SearchBookController searchBookController,
                          BookViewModel bookViewModel, BookController bookController, ViewManagerModel viewManagerModel) {
        this.searchBookViewModel = searchBookViewModel;
        this.searchBookController = searchBookController;
        this.bookViewModel = bookViewModel;
        this.bookController = bookController;
        this.viewManagerModel = viewManagerModel;

        initComponents();

        this.searchBookViewModel.addPropertyChangeListener(this);
        this.bookViewModel.addPropertyChangeListener(this);
    }

    private void table1MousePressed(MouseEvent e) {
        JTable table =(JTable) e.getSource();
        Point point = e.getPoint();
        int row = table.rowAtPoint(point);
        if (e.getClickCount() == 2 && table.getSelectedRow() != -1) {
            bookController.execute(data.get(row).getBookId());

            ViewManagerState state = viewManagerModel.getState();
            state.setViewName("view book");
            viewManagerModel.firePropertyChanged();
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        panel1 = new JPanel();
        textField1 = new JTextField();
        button1 = new JButton();
        label1 = new JLabel();
        checkBox1 = new JCheckBox();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        panel2 = new JPanel();
        label2 = new JLabel();
        progressBar1 = new JProgressBar();

        //======== this ========
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
        . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder
        . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .
        awt . Font. BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) )
        ;  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
        ) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
        ;
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

            //---- button2 ----
            button2.setText("More");
            button2.setEnabled(false);
            button2.addActionListener(e -> loadMoreButtonClicked(e));
            panel1.add(button2, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 3, 0), 0, 0));

            //======== scrollPane1 ========
            {

                //---- table1 ----
                table1.setModel(new DefaultTableModel(
                    new Object[][] {
                    },
                    new String[] {
                        "Title", "Authors", "Description", "Publisher", "Published Date", "Language"
                    }
                ) {
                    boolean[] columnEditable = new boolean[] {
                        false, false, false, false, false, false
                    };
                    @Override
                    public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return columnEditable[columnIndex];
                    }
                });
                table1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        table1MousePressed(e);
                    }
                });
                scrollPane1.setViewportView(table1);
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
                label2.setText("Done");
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
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JPanel panel2;
    private JLabel label2;
    private JProgressBar progressBar1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void propertyChangeViewBook(BookState state) {
        final String bookId = state.getId();
        final String title = state.getTitle();
        final String authors = ViewUtility.getAuthorString(state.getAuthors());
        final String description = state.getDescription().replaceAll("(?s)<[^>]*>(\\s*<[^>]*>)*", " ");;
        final String publisher = state.getPublisher();
        final String publishDate = state.getPublishedDate();
        final String lang = state.getLanguage();
        final DefaultTableModel model = (DefaultTableModel) table1.getModel();

        data.add(new DataRow(bookId, title, authors, description, publisher, publishDate, lang));
        model.addRow(new Object[]{title, authors, description, publisher, publishDate, lang});
    }

    private void propertyChangeSearchedBook(SearchBookState state) {
        final String error = state.getSearchBookError();
        final List<String> bookIds = state.getBookIds();

        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to perform a search: " + error);
        } else {
            for (String bookId: bookIds) {
                bookController.execute(bookId);
            }
        }

        this.startIndex = state.getEndIndex();

        label2.setText("Done");
        progressBar1.setIndeterminate(false);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final Object state = evt.getNewValue();
        if (state instanceof SearchBookState) {
            propertyChangeSearchedBook((SearchBookState) state);
        } else {
            propertyChangeViewBook((BookState) state);
        }
    }

    private void searchButtonClicked(ActionEvent e) {
        final String keyword = textField1.getText();
        final boolean withProduct = checkBox1.isSelected();
        this.keyword = keyword;
        this.withProduct = withProduct;

        if (keyword != "") {
            label2.setText("Searching");
            progressBar1.setIndeterminate(true);
            searchBookController.execute(keyword, 0, withProduct);
            button2.setEnabled(true);
        }
    }

    private void loadMoreButtonClicked(ActionEvent e) {
        final String keyword = this.keyword;
        final boolean withProduct = this.withProduct;

        label2.setText("Searching");
        progressBar1.setIndeterminate(true);
        searchBookController.execute(keyword, startIndex, withProduct);

    }

    public String getViewName() {
        return viewName;
    }
}
