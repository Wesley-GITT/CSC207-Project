/*
 * Created by JFormDesigner on Mon Dec 02 22:30:22 EST 2024
 */

package view.book;

import interface_adapter.book.view.BookState;
import interface_adapter.book.view.BookViewModel;
import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import interface_adapter.product.list_book_products.ListBookProductController;
import interface_adapter.product.list_book_products.ListBookProductState;
import interface_adapter.product.list_book_products.ListBookProductViewModel;
import interface_adapter.product.view.ProductController;
import interface_adapter.product.view.ProductState;
import interface_adapter.product.view.ProductViewModel;
import interface_adapter.user.show_other_profile.ShowOtherProfileController;
import interface_adapter.user.show_other_profile.ShowOtherProfileState;
import interface_adapter.user.show_other_profile.ShowOtherProfileViewModel;
import interface_adapter.user.show_wishlist.ShowWishlistController;
import interface_adapter.user.show_wishlist.ShowWishlistState;
import interface_adapter.user.show_wishlist.ShowWishlistViewModel;
import interface_adapter.user.update_wishlist.UpdateWishlistController;
import interface_adapter.user.update_wishlist.UpdateWishlistViewModel;
import view.ViewUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author webster
 */
public class BookView extends JPanel implements PropertyChangeListener {

    private final String viewName = "view book";

    private final BookViewModel bookViewModel;
    private final ProductViewModel productViewModel;
    private final ProductController productController;
    private final ShowOtherProfileViewModel showOtherProfileViewModel;
    private final ShowOtherProfileController showOtherProfileController;
    private final ListBookProductViewModel listBookProductViewModel;
    private final ListBookProductController listBookProductController;
    private final ShowWishlistViewModel showWishlistViewModel;
    private final ShowWishlistController showWishlistController;
    private final UpdateWishlistViewModel updateWishlistViewModel;
    private final UpdateWishlistController updateWishlistController;
    private final ViewManagerModel viewManagerModel;

    private final List<Integer> productIds = new ArrayList<>();
    private final Set<Integer> wishlist = new HashSet<>();

    public BookView(
            BookViewModel bookViewModel, ProductViewModel productViewModel, ProductController productController,
            ShowOtherProfileViewModel showOtherProfileViewModel, ShowOtherProfileController showOtherProfileController,
            ListBookProductViewModel listBookProductViewModel, ListBookProductController listBookProductController,
            ShowWishlistViewModel showWishlistViewModel, ShowWishlistController showWishlistController,
            UpdateWishlistViewModel updateWishlistViewModel, UpdateWishlistController updateWishlistController,
            ViewManagerModel viewManagerModel) {

        this.bookViewModel = bookViewModel;
        this.productViewModel = productViewModel;
        this.productController = productController;
        this.showOtherProfileViewModel = showOtherProfileViewModel;
        this.showOtherProfileController = showOtherProfileController;
        this.listBookProductViewModel = listBookProductViewModel;
        this.listBookProductController = listBookProductController;
        this.showWishlistViewModel = showWishlistViewModel;
        this.showWishlistController = showWishlistController;
        this.updateWishlistViewModel = updateWishlistViewModel;
        this.updateWishlistController = updateWishlistController;
        this.viewManagerModel = viewManagerModel;

        this.bookViewModel.addPropertyChangeListener(this);
        this.productViewModel.addPropertyChangeListener(this);
        this.showOtherProfileViewModel.addPropertyChangeListener(this);
        this.listBookProductViewModel.addPropertyChangeListener(this);
        this.showWishlistViewModel.addPropertyChangeListener(this);
        this.updateWishlistViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        label1 = new JLabel();
        label2 = new JLabel();
        button2 = new JButton();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        comboBox1 = new JComboBox<>();
        button1 = new JButton();
        panel1 = new JPanel();
        label5 = new JLabel();
        label3 = new JLabel();
        checkBox1 = new JCheckBox();
        label6 = new JLabel();
        textField3 = new JTextField();
        label4 = new JLabel();
        scrollPane2 = new JScrollPane();
        textPane2 = new JTextPane();

        //======== this ========
        setMinimumSize(new Dimension(457, 450));
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing.
        border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn" , javax. swing .border . TitledBorder. CENTER
        ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font
        . BOLD ,12 ) ,java . awt. Color .red ) , getBorder () ) );  addPropertyChangeListener(
        new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e) { if( "\u0062ord\u0065r"
        .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0, 1.0E-4};

        //---- label1 ----
        label1.setIconTextGap(10);
        label1.setMinimumSize(new Dimension(120, 80));
        label1.setMaximumSize(new Dimension(1024, 256));
        label1.setPreferredSize(new Dimension(80, 40));
        add(label1, new GridBagConstraints(0, 0, 1, 3, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(6, 4, 12, 16), 0, 0));

        //---- label2 ----
        label2.setText("<title> - <author>");
        add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(6, 0, 12, 16), 0, 0));

        //---- button2 ----
        button2.setText("I want to sell");
        button2.addActionListener(this::sellButtonClicked);
        add(button2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(6, 0, 12, 4), 0, 0));

        //======== scrollPane1 ========
        {

            //---- textPane1 ----
            textPane1.setText("<description>");
            textPane1.setEditable(false);
            scrollPane1.setViewportView(textPane1);
        }
        add(scrollPane1, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 12, 4), 0, 0));

        //---- comboBox1 ----
        comboBox1.setModel(new DefaultComboBoxModel<>(new String[] {
            "<Select a product below>"
        }));
        comboBox1.addActionListener(e -> comboBoxSelectedValueChanged(e));
        add(comboBox1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 16), 0, 0));

        //---- button1 ----
        button1.setText("Add to wishlist");
        button1.setEnabled(false);
        button1.addActionListener(e -> addToWishlistButtonClicked(e));
        add(button1, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
            new Insets(0, 0, 12, 4), 0, 0));

        //======== panel1 ========
        {
            panel1.setMinimumSize(new Dimension(400, 600));
            panel1.setAutoscrolls(true);
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0};
            ((GridBagLayout)panel1.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel1.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 1.0E-4};

            //---- label5 ----
            label5.setText("Select sales from above to see detail");
            panel1.add(label5, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
            panel1.add(label3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));

            //---- checkBox1 ----
            checkBox1.setText("Sold");
            checkBox1.setEnabled(false);
            panel1.add(checkBox1, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 4), 0, 0));

            //---- label6 ----
            label6.setText("Contact Information");
            panel1.add(label6, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(4, 0, 4, 4), 0, 0));

            //---- textField3 ----
            textField3.setEditable(false);
            panel1.add(textField3, new GridBagConstraints(0, 2, 3, 1, 0.0, 0.0,
                GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL,
                new Insets(4, 0, 4, 4), 0, 0));

            //---- label4 ----
            label4.setText("Book Condition");
            panel1.add(label4, new GridBagConstraints(0, 3, 3, 1, 0.0, 0.0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(4, 0, 4, 4), 0, 0));

            //======== scrollPane2 ========
            {

                //---- textPane2 ----
                textPane2.setEditable(false);
                scrollPane2.setViewportView(textPane2);
            }
            panel1.add(scrollPane2, new GridBagConstraints(0, 4, 3, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(4, 0, 10, 4), 0, 0));
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
    private JButton button2;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JComboBox<String> comboBox1;
    private JButton button1;
    private JPanel panel1;
    private JLabel label5;
    private JLabel label3;
    private JCheckBox checkBox1;
    private JLabel label6;
    private JTextField textField3;
    private JLabel label4;
    private JScrollPane scrollPane2;
    private JTextPane textPane2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void loadImage(String url) {
        try {
            URL urlObject = new URL(url);
            BufferedImage image = ImageIO.read(urlObject);
            label1.setIcon(new ImageIcon(image));
        } catch (IOException e) {
            label1.setText("");
        }
    }

    private void propertyChangeBook(BookState state) {
        final String error = state.getViewBookError();
        final String bookId = state.getId();
        final String imageUrl = state.getImageUrl();
        final String title = state.getTitle();
        final String authorString = ViewUtility.getAuthorString(state.getAuthors()); // From the second class
        final String description = state.getDescription();

        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to show book: " + error);
            return;
        }

        loadImage(imageUrl);
        label2.setText(title + " by " + authorString);
        textPane1.setText(description);

        listBookProductController.execute(bookId);
    }

    private void propertyChangeListBookProduct(ListBookProductState state) {
        final String error = state.getListBookProductError();
        final Set<Integer> productIds = state.getProductIds();

        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to list products: " + error);
            return;
        }

        for (int productId: productIds) {
            this.productIds.add(productId);
            this.comboBox1.addItem(String.valueOf(productId));
        }
    }

    private void propertyChangeProduct(ProductState state) {
        final String error = state.getViewProductError();

        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to show products: " + error);
            return;
        }

        label3.setText("Price: " + state.getPrice());
        textPane2.setText(state.getBookCondition());
        checkBox1.setSelected(state.isSold());
        showOtherProfileController.execute(state.getSellerId());
    }

    private void propertyChangeShowOtherProfile(ShowOtherProfileState state) {
        final String error = state.getShowOtherProfileError();

        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to show seller's profile: " + error);
            return;
        }

        label6.setText("Telephone: " + state.getTelephone() + "   Email: " + state.getEmail());
    }

    private void propertyChangeShowWishlist(ShowWishlistState state) {
        this.wishlist.addAll(state.getWishlist());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final Object state = evt.getNewValue();
        if (state instanceof BookState){
            propertyChangeBook((BookState) state);
        } else if (state instanceof ListBookProductState) {
            propertyChangeListBookProduct((ListBookProductState) state);
        } else if (state instanceof ProductState) {
            propertyChangeProduct((ProductState) state);
        } else if (state instanceof ShowOtherProfileState){
            propertyChangeShowOtherProfile((ShowOtherProfileState) state);
        } else {
            propertyChangeShowWishlist((ShowWishlistState) state);
        }
    }

    private void comboBoxSelectedValueChanged(ActionEvent e) {
        if (comboBox1.getSelectedIndex() > 0) {
            button1.setEnabled(true);
        } else {
            button1.setEnabled(false);
        }
    }

    private void addToWishlistButtonClicked(ActionEvent e) {
        final int index = comboBox1.getSelectedIndex() - 1;
        if (index >= 0) {
            final int productId = productIds.get(index);
            this.wishlist.add(productId);
            updateWishlistController.execute(wishlist);
        }
    }

    private void sellButtonClicked(ActionEvent e) {
        BookState state = bookViewModel.getState();
        ProductState productState = productViewModel.getState();
        productState.setBookId(state.getId());
        productViewModel.firePropertyChanged();

        ViewManagerState managerState = viewManagerModel.getState();
        managerState.setPopupName("update product");

    }

    public String getViewName() {
        return viewName;
    }
}
