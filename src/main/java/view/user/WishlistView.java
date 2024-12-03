/*
 * Created by JFormDesigner on Sun Dec 01 18:45:09 EST 2024
 */

package view.user;

import interface_adapter.book.view.BookController;
import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import interface_adapter.product.view.ProductController;
import interface_adapter.product.view.ProductState;
import interface_adapter.product.view.ProductViewModel;
import interface_adapter.user.show_wishlist.ShowWishlistController;
import interface_adapter.user.show_wishlist.ShowWishlistState;
import interface_adapter.user.show_wishlist.ShowWishlistViewModel;
import interface_adapter.user.update_wishlist.UpdateWishlistController;
import interface_adapter.user.update_wishlist.UpdateWishlistState;
import interface_adapter.user.update_wishlist.UpdateWishlistViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Jing Wei
 */
public class WishlistView extends JPanel implements PropertyChangeListener {

    class DataRow {

        private final int productId;

        public DataRow(int productId) {
            this.productId = productId;
        }

        public int getProductId() {
            return productId;
        }
    }

    private final String viewName = "my wishlist";

    private final ShowWishlistViewModel showWishlistViewModel;
    private final ShowWishlistController showWishlistController;
    private final UpdateWishlistViewModel updateWishlistViewModel;
    private final UpdateWishlistController updateWishlistController;
    private final ProductViewModel productViewModel;
    private final ProductController productController;
    private final BookController bookController;
    private final ViewManagerModel viewManagerModel;

    private final List<DataRow> data = new ArrayList<>();

    public WishlistView(
            ShowWishlistViewModel showWishlistViewModel, ShowWishlistController showWishlistController,
            UpdateWishlistViewModel updateWishlistViewModel, UpdateWishlistController updateWishlistController,
            ProductViewModel productViewModel, ProductController productController,
            BookController bookController, ViewManagerModel viewManagerModel) {

        this.showWishlistViewModel = showWishlistViewModel;
        this.showWishlistController = showWishlistController;
        this.updateWishlistViewModel = updateWishlistViewModel;
        this.updateWishlistController = updateWishlistController;
        this.productViewModel = productViewModel;
        this.productController = productController;
        this.bookController = bookController;
        this.viewManagerModel = viewManagerModel;

        this.showWishlistViewModel.addPropertyChangeListener(this);
        this.updateWishlistViewModel.addPropertyChangeListener(this);
        this.productViewModel.addPropertyChangeListener(this);

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

        //======== this ========
        setMinimumSize(new Dimension(457, 450));
        setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing
        .border.EmptyBorder(0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder
        .CENTER,javax.swing.border.TitledBorder.BOTTOM,new java.awt.Font("Dia\u006cog",java.
        awt.Font.BOLD,12),java.awt.Color.red), getBorder()))
        ; addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.beans.PropertyChangeEvent e
        ){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}})
        ;
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

        //---- label2 ----
        label2.setText("My Wishlist");
        label2.setFont(label2.getFont().deriveFont(label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 4f));
        add(label2, new GridBagConstraints(0, 0, 3, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(8, 6, 8, 0), 0, 0));

        //======== scrollPane1 ========
        {

            //---- table1 ----
            table1.setModel(new DefaultTableModel(
                new Object[][] {
                    {0},
                },
                new String[] {
                    "Product ID"
                }
            ) {
                Class<?>[] columnTypes = new Class<?>[] {
                    Integer.class
                };
                boolean[] columnEditable = new boolean[] {
                    false
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
        add(scrollPane1, new GridBagConstraints(0, 1, 3, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 4, 8, 4), 0, 0));

        //---- button2 ----
        button2.setText("Remove");
        button2.addActionListener(e -> removeButtonClicked(e));
        add(button2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 4, 6, 6), 0, 0));

        //---- button1 ----
        button1.setText("Details");
        button1.addActionListener(e -> detailsButtonClicked(e));
        add(button1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 6, 6), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    private void thisComponentShown(ComponentEvent e) {
        showWishlistController.execute();
    }

    private void propertyChangeShowWishlist(ShowWishlistState state) {
        final Set<Integer> wishlist = state.getWishlist();
        final String error = state.getShowWishlistError();
        final DefaultTableModel model = (DefaultTableModel) table1.getModel();
        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to show wishlist: " + error);
            return;
        }

        for (int productId: wishlist) {
            data.add(new DataRow(productId));
            model.addRow(new Object[]{productId});
        }
    }

    private void propertyChangeUpdateWishlist(UpdateWishlistState state) {
        final String error = state.getUpdateWishlistError();
        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to update wishlist: " + error);
            return;
        }
    }

    private void propertyChangeProduct(ProductState state) {
        final String bookId = state.getBookId();
        final String error = state.getViewProductError();
        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to view product: " + error);
            return;
        }

        bookController.execute(bookId);

        ViewManagerState managerState = viewManagerModel.getState();
        managerState.setViewName("view book");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final Object state = evt.getNewValue();
        if (state instanceof ShowWishlistState) {
            propertyChangeShowWishlist((ShowWishlistState) state);
        } else if (state instanceof UpdateWishlistState) {
            propertyChangeUpdateWishlist((UpdateWishlistState) state);
        } else {
            propertyChangeProduct((ProductState) state);
        }
    }

    private void removeButtonClicked(ActionEvent e) {
        final DefaultTableModel model = (DefaultTableModel) table1.getModel();
        final int index = table1.getSelectedRow();
        data.remove(index);
        Set<Integer> wishlist = new HashSet<>();
        for (DataRow row: data) {
            wishlist.add(row.getProductId());
        }
        updateWishlistController.execute(wishlist);
    }

    private void detailsButtonClicked(ActionEvent e) {
        final DefaultTableModel model = (DefaultTableModel) table1.getModel();
        final int index = table1.getSelectedRow();
        final int productId = data.get(index).getProductId();
        productController.execute(productId);
    }

    public String getViewName() {
        return viewName;
    }
}
