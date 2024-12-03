/*
 * Created by JFormDesigner on Mon Dec 02 22:29:14 EST 2024
 */

package view.product;

import interface_adapter.book.view.BookController;
import interface_adapter.book.view.BookState;
import interface_adapter.book.view.BookViewModel;
import interface_adapter.product.update.UpdateProductController;
import interface_adapter.product.update.UpdateProductState;
import interface_adapter.product.update.UpdateProductViewModel;
import interface_adapter.product.view.ProductController;
import interface_adapter.product.view.ProductState;
import interface_adapter.product.view.ProductViewModel;
import view.ViewUtility;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Set;

/**
 * @author Jing Wei
 */
public class EditProductView extends JDialog implements PropertyChangeListener {

    private final String viewName = "edit product";

    private final UpdateProductViewModel updateProductViewModel;
    private final UpdateProductController updateProductController;
    private final BookViewModel bookViewModel;
    private final BookController bookController;
    private final ProductViewModel productViewModel;
    private final ProductController productController;

    public EditProductView(UpdateProductViewModel updateProductViewModel, UpdateProductController updateProductController,
                           BookViewModel bookViewModel, BookController bookController,
                           ProductViewModel productViewModel, ProductController productController) {

        this.updateProductViewModel = updateProductViewModel;
        this.updateProductController = updateProductController;
        this.bookViewModel = bookViewModel;
        this.bookController = bookController;
        this.productViewModel = productViewModel;
        this.productController = productController;

        this.updateProductViewModel.addPropertyChangeListener(this);
        this.bookViewModel.addPropertyChangeListener(this);
        this.productViewModel.addPropertyChangeListener(this);

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
        textField2 = new JSpinner();
        label3 = new JLabel();
        label5 = new JLabel();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        label4 = new JLabel();
        buttonBar = new JPanel();
        cancelButton = new JButton();
        okButton = new JButton();
        checkBox1 = new JCheckBox();

        //======== this ========
        setResizable(false);
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setBorder(new javax.swing.border.CompoundBorder(new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(
            0,0,0,0), "JF\u006frmD\u0065sig\u006eer \u0045val\u0075ati\u006fn",javax.swing.border.TitledBorder.CENTER,javax.swing.border.TitledBorder
            .BOTTOM,new java.awt.Font("Dia\u006cog",java.awt.Font.BOLD,12),java.awt.Color.
            red),dialogPane. getBorder()));dialogPane. addPropertyChangeListener(new java.beans.PropertyChangeListener(){@Override public void propertyChange(java.
            beans.PropertyChangeEvent e){if("\u0062ord\u0065r".equals(e.getPropertyName()))throw new RuntimeException();}});
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 0, 0, 0, 0, 0, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0E-4};

                //---- textField1 ----
                textField1.setEditable(false);
                contentPanel.add(textField1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(5, 0, 5, 4), 0, 0));

                //---- label1 ----
                label1.setText("Book:");
                contentPanel.add(label1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(4, 4, 5, 9), 0, 0));

                //---- label2 ----
                label2.setText("Price:");
                contentPanel.add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(4, 4, 5, 9), 0, 0));

                //---- textField2 ----
                textField2.setModel(new SpinnerNumberModel(0.0, 0.0, null, 1.0));
                contentPanel.add(textField2, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(5, 0, 5, 4), 0, 0));

                //---- label3 ----
                label3.setText("Create / Edit a product");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getStyle() | Font.BOLD, label3.getFont().getSize() + 4f));
                contentPanel.add(label3, new GridBagConstraints(0, 0, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(12, 4, 13, 4), 0, 0));

                //---- label5 ----
                label5.setText("Describe your book condition");
                contentPanel.add(label5, new GridBagConstraints(0, 3, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(4, 4, 5, 4), 0, 0));

                //======== scrollPane1 ========
                {
                    scrollPane1.setViewportView(textPane1);
                }
                contentPanel.add(scrollPane1, new GridBagConstraints(0, 4, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 4, 5, 4), 0, 0));

                //---- label4 ----
                label4.setText("Error Message");
                label4.setForeground(new Color(0xb3261e));
                label4.setVisible(false);
                contentPanel.add(label4, new GridBagConstraints(0, 5, 2, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 4, 0, 4), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(e -> cancel(e));

                //---- okButton ----
                okButton.setText("Continue");
                okButton.addActionListener(e -> updateProduct(e));

                //---- checkBox1 ----
                checkBox1.setText("Already Sold");

                GroupLayout buttonBarLayout = new GroupLayout(buttonBar);
                buttonBar.setLayout(buttonBarLayout);
                buttonBarLayout.setHorizontalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(checkBox1)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 145, Short.MAX_VALUE)
                            .addComponent(cancelButton)
                            .addGap(5, 5, 5)
                            .addComponent(okButton)
                            .addContainerGap())
                );
                buttonBarLayout.setVerticalGroup(
                    buttonBarLayout.createParallelGroup()
                        .addGroup(buttonBarLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(cancelButton)
                            .addComponent(okButton)
                            .addComponent(checkBox1))
                );
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        setSize(450, 335);
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
    private JSpinner textField2;
    private JLabel label3;
    private JLabel label5;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JLabel label4;
    private JPanel buttonBar;
    private JButton cancelButton;
    private JButton okButton;
    private JCheckBox checkBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public String getViewName() {
        return viewName;
    }

    private void propertyChangeUpdateProduct(UpdateProductState state) {
        final String updateProductError = state.getUpdateProductError();
        final int productId = state.getProductId();
        final String bookId = state.getBookId();

        if (updateProductError != null) {
            label4.setVisible(true);
            label4.setText(updateProductError);
            return;
        } else {
            label4.setVisible(false);
        }

        checkBox1.setVisible(productId < 0);

        if (productId > 0) {
            productController.execute(productId);
        }

        if (bookId != null) {
            bookController.execute(bookId);
        }
    }

    private void propertyChangeProduct(ProductState state) {
        final String bookId = state.getBookId();
        final double price = state.getPrice();
        final String bookCondition = state.getBookCondition();
        final boolean sold = state.isSold();

        textField2.setValue(price);
        textPane1.setText(bookCondition);
        checkBox1.setSelected(sold);

        bookController.execute(bookId);
    }

    private void propertyChangeBook(BookState state) {
        final String title = state.getTitle();
        final Set<String> authors = state.getAuthors();
        final String authorsStr = ViewUtility.getAuthorString(authors);

        textField1.setText(title + " by " + authorsStr);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final Object obj = evt.getNewValue();
        if (obj instanceof UpdateProductState) {
            final UpdateProductState state = (UpdateProductState) obj;
            propertyChangeUpdateProduct(state);
        } else if (obj instanceof ProductState) {
            final ProductState state = (ProductState) obj;
            propertyChangeProduct(state);
        } else {
            final BookState state = (BookState) obj;
            propertyChangeBook(state);
        }
    }

    private void close() {
        textField1.setText("");
        textField2.setValue(0.00);
        textPane1.setText("");
        checkBox1.setSelected(false);
        dispose();
    }

    private void cancel(ActionEvent e) {
        close();
    }

    private void updateProduct(ActionEvent e) {
        final UpdateProductState state = updateProductViewModel.getState();
        final String bookId = state.getBookId();
        final String bookCondition = textPane1.getText();
        final double price = (Double) textField2.getValue();
        final boolean sold = checkBox1.isSelected();
        final int productId = state.getProductId();
        
        if (productId < 0) {
            updateProductController.execute(bookId, bookCondition, price);
        } else {
            updateProductController.execute(productId, bookCondition, price, sold);
        }
        close();
    }
}
