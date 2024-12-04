package view.user;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import interface_adapter.product.list_my_products.ListMyProductController;
import interface_adapter.product.list_my_products.ListMyProductState;
import interface_adapter.product.list_my_products.ListMyProductViewModel;
import interface_adapter.product.view.ProductController;

/**
 * MyProductView displays the user's products with all information.
 */
public class MyProductView extends JPanel implements PropertyChangeListener {

    private final String viewName = "my products";

    private final ListMyProductViewModel listMyProductViewModel;
    private final ListMyProductController listMyProductController;
    private final ProductController productController;

    private final List<DataRow> data = new ArrayList<>();

    private JLabel label;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton detailsButton;

    public MyProductView(
            ListMyProductViewModel listMyProductViewModel,
            ListMyProductController listMyProductController,
            ProductController productController) {

        this.listMyProductViewModel = listMyProductViewModel;
        this.listMyProductController = listMyProductController;
        this.productController = productController;

        this.listMyProductViewModel.addPropertyChangeListener(this);

        initComponents();
    }

    private void initComponents() {
        final float fourf = 4f;
        label = new JLabel("My Products");
        label.setFont(label.getFont().deriveFont(Font.BOLD, label.getFont().getSize() + fourf));

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"Product ID", "Product Name", "Price", "Description"}
        ) {
            final Class<?>[] columnTypes = new Class<?>[]{Integer.class, String.class, Double.class, String.class};
            final boolean[] columnEditable = new boolean[]{false, false, false, false};

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return columnTypes[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return columnEditable[columnIndex];
            }
        });

        scrollPane = new JScrollPane(table);

        detailsButton = new JButton("Details");
        detailsButton.addActionListener(this::detailsButtonClicked);

        setLayout(new GridBagLayout());
        final GridBagConstraints gbc = new GridBagConstraints();

        final int eight = 8;

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(eight, eight, eight, eight);
        add(label, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);

        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.weighty = 0;
        gbc.fill = GridBagConstraints.NONE;

        add(detailsButton, gbc);
    }

    private void propertyChangeListMyProducts(ListMyProductState state) {
        final Set<Integer> productIds = state.getProductIds();
        final String error = state.getListMyProductError();
        final DefaultTableModel model = (DefaultTableModel) table.getModel();

        if (error != null) {
            JOptionPane.showMessageDialog(this, "Failed to load products: " + error);
            return;
        }

        for (int productId : productIds) {
            final double num = 99.99;
            // Assuming product details are fetched from another method; mock data is used here.
            final String name = "Product " + productId;
            // Replace with actual fetch logic.
            final double price = num;
            // Replace with actual fetch logic.
            final String description = "Description for Product " + productId;
            // Replace with actual fetch logic.

            final DataRow row = new DataRow(productId, name, price, description);
            data.add(row);
            model.addRow(new Object[]{row.getProductId(), row.getProductName(), row.getPrice(), row.getDescription()});
        }
    }

    private void detailsButtonClicked(ActionEvent e) {
        final int selectedIndex = table.getSelectedRow();
        if (selectedIndex < 0) {
            JOptionPane.showMessageDialog(this, "Please select a product.");
            return;
        }

        final DataRow product = data.get(selectedIndex);
        productController.execute(product.getProductId());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getNewValue() instanceof ListMyProductState) {
            propertyChangeListMyProducts((ListMyProductState) evt.getNewValue());
        }
    }

    public String getViewName() {
        return viewName;
    }

    /**
     * Inner class to hold data for each product row.
     */
    private static class DataRow {
        private final int productId;
        private final String productName;
        private final double price;
        private final String description;

        public DataRow(int productId, String productName, double price, String description) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
            this.description = description;
        }

        public int getProductId() {
            return productId;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        public String getDescription() {
            return description;
        }
    }
}
