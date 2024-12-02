/*
 * Created by JFormDesigner on Sun Dec 01 17:19:31 EST 2024
 */

package view.container;

import interface_adapter.Logout.LogoutController;
import interface_adapter.MainPage.MainPageViewModel;

import javax.swing.*;
import java.awt.*;

/**
 * @author webster
 */
public class MainPage extends JFrame{

    private final String viewName = "Main Page";
    private final MainPageViewModel mainPageViewModel;
    private LogoutController logoutController;

    public MainPage(MainPageViewModel mainPageViewModel) {
        initComponents();
        this.mainPageViewModel = mainPageViewModel;
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Evaluation license - eric
        menuBar1 = new JMenuBar();
        menu2 = new JMenu();
        menuItem7 = new JMenuItem();
        menuItem2 = new JMenuItem();
        menu1 = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem5 = new JMenuItem();
        menuItem3 = new JMenuItem();
        menuItem6 = new JMenuItem();
        menuItem4 = new JMenuItem();
        panel2 = new JPanel();

        //======== this ========
        setMinimumSize(new Dimension(600, 450));
        var contentPane = getContentPane();
        contentPane.setLayout(new CardLayout());

        //======== menuBar1 ========
        {

            //======== menu2 ========
            {
                menu2.setText("Navigation");

                //---- menuItem7 ----
                menuItem7.setText("Home");
                menuItem7.setMargin(new Insets(3, -6, 3, 0));
                menuItem7.setIconTextGap(0);
                menu2.add(menuItem7);

                //---- menuItem2 ----
                menuItem2.setText("Search");
                menuItem2.setAlignmentX(0.0F);
                menuItem2.setMargin(new Insets(3, -6, 3, 0));
                menuItem2.setIconTextGap(0);
                menu2.add(menuItem2);
            }
            menuBar1.add(menu2);

            //======== menu1 ========
            {
                menu1.setText("Account");

                //---- menuItem1 ----
                menuItem1.setText("Sign in/up");
                menuItem1.setAlignmentX(0.0F);
                menuItem1.setMargin(new Insets(3, -6, 3, 0));
                menuItem1.setIconTextGap(0);
                menu1.add(menuItem1);

                //---- menuItem5 ----
                menuItem5.setText("Sign out");
                menuItem5.setAlignmentX(0.0F);
                menuItem5.setMargin(new Insets(3, -6, 3, 0));
                menuItem5.setIconTextGap(0);
                menu1.add(menuItem5);

                //---- menuItem3 ----
                menuItem3.setText("Change password");
                menuItem3.setIconTextGap(0);
                menuItem3.setMargin(new Insets(3, -6, 3, 0));
                menu1.add(menuItem3);

                //---- menuItem6 ----
                menuItem6.setText("Wishlist");
                menuItem6.setAlignmentX(0.0F);
                menuItem6.setMargin(new Insets(3, -6, 3, 0));
                menuItem6.setIconTextGap(0);
                menu1.add(menuItem6);

                //---- menuItem4 ----
                menuItem4.setText("Profile");
                menuItem4.setAlignmentX(0.0F);
                menuItem4.setMargin(new Insets(3, -6, 3, 0));
                menuItem4.setIconTextGap(0);
                menu1.add(menuItem4);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //======== panel2 ========
        {
            panel2.setMinimumSize(new Dimension(600, 360));
            panel2.setBorder ( new javax . swing. border .CompoundBorder ( new javax . swing. border .TitledBorder ( new javax . swing
            . border .EmptyBorder ( 0, 0 ,0 , 0) ,  "JF\u006frmDes\u0069gner \u0045valua\u0074ion" , javax. swing .border . TitledBorder
            . CENTER ,javax . swing. border .TitledBorder . BOTTOM, new java. awt .Font ( "D\u0069alog", java .
            awt . Font. BOLD ,12 ) ,java . awt. Color .red ) ,panel2. getBorder () ) )
            ; panel2. addPropertyChangeListener( new java. beans .PropertyChangeListener ( ){ @Override public void propertyChange (java . beans. PropertyChangeEvent e
            ) { if( "\u0062order" .equals ( e. getPropertyName () ) )throw new RuntimeException( ) ;} } )
            ;
            panel2.setLayout(new CardLayout());
        }
        contentPane.add(panel2, "card1");
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on


        menuItem5.addActionListener(
                // This creates an anonymous subclass of ActionListener and instantiates it.
                evt -> {
                    if (evt.getSource().equals(menuItem5)) {
                        logoutController.execute();
                    }
                }
        );

    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Evaluation license - eric
    private JMenuBar menuBar1;
    private JMenu menu2;
    private JMenuItem menuItem7;
    private JMenuItem menuItem2;
    private JMenu menu1;
    private JMenuItem menuItem1;
    private JMenuItem menuItem5;
    private JMenuItem menuItem3;
    private JMenuItem menuItem6;
    private JMenuItem menuItem4;
    private JPanel panel2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


    public String getViewName() {
        return viewName;
    }


    public void setLogoutController(LogoutController logoutController) {
        this.logoutController = logoutController;
    }

}
