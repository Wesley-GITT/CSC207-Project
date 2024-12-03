/*
 * Created by JFormDesigner on Mon Dec 02 22:29:26 EST 2024
 */

package view.product;

import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import interface_adapter.product.list_my_products.ListMyProductController;
import interface_adapter.product.list_my_products.ListMyProductState;
import interface_adapter.product.list_my_products.ListMyProductViewModel;
import interface_adapter.product.remove.RemoveProductController;
import interface_adapter.product.remove.RemoveProductState;
import interface_adapter.product.remove.RemoveProductViewModel;
import interface_adapter.product.update.UpdateProductState;
import interface_adapter.product.update.UpdateProductViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author Jing Wei
 */
public class ListProductView extends JPanel implements PropertyChangeListener {

    class DataRow {

        private final int productId;

        public DataRow(int productId) {
            this.productId = productId;
        }

        public int getProductId() {
            return productId;
        }
    }

    private final String viewName = "list product";

    private final ListMyProductViewModel listMyProductViewModel;
    private final ListMyProductController listMyProductController;
    private final RemoveProductViewModel removeProductViewModel;
    private final RemoveProductController removeProductController;
    private final UpdateProductViewModel updateProductViewModel;
    private final ViewManagerModel viewManagerModel;

    private final List<DataRow> data = new ArrayList<>();

    public ListProductView(
            ListMyProductViewModel listMyProductViewModel, ListMyProductController listMyProductController,
            RemoveProductViewModel removeProductViewModel, RemoveProductController removeProductController,
            UpdateProductViewModel updateProductViewModel, ViewManagerModel viewManagerModel) {

        this.listMyProductViewModel = listMyProductViewModel;
        this.listMyProductController = listMyProductController;
        this.removeProductViewModel = removeProductViewModel;
        this.removeProductController = removeProductController;
        this.updateProductViewModel = updateProductViewModel;
        this.viewManagerModel = viewManagerModel;

        this.listMyProductViewModel.addPropertyChangeListener(this);
        this.removeProductViewModel.addPropertyChangeListener(this);

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
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
                thisComponentShown(e);
            }
        });
        setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing. border .EmptyBorder
        ( 0, 0 ,0 , 0) ,  "JFor\u006dDesi\u0067ner \u0045valu\u0061tion" , javax. swing .border . TitledBorder. CENTER ,javax . swing. border
        .TitledBorder . BOTTOM, new java. awt .Font ( "Dia\u006cog", java .awt . Font. BOLD ,12 ) ,java . awt
        . Color .red ) , getBorder () ) );  addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void
        propertyChange (java . beans. PropertyChangeEvent e) { if( "bord\u0065r" .equals ( e. getPropertyName () ) )throw new RuntimeException( )
        ;} } );
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0, 0.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 0.0, 1.0E-4};

        //---- label2 ----
        label2.setText("My Product");
        label2.setFont(new Font(".AppleSystemUIFont", label2.getFont().getStyle() | Font.BOLD, label2.getFont().getSize() + 4));
        add(label2, new GridBagConstraints(0, 0, 4, 1, 0.0, 0.0,
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
            table1.setVerifyInputWhenFocusTarget(false);
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1, new GridBagConstraints(0, 1, 4, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 4, 8, 4), 0, 0));

        //---- button2 ----
        button2.setText("Remove");
        button2.addActionListener(e -> removeButtonClicked(e));
        add(button2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 4, 6, 6), 0, 0));

        //---- button1 ----
        button1.setText("Edit");
        button1.addActionListener(e -> editButtonClicked(e));
        add(button1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
            new Insets(0, 0, 6, 6), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:on
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTable table1;
    private JButton button2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public String getViewName() {
        return viewName;
    }

    private void propertyChangeListProduct(ListMyProductState state) {
        final String listMyProductError = state.getListMyProductError();
        final Set<Integer> productIds = state.getProductIds();
        final DefaultTableModel model = (DefaultTableModel) table1.getModel();

        if (listMyProductError != null) {
            JOptionPane.showMessageDialog(this, "Fail to list my products: " + listMyProductError);
            return;
        }

        for (int productId: productIds) {
            data.add(new DataRow(productId));
            model.addRow(new Object[]{productId});
        }
    }

    private void propertyChangeRemoveProduct(RemoveProductState state) {
        final String removeProductError = state.getRemoveProductError();

        JOptionPane.showMessageDialog(this, "Fail to remove product: " + removeProductError);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        final Object obj = evt.getNewValue();
        if (obj instanceof ListMyProductState) {
            final ListMyProductState state = (ListMyProductState) obj;
            propertyChangeListProduct(state);
        } else {
            final RemoveProductState state = (RemoveProductState) obj;
            propertyChangeRemoveProduct(state);
        }
    }

    private void editButtonClicked(ActionEvent e) {
        final int index = table1.getSelectedRow();
        final int productId = data.get(index).getProductId();
        UpdateProductState state = updateProductViewModel.getState();
        state.setProductId(productId);
        updateProductViewModel.firePropertyChanged();

        // show edit product dialog
        ViewManagerState managerState = viewManagerModel.getState();
        managerState.setPopupName("update product");
        viewManagerModel.firePropertyChanged();
    }

    private void removeButtonClicked(ActionEvent e) {
        final int index = table1.getSelectedRow();
        final int productId = data.get(index).getProductId();
        final DefaultTableModel model = (DefaultTableModel) table1.getModel();

        removeProductController.execute(productId);
        data.remove(index);
        model.removeRow(index);
    }

    private void thisComponentShown(ComponentEvent e) {
        listMyProductController.execute();
    }

}
