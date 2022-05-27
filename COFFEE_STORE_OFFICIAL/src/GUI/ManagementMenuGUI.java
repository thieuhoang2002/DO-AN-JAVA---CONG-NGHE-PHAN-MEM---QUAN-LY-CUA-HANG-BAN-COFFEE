package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ManagementMenuGUI extends JFrame {
    //attribute
    private JButton bClassify, bProduct, bTopping, bBill, bStaff, bAccount, bSales, bStatistic, bLogOut, bSell;
    private JLabel lClassify, lProduct, lTopping, lBill, lStaff, lAccount, lSales, lStatistic, lLogOut, lSell;
    private String staffID;
    
    Color BUTTON_BACKGROUND = new Color(162, 93, 36);
    Color BUTTON_HOVER = new Color(7, 246, 224);
    
    //constructor
    public ManagementMenuGUI(String staffID) {
        this.setStaffID(staffID);
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //setter and getter
    public JButton getbClassify() {
        return bClassify;
    }

    public void setbClassify(JButton bClassify) {
        this.bClassify = bClassify;
    }

    public JButton getbProduct() {
        return bProduct;
    }

    public void setbProduct(JButton bProduct) {
        this.bProduct = bProduct;
    }

    public JButton getbTopping() {
        return bTopping;
    }

    public void setbTopping(JButton bTopping) {
        this.bTopping = bTopping;
    }

    public JButton getbBill() {
        return bBill;
    }

    public void setbBill(JButton bBill) {
        this.bBill = bBill;
    }

    public JButton getbStaff() {
        return bStaff;
    }

    public void setbStaff(JButton bStaff) {
        this.bStaff = bStaff;
    }

    public JButton getbAccount() {
        return bAccount;
    }

    public void setbAccount(JButton bAccount) {
        this.bAccount = bAccount;
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

    public JButton getbLogOut() {
        return bLogOut;
    }

    public void setbLogOut(JButton bLogOut) {
        this.bLogOut = bLogOut;
    }

    public JLabel getlClassify() {
        return lClassify;
    }

    public void setlClassify(JLabel lClassify) {
        this.lClassify = lClassify;
    }

    public JLabel getlProduct() {
        return lProduct;
    }

    public void setlProduct(JLabel lProduct) {
        this.lProduct = lProduct;
    }

    public JLabel getlTopping() {
        return lTopping;
    }

    public void setlTopping(JLabel lTopping) {
        this.lTopping = lTopping;
    }

    public JLabel getlBill() {
        return lBill;
    }

    public void setlBill(JLabel lBill) {
        this.lBill = lBill;
    }

    public JLabel getlStaff() {
        return lStaff;
    }

    public void setlStaff(JLabel lStaff) {
        this.lStaff = lStaff;
    }

    public JLabel getlAccount() {
        return lAccount;
    }

    public void setlAccount(JLabel lAccount) {
        this.lAccount = lAccount;
    }

    public JLabel getlSales() {
        return lSales;
    }

    public void setlSales(JLabel lSales) {
        this.lSales = lSales;
    }

    public JLabel getlStatistic() {
        return lStatistic;
    }

    public void setlStatistic(JLabel lStatistic) {
        this.lStatistic = lStatistic;
    }

    public JLabel getlLogOut() {
        return lLogOut;
    }

    public void setlLogOut(JLabel lLogOut) {
        this.lLogOut = lLogOut;
    }

    public JButton getbSell() {
        return bSell;
    }

    public void setbSell(JButton bSell) {
        this.bSell = bSell;
    }

    public JLabel getlSell() {
        return lSell;
    }

    public void setlSell(JLabel lSell) {
        this.lSell = lSell;
    }

    public String getStaffID() {
        return staffID;
    }

    public final void setStaffID(String staffID) {
        this.staffID = staffID;
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
        ImageIcon bg = new ImageIcon("Resource\\nenManagementMenu.png");
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
        
        //set Components
        //Classify
        this.setbClassify(this.createJButton(new ImageIcon("Resource\\tea-plant-leaf-icon.png")));
        this.getbClassify().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(15, 0, 5, 0)));
        this.getbClassify().setBounds(245, 100, 100, 80);
        this.getbClassify().addActionListener((ActionEvent e) -> {
            ClassifyGUI o = new ClassifyGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlClassify(this.createJLabel("Classify"));
        this.getlClassify().setBounds(255, 155, 100, 80);
        
        //Product
        this.setbProduct(this.createJButton(new ImageIcon("Resource\\drink-4-icon.png")));
        this.getbProduct().setBounds(375, 100, 100, 80);
        this.getbProduct().addActionListener((ActionEvent e) -> {
            ProductGUI productGUI = new ProductGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlProduct(this.createJLabel("Product"));
        this.getlProduct().setBounds(387, 155, 100, 80);
        
        //Topping
        this.setbTopping(this.createJButton(new ImageIcon("Resource\\pudding-icon.png")));
        this.getbTopping().setBounds(505, 100, 100, 80);
        this.getbTopping().addActionListener((ActionEvent e) -> {
            ToppingGUI o = new ToppingGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlTopping(this.createJLabel("Topping"));
        this.getlTopping().setBounds(515, 155, 100, 80);
        
        //Bill
        this.setbBill(this.createJButton(new ImageIcon("Resource\\Ecommerce-Bill-icon.png")));
        this.getbBill().setBounds(635, 100, 100, 80);
        this.getbBill().addActionListener((ActionEvent e) -> {
            BillGUI billGUI = new BillGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlBill(this.createJLabel("Bill"));
        this.getlBill().setBounds(668, 155, 100, 80);
        
        //Staff
        this.setbStaff(this.createJButton(new ImageIcon("Resource\\Office-Girl-icon.png")));
        this.getbStaff().setBounds(245, 240, 100, 80);
        this.getbStaff().addActionListener((ActionEvent e) -> {
            StaffGUI o = new StaffGUI(this.getStaffID());
            this.dispose();
        });
        
        
        this.setlStaff(this.createJLabel("Staff"));
        this.getlStaff().setBounds(270, 295, 100, 80);
        
        //Account
        this.setbAccount(this.createJButton(new ImageIcon("Resource\\preferences-desktop-online-accounts-icon.png")));
        this.getbAccount().setBounds(375, 240, 100, 80);
        this.getbAccount().addActionListener((ActionEvent e) -> {
            AccountGUI o = new AccountGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlAccount(this.createJLabel("Account"));
        this.getlAccount().setBounds(385, 295, 100, 80);
        
        //Sales
        this.setbSales(this.createJButton(new ImageIcon("Resource\\Money-icon.png")));
        this.getbSales().setBounds(505, 240, 100, 80);
        this.getbSales().addActionListener((ActionEvent e) -> {
            SalesGUI salesGUI = new SalesGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlSales(this.createJLabel("Sales"));
        this.getlSales().setBounds(530, 295, 100, 80);
        
        //Bill
        this.setbStatistic(this.createJButton(new ImageIcon("Resource\\dollar-stats-icon.png")));
        this.getbStatistic().setBounds(635, 240, 100, 80);
        this.getbStatistic().addActionListener((ActionEvent e) -> {
            StatisticGUI statisticGUI = new StatisticGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlStatistic(this.createJLabel("Statistic"));
        this.getlStatistic().setBounds(645, 295, 100, 80);
        
        //Sell
        this.setbSell(this.createJButton(new ImageIcon("Resource\\Coffee-Shop-icon.png")));
        this.getbSell().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(10, 0, 0, 0)));
        this.getbSell().setBounds(245, 380, 100, 80);
        this.getbSell().addActionListener((ActionEvent e) -> {
            SellGUI sellGUI = new SellGUI(this.getStaffID());
            this.dispose();
        });
        
        this.setlSell(this.createJLabel("Sell"));
        this.getlSell().setBounds(275, 435, 100, 80);
        
        //Log out
        this.setbLogOut(this.createJButton(new ImageIcon("Resource\\system-log-out-icon48.png")));
        this.getbLogOut().setBounds(375, 380, 100, 80);
        
        this.getbLogOut().addActionListener((ActionEvent e) -> {
            this.dispose();
            SignInGUI signInGUI = new SignInGUI();
        });
        
        this.setlLogOut(this.createJLabel("Log Out"));
        this.getlLogOut().setBounds(386, 435, 100, 80);
        
        //add
        this.add(this.getbClassify());
        this.add(this.getlClassify());
        this.add(this.getbProduct());
        this.add(this.getlProduct());
        this.add(this.getbTopping());
        this.add(this.getlTopping());
        this.add(this.getbBill());
        this.add(this.getlBill());
        this.add(this.getbStaff());
        this.add(this.getlStaff());
        this.add(this.getbAccount());
        this.add(this.getlAccount());
        this.add(this.getbSales());
        this.add(this.getlSales());
        this.add(this.getbStatistic());
        this.add(this.getlStatistic());
        this.add(this.getbSell());
        this.add(this.getlSell());
        this.add(this.getbLogOut());
        this.add(this.getlLogOut());
        
    }
    
        //create JButton
    private JButton createJButton(Icon icon) {
        JButton button = new JButton(icon);
        button.setFocusPainted(false);
        button.setBackground(BUTTON_BACKGROUND);
        button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(10, 0, 10, 0)));
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
