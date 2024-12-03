/*
 * Created by JFormDesigner on Mon Dec 02 22:30:11 EST 2024
 */

package view.book;

import interface_adapter.book.view.BookController;
import interface_adapter.book.view.BookState;
import interface_adapter.book.view.BookViewModel;
import interface_adapter.container.ViewManagerModel;
import interface_adapter.container.ViewManagerState;
import view.ViewUtility;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.net.URL;

/**
 * @author webster
 */
public class SearchedItemView extends JPanel implements PropertyChangeListener {

    private final BookViewModel bookViewModel;
    private final BookController bookController;
    private final ViewManagerModel viewManagerModel;

    public SearchedItemView(
            BookViewModel bookViewModel, BookController bookController,
            ViewManagerModel viewManagerModel) {

        this.bookViewModel = bookViewModel;
        this.bookController = bookController;
        this.viewManagerModel = viewManagerModel;

        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - Jing Wei
        label1 = new JLabel();
        label2 = new JLabel();
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();

        //======== this ========
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
        setBorder (new javax. swing. border. CompoundBorder( new javax .swing .border .TitledBorder (new javax. swing
        . border. EmptyBorder( 0, 0, 0, 0) , "JFor\u006dDesi\u0067ner \u0045valu\u0061tion", javax. swing. border. TitledBorder
        . CENTER, javax. swing. border. TitledBorder. BOTTOM, new java .awt .Font ("Dia\u006cog" ,java .
        awt .Font .BOLD ,12 ), java. awt. Color. red) , getBorder( )) )
        ;  addPropertyChangeListener (new java. beans. PropertyChangeListener( ){ @Override public void propertyChange (java .beans .PropertyChangeEvent e
        ) {if ("bord\u0065r" .equals (e .getPropertyName () )) throw new RuntimeException( ); }} )
        ;
        setLayout(new GridBagLayout());
        ((GridBagLayout)getLayout()).columnWidths = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).rowHeights = new int[] {0, 0, 0};
        ((GridBagLayout)getLayout()).columnWeights = new double[] {0.0, 1.0, 1.0E-4};
        ((GridBagLayout)getLayout()).rowWeights = new double[] {0.0, 1.0, 1.0E-4};

        //---- label1 ----
        label1.setText("<image>");
        add(label1, new GridBagConstraints(0, 0, 1, 2, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 5), 0, 0));

        //---- label2 ----
        label2.setText("<title> - <author>");
        add(label2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 10, 0), 0, 0));

        //======== scrollPane1 ========
        {
            scrollPane1.setBackground(new Color(0xf5f5f5));
            scrollPane1.setBorder(null);

            //---- textPane1 ----
            textPane1.setText("jkgljsdgflajdhflakjdhsf auhdflukhqlkejrhflajkdhs <br/>ljkahdlkjfh lqkwjehlfkj adlfkjh alkdjfhlajkdhlkfjhalksdhf");
            textPane1.setBorder(null);
            textPane1.setBackground(new Color(0xf5f5f5));
            textPane1.setEditable(false);
            textPane1.setEnabled(false);
            textPane1.setDisabledTextColor(new Color(0x202122));
            scrollPane1.setViewportView(textPane1);
        }
        add(scrollPane1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - Jing Wei
    private JLabel label1;
    private JLabel label2;
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
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

    public void propertyChange(PropertyChangeEvent evt) {
        final BookState state = bookViewModel.getState();
        final String error = state.getViewBookError();
        final String imageUrl = state.getImageUrl();
        final String title = state.getTitle();
        final String authorString = ViewUtility.getAuthorString(state.getAuthors());
        final String description = state.getDescription();

        if (error != null) {
            JOptionPane.showMessageDialog(this, "Fail to show searched item: " + error);
        }

        loadImage(imageUrl);
        label2.setText(title + " by " + authorString);
        textPane1.setText(description);
    }

    private void thisMouseClicked(MouseEvent e) {
        final BookState state = bookViewModel.getState();
        bookController.execute(state.getId());

        ViewManagerState managerState = viewManagerModel.getState();
        managerState.setViewName("view book");
        viewManagerModel.firePropertyChanged();
    }

}
