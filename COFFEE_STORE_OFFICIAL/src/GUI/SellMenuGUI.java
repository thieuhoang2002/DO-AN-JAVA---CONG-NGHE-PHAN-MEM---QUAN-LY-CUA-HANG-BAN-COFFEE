package GUI;


import java.awt.*;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class SellMenuGUI extends JFrame {
    //attribute
    private JButton bSignOut, bSell, bSales, bStatistic;
    private JLabel lSell, lSales, lStatisctic, lLogOut;
    private String StaffID;
    
    Color BUTTON_BACKGROUND = new Color(162, 93, 36);
    Color BUTTON_HOVER = new Color(7, 246, 224);
    
    //constructor
    public SellMenuGUI(String staffID) {
        this.setStaffID(staffID);
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //setter and getter
    public JButton getbSignOut() {
        return bSignOut;
    }

    public void setbSignOut(JButton bSignOut) {
        this.bSignOut = bSignOut;
    }

    public JButton getbSell() {
        return bSell;
    }

    public void setbSell(JButton bSell) {
        this.bSell = bSell;
    }

    public String getStaffID() {
        return StaffID;
    }

    public final void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public JButton getbSales() {
        return bSales;
    }

    public void setbSales(JButton bSales) {
        this.bSales = bSales;
    }

    public JButton getbStatistic() {
        return bStatistic;
    }

    public void setbStatistic(JButton bStatistic) {
        this.bStatistic = bStatistic;
    }

    public JLabel getlSell() {
        return lSell;
    }

    public void setlSell(JLabel lSell) {
        this.lSell = lSell;
    }

    public JLabel getlSales() {
        return lSales;
    }

    public void setlSales(JLabel lSales) {
        this.lSales = lSales;
    }

    public JLabel getlStatisctic() {
        return lStatisctic;
    }

    public void setlStatisctic(JLabel lStatisctic) {
        this.lStatisctic = lStatisctic;
    }

    public JLabel getlLogOut() {
        return lLogOut;
    }

    public void setlLogOut(JLabel lLogOut) {
        this.lLogOut = lLogOut;
    }
    
    //method
    private void init() {
        //Tao khung chua chung
        this.setTitle("Sell Menu Form");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource\\iconJFrame.png"));
        this.setSize(new Dimension(825, 590));
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
                SignInGUI signInGUI = new SignInGUI();
            }
        });
        
        //Tao background
        ImageIcon bg = new ImageIcon("Resource\\nenMenu2.png");
        this.setContentPane(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(bg.getImage(), 0, 0, 825, 550, null);
            }

            @Override
            public void setLayout(LayoutManager mgr) {
                super.setLayout(null);
            }
        });
        
        //set components
        
        //Sell
        this.setbSell(this.createJButton(new ImageIcon("Resource\\Coffee-Shop-icon.png")));
        this.getbSell().setBounds(240, 120, 100, 80);
        this.getbSell().addActionListener((ActionEvent e) -> {
            SellGUI sellGUI = new SellGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlSell(this.createJLabel("Sell"));
        this.getlSell().setBounds(270, 200, 100, 30);
        
        //Sales
        this.setbSales(this.createJButton(new ImageIcon("Resource\\Money-icon.png")));
        this.getbSales().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(2, 0, 2, 0)));
        this.getbSales().setBounds(370, 120, 100, 80);
        this.getbSales().addActionListener((ActionEvent e) -> {
            SalesGUI salesGUI = new SalesGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlSales(this.createJLabel("Sales"));
        this.getlSales().setBounds(395, 200, 100, 30);
        
        //Statistic
        this.setbStatistic(this.createJButton(new ImageIcon("Resource\\dollar-stats-icon.png")));
        this.getbStatistic().setBounds(500, 120, 100, 80);
        this.getbStatistic().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(2, 0, 5, 0)));
        this.getbStatistic().addActionListener((ActionEvent e) -> {
            StatisticGUI statisticGUI = new StatisticGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlStatisctic(this.createJLabel("Statistic"));
        this.getlStatisctic().setBounds(513, 200, 100, 30);
        
        //Sign out
        this.setbSignOut(this.createJButton(new ImageIcon("Resource\\system-log-out-icon.png")));
        this.getbSignOut().setBounds(630, 120, 100, 80);
        this.getbSignOut().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(2, 0, 5, 0)));
        this.getbSignOut().addActionListener((ActionEvent e) -> {
            this.dispose();
            SignInGUI signInGUI = new SignInGUI();
        });
        
        this.setlLogOut(this.createJLabel("Log Out"));
        this.getlLogOut().setBounds(640, 200, 100, 30);
        
        //add
        this.add(this.getbSell());
        this.add(this.getlSell());
        this.add(this.getbSales());
        this.add(this.getlSales());
        this.add(this.getbStatistic());
        this.add(this.getlStatisctic());
        this.add(this.getbSignOut());
        this.add(this.getlLogOut());
    }
    
    //create JButton
    private JButton createJButton(Icon icon) {
        JButton button = new JButton(icon);
        button.setFocusPainted(false);
        button.setBackground(BUTTON_BACKGROUND);
        button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(15, 0, 0, 0)));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(BUTTON_HOVER);
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(BUTTON_BACKGROUND);
            }
        });
        return button;
    }
    
    //create jlabel
    private JLabel createJLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(Color.BLACK);
        label.setFont(new Font("Arial", Font.TYPE1_FONT, 20));
        return label;
    }
    
    
}
