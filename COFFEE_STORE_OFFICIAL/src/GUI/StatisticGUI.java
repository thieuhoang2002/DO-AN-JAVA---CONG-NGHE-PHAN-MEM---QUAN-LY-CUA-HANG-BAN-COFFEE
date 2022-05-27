package GUI;

import ApplicationHelper.MyDate;
import BUS.SellBUS;
import BUS.StatisticBUS;
import DTO.StatisticProductDTO;
import DTO.StatisticToppingDTO;
import java.awt.*;
import static java.awt.Frame.HAND_CURSOR;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public final class StatisticGUI extends JFrame{
    //attribute
    private JPanel pHeader, pHeaderRight, pBody, pFooter, pBodyLeft, pBodyLeftHeader, pBodyLeftBody, pBodyLeftFooter, pBodyRight, pBodyRightProduct, pBodyRightTopping;
    
    private JScrollPane sProduct, sTopping;
    
    private JTable tbProduct, tbTopping;
    
    private DefaultTableModel productModel, toppingModel;
    
    private JButton bHome, bTopping, bProduct, bPrint, bFind, bSearch;
    
    private JTextField tfSearch;
    
    private JComboBox cbDayStart, cbMonthStart, cbYearStart, cbDayEnd, cbMonthEnd, cbYearEnd;
    
    private JLabel lCalander, lStart, lFisnish, lDayStart, lMonthStart, lYearStart, lDayEnd, lMonthEnd, lYearEnd, lStatistic, lFrom, lTo;
    
    private SellBUS sellBUS;
    
    private StatisticBUS statisticBUS;
    
    private String staffID, print;
    
    private static String[] yearString = new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"};
    private static String[] monthString = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    
    Color BROWN_COLOR = new Color(145, 91, 54);
    Color BACKGROUND_COLOR = new Color(234, 231, 214);
    Color HOVER_COLOR = new Color(149, 231, 231);
    Color defaultColor = (Color) this.getBackground();
    
    //constructor
    public StatisticGUI(String staffID) {
        this.setSellBUS(new SellBUS());
        this.setStaffID(staffID);
        this.setStatisticBUS(new StatisticBUS());
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //setter and getter
    public JPanel getpHeader() {
        return pHeader;
    }

    public void setpHeader(JPanel pHeader) {
        this.pHeader = pHeader;
    }

    public JPanel getpBody() {
        return pBody;
    }

    public void setpBody(JPanel pBody) {
        this.pBody = pBody;
    }

    public String getPrint() {
        return print;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public JPanel getpFooter() {
        return pFooter;
    }

    public void setpFooter(JPanel pFooter) {
        this.pFooter = pFooter;
    }

    public JPanel getpBodyLeft() {
        return pBodyLeft;
    }

    public void setpBodyLeft(JPanel pBodyLeft) {
        this.pBodyLeft = pBodyLeft;
    }

    public JPanel getpBodyLeftHeader() {
        return pBodyLeftHeader;
    }

    public StatisticBUS getStatisticBUS() {
        return statisticBUS;
    }

    public void setStatisticBUS(StatisticBUS statisticBUS) {
        this.statisticBUS = statisticBUS;
    }

    public void setpBodyLeftHeader(JPanel pBodyLeftHeader) {
        this.pBodyLeftHeader = pBodyLeftHeader;
    }

    public JPanel getpBodyLeftBody() {
        return pBodyLeftBody;
    }

    public void setpBodyLeftBody(JPanel pBodyLeftBody) {
        this.pBodyLeftBody = pBodyLeftBody;
    }

    public JPanel getpBodyLeftFooter() {
        return pBodyLeftFooter;
    }

    public void setpBodyLeftFooter(JPanel pBodyLeftFooter) {
        this.pBodyLeftFooter = pBodyLeftFooter;
    }

    public JScrollPane getsProduct() {
        return sProduct;
    }

    public void setsProduct(JScrollPane sProduct) {
        this.sProduct = sProduct;
    }

    public JScrollPane getsTopping() {
        return sTopping;
    }

    public void setsTopping(JScrollPane sTopping) {
        this.sTopping = sTopping;
    }

    public JButton getbHome() {
        return bHome;
    }

    public void setbHome(JButton bHome) {
        this.bHome = bHome;
    }

    public JButton getbTopping() {
        return bTopping;
    }

    public void setbTopping(JButton bTopping) {
        this.bTopping = bTopping;
    }

    public JButton getbProduct() {
        return bProduct;
    }

    public void setbProduct(JButton bProduct) {
        this.bProduct = bProduct;
    }

    public JButton getbFind() {
        return bFind;
    }

    public void setbFind(JButton bFind) {
        this.bFind = bFind;
    }

    public JButton getbSearch() {
        return bSearch;
    }

    public void setbSearch(JButton bSearch) {
        this.bSearch = bSearch;
    }

    public JTextField getTfSearch() {
        return tfSearch;
    }

    public void setTfSearch(JTextField tfSearch) {
        this.tfSearch = tfSearch;
    }

    public JComboBox getCbDayStart() {
        return cbDayStart;
    }

    public void setCbDayStart(JComboBox cbDayStart) {
        this.cbDayStart = cbDayStart;
    }

    public JComboBox getCbMonthStart() {
        return cbMonthStart;
    }

    public void setCbMonthStart(JComboBox cbMonthStart) {
        this.cbMonthStart = cbMonthStart;
    }

    public JComboBox getCbYearStart() {
        return cbYearStart;
    }

    public void setCbYearStart(JComboBox cbYearStart) {
        this.cbYearStart = cbYearStart;
    }

    public JComboBox getCbDayEnd() {
        return cbDayEnd;
    }

    public void setCbDayEnd(JComboBox cbDayEnd) {
        this.cbDayEnd = cbDayEnd;
    }

    public JComboBox getCbMonthEnd() {
        return cbMonthEnd;
    }

    public void setCbMonthEnd(JComboBox cbMonthEnd) {
        this.cbMonthEnd = cbMonthEnd;
    }

    public JComboBox getCbYearEnd() {
        return cbYearEnd;
    }

    public void setCbYearEnd(JComboBox cbYearEnd) {
        this.cbYearEnd = cbYearEnd;
    }

    public JLabel getlCalander() {
        return lCalander;
    }

    public void setlCalander(JLabel lCalander) {
        this.lCalander = lCalander;
    }

    public JLabel getlStart() {
        return lStart;
    }

    public void setlStart(JLabel lStart) {
        this.lStart = lStart;
    }

    public JLabel getlFisnish() {
        return lFisnish;
    }

    public void setlFisnish(JLabel lFisnish) {
        this.lFisnish = lFisnish;
    }

    public JLabel getlDayStart() {
        return lDayStart;
    }

    public void setlDayStart(JLabel lDayStart) {
        this.lDayStart = lDayStart;
    }

    public JLabel getlMonthStart() {
        return lMonthStart;
    }

    public void setlMonthStart(JLabel lMonthStart) {
        this.lMonthStart = lMonthStart;
    }

    public JLabel getlYearStart() {
        return lYearStart;
    }

    public void setlYearStart(JLabel lYearStart) {
        this.lYearStart = lYearStart;
    }

    public JLabel getlDayEnd() {
        return lDayEnd;
    }

    public void setlDayEnd(JLabel lDayEnd) {
        this.lDayEnd = lDayEnd;
    }

    public JLabel getlMonthEnd() {
        return lMonthEnd;
    }

    public void setlMonthEnd(JLabel lMonthEnd) {
        this.lMonthEnd = lMonthEnd;
    }

    public JLabel getlYearEnd() {
        return lYearEnd;
    }

    public void setlYearEnd(JLabel lYearEnd) {
        this.lYearEnd = lYearEnd;
    }

    public JLabel getlStatistic() {
        return lStatistic;
    }

    public void setlStatistic(JLabel lStatistic) {
        this.lStatistic = lStatistic;
    }

    public SellBUS getSellBUS() {
        return sellBUS;
    }

    public void setSellBUS(SellBUS sellBUS) {
        this.sellBUS = sellBUS;
    }

    public JPanel getpHeaderRight() {
        return pHeaderRight;
    }

    public void setpHeaderRight(JPanel pHeaderRight) {
        this.pHeaderRight = pHeaderRight;
    }

    public JPanel getpBodyRight() {
        return pBodyRight;
    }

    public void setpBodyRight(JPanel pBodyRight) {
        this.pBodyRight = pBodyRight;
    }

    public JTable getTbProduct() {
        return tbProduct;
    }

    public void setTbProduct(JTable tbProduct) {
        this.tbProduct = tbProduct;
    }

    public JTable getTbTopping() {
        return tbTopping;
    }

    public void setTbTopping(JTable tbTopping) {
        this.tbTopping = tbTopping;
    }

    public DefaultTableModel getProductModel() {
        return productModel;
    }

    public void setProductModel(DefaultTableModel productModel) {
        this.productModel = productModel;
    }

    public DefaultTableModel getToppingModel() {
        return toppingModel;
    }

    public void setToppingModel(DefaultTableModel toppingModel) {
        this.toppingModel = toppingModel;
    }

    public static String[] getYearString() {
        return yearString;
    }

    public static void setYearString(String[] yearString) {
        StatisticGUI.yearString = yearString;
    }

    public static String[] getMonthString() {
        return monthString;
    }

    public static void setMonthString(String[] monthString) {
        StatisticGUI.monthString = monthString;
    }

    public JLabel getlFrom() {
        return lFrom;
    }

    public void setlFrom(JLabel lFrom) {
        this.lFrom = lFrom;
    }

    public JLabel getlTo() {
        return lTo;
    }

    public void setlTo(JLabel lTo) {
        this.lTo = lTo;
    }

    public JButton getbPrint() {
        return bPrint;
    }

    public void setbPrint(JButton bPrint) {
        this.bPrint = bPrint;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public JPanel getpBodyRightProduct() {
        return pBodyRightProduct;
    }

    public void setpBodyRightProduct(JPanel pBodyRightProduct) {
        this.pBodyRightProduct = pBodyRightProduct;
    }

    public JPanel getpBodyRightTopping() {
        return pBodyRightTopping;
    }

    public void setpBodyRightTopping(JPanel pBodyRightTopping) {
        this.pBodyRightTopping = pBodyRightTopping;
    }
  
    //method
    public void init() {
        //set frame
        this.setJFrame();
        
        //create header
        this.createHeader();
        
        //create body
        this.createBody();
        
        //create footer
        this.createFooter();
        
        //add components to frame
        this.add(this.getpHeader(), BorderLayout.NORTH);
        this.add(this.getpBody(), BorderLayout.CENTER);
        this.add(this.getpFooter(), BorderLayout.SOUTH);
    }
    
    //set frame
    private void setJFrame() {
        this.setTitle("Statistic Form");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource\\iconJFrame.png"));
        this.setSize(new Dimension(1300, 760));
        this.setResizable(false);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                if(getSellBUS().getStaffBUS().checkPosition(getStaffID())) {
                    ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(getStaffID());
                    dispose();
                } else {
                    SellMenuGUI sellMenuGUI = new SellMenuGUI(getStaffID());
                    dispose();
                }
            }
        });
        this.setLayout(new BorderLayout());
    }
    
    //create header
    private void createHeader() {
        //create frame container
        this.setpHeader(new JPanel());
        this.getpHeader().setPreferredSize(new Dimension(JFrame.WIDTH, 40));
        this.getpHeader().setBackground(BROWN_COLOR);
        this.getpHeader().setLayout(new BorderLayout());
        this.getpHeader().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(Color.BLACK, 2), new EmptyBorder(new Insets(0, 5, 0, 0))));
        
        //create "Home" button
        this.setbHome(new JButton(new ImageIcon("Resource\\iconHome.png")));
        this.getbHome().setActionCommand("Home");
        this.getbHome().setPreferredSize(new Dimension(40, 40));
        this.getbHome().setBorder(null);
        this.getbHome().setContentAreaFilled(false);
        this.getbHome().setCursor(new Cursor(HAND_CURSOR));
        this.getbHome().setFocusPainted(false);
        //su ly su kien chuot cho nut icon "Home" JButton
        this.getbHome().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getbHome().setIcon(new ImageIcon("Resource\\iconHomeHover.png"));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                getbHome().setIcon(new ImageIcon("Resource\\iconHome.png"));
            }
        });
        this.getbHome().addActionListener((ActionEvent e) -> {
            if(this.getSellBUS().getStaffBUS().checkPosition(this.getStaffID())) {
                ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(this.getStaffID());
                this.dispose();
            } else {
                SellMenuGUI sellMenuGUI = new SellMenuGUI(this.getStaffID());
                this.dispose();
            }
        });
        
        //create pHeaderRight
        this.setpHeaderRight(new JPanel());
        this.getpHeaderRight().setLayout(new BorderLayout(0, 0));
        this.getpHeaderRight().setBackground(BROWN_COLOR);
        
        //create tfSearch
        this.setTfSearch(new JTextField(30));
        this.getTfSearch().setPreferredSize(new Dimension(100, 37));
        this.getTfSearch().setBorder(null);
        this.getTfSearch().setFont(new Font("Arial", Font.ITALIC, 15));
        
        //create "Search" button
        this.setbSearch(this.createJButton("Search", 100, 37, Color.LIGHT_GRAY));
        
        this.getbSearch().addActionListener((ActionEvent e) -> {
            String dateStart = this.getCbYearStart().getSelectedItem() + "-" + this.getCbMonthStart().getSelectedItem() + "-" + this.getCbDayStart().getSelectedItem();
            String dateEnd = this.getCbYearEnd().getSelectedItem() + "-" + this.getCbMonthEnd().getSelectedItem() + "-" + this.getCbDayEnd().getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateS = null;
            Date dateE = null;
            try {
                dateS = sdf.parse(dateStart);
                dateE = sdf.parse(dateEnd);
            } catch (ParseException ex) {
                System.err.println("Error at event bSearch in StatisticGUI!");
                System.err.println(e);
            }
            if(dateS.compareTo(dateE) == -1 || dateS.compareTo(dateE) == 0) {
                fillStatisticProductDataToTable(this.getTfSearch().getText(), dateStart, dateEnd);
                fillStatisticToppingDataToTable(this.getTfSearch().getText(), dateStart, dateEnd);
            } else {
                JOptionPane.showMessageDialog(StatisticGUI.this, "Error! Invalid End Date!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        //add components to pHeader
        this.getpHeader().add(this.getbHome(), BorderLayout.WEST);
        
        this.getpHeaderRight().add(this.getTfSearch(), BorderLayout.WEST);
        this.getpHeaderRight().add(this.getbSearch(), BorderLayout.EAST);
        
        this.getpHeader().add(this.getpHeaderRight(), BorderLayout.EAST);
    }
    
    //create button
    private JButton createJButton(String text, int width, int height, Color color) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(width, height));
        button.setBackground(color);
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(null);
        button.setCursor(new Cursor(HAND_CURSOR));
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(HOVER_COLOR);
                button.setFont(new Font("Arial", Font.BOLD, 18));
                button.setBorder(BorderFactory.createLoweredBevelBorder());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(color);
                button.setFont(new Font("Arial", Font.BOLD, 16));
                button.setBorder(null);
            }
        });
        button.addActionListener((ActionEvent e) -> {
            if(e.getSource().equals(getbProduct())) {
                CardLayout card = (CardLayout) getpBodyRight().getLayout();
                card.show(getpBodyRight(), "Product");
                this.setPrint("Product");
            } else if(e.getSource().equals(getbTopping())) {
                CardLayout card = (CardLayout) getpBodyRight().getLayout();
                card.show(getpBodyRight(), "Topping");
                this.setPrint("Topping");
            }
        });
        return button;
    }
    //create body
    private void createBody() {
        //create frame container
        this.setpBody(new JPanel());
        this.getpBody().setLayout(new BorderLayout());
        
        //set pBodyleft
        this.setpBodyLeft(new JPanel());
        this.getpBodyLeft().setPreferredSize(new Dimension(150, JPanel.HEIGHT));
        this.getpBodyLeft().setBackground(Color.RED);
        this.getpBodyLeft().setLayout(new BorderLayout());
        
        //set components in pBodyLeft
        //header
        this.setpBodyLeftHeader(new JPanel());
        this.getpBodyLeftHeader().setBackground(Color.WHITE);
        this.getpBodyLeftHeader().setPreferredSize(new Dimension(JPanel.WIDTH, 40));
        this.getpBodyLeftHeader().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK), new EmptyBorder(new Insets(-2, 0, 0, 0))));
        this.setlCalander(new JLabel("Calendar", new ImageIcon("Resource\\Calendar-icon.png"), (int) JLabel.CENTER_ALIGNMENT));
        this.getlCalander().setFont(new Font("Arial", Font.BOLD, 18));
        
        this.getpBodyLeftHeader().add(this.getlCalander());
        
        //body
        this.setpBodyLeftBody(new JPanel());
        this.getpBodyLeftBody().setBackground(Color.LIGHT_GRAY);
        this.getpBodyLeftBody().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        this.getpBodyLeftBody().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK), new EmptyBorder(24, 5, 0, 0)));
        
        this.setlStart(new JLabel("Start:"));
        this.getlStart().setFont(new Font("Arial", Font.BOLD, 16));
        this.setlDayStart(new JLabel("○ Day"));
        this.setCbDayStart(new JComboBox());
        this.setlMonthStart(new JLabel("○ Month"));
        this.setCbMonthStart(new JComboBox(StatisticGUI.getMonthString()));
        this.getCbMonthStart().setActionCommand("Month Start");
        this.setlYearStart(new JLabel("○ Year"));
        this.setCbYearStart(new JComboBox(StatisticGUI.getYearString()));
        this.getCbYearStart().setActionCommand("Year Start");
        this.getpBodyLeftBody().add(this.getlStart());
        this.getpBodyLeftBody().add(this.createJPanelCB(this.getlDayStart(), this.getCbDayStart()));
        this.getpBodyLeftBody().add(this.createJPanelCB(this.getlMonthStart(), this.getCbMonthStart()));
        this.getpBodyLeftBody().add(this.createJPanelCB(this.getlYearStart(), this.getCbYearStart()));
        
        //footer
        this.setpBodyLeftFooter(new JPanel());
        this.getpBodyLeftFooter().setBackground(Color.LIGHT_GRAY);
        this.getpBodyLeftFooter().setPreferredSize(new Dimension(JPanel.WIDTH, 310));
        this.getpBodyLeftFooter().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
        this.getpBodyLeftFooter().setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 2, 0, 2, Color.BLACK), new EmptyBorder(24, 5, 0, 0)));
        
        this.setlFisnish(new JLabel("Finish:"));
        this.getlFisnish().setFont(new Font("Arial", Font.BOLD, 16));
        this.setlDayEnd(new JLabel("○ Day"));
        this.setCbDayEnd(new JComboBox());
        this.setlMonthEnd(new JLabel("○ Month"));
        this.setCbMonthEnd(new JComboBox(StatisticGUI.getMonthString()));
        this.getCbMonthEnd().setActionCommand("Month End");
        this.setlYearEnd(new JLabel("○ Year"));
        this.setCbYearEnd(new JComboBox(StatisticGUI.getYearString()));
        this.getCbYearEnd().setActionCommand("Year End");
        
        if(this.getSellBUS().getStaffBUS().getStaffFromId(this.getStaffID()).getPosition().equalsIgnoreCase("Manager")){
            this.setDateNowForComBoBox(this.getCbDayStart(), this.getCbMonthStart(), this.getCbYearStart());
            this.setDateNowForComBoBox(this.getCbDayEnd(), this.getCbMonthEnd(), this.getCbYearEnd());

            //set su kien cho cac cb
            this.getCbMonthStart().addActionListener((ActionEvent e) -> {
                setDate(this.getCbDayStart(), this.getCbMonthStart(), this.getCbYearStart());
            });
            this.getCbYearStart().addActionListener((ActionEvent e) -> {
                setDate(this.getCbDayStart(), this.getCbMonthStart(), this.getCbYearStart());
            });
            this.getCbMonthEnd().addActionListener((ActionEvent e) -> {
                setDate(this.getCbDayEnd(), this.getCbMonthEnd(), this.getCbYearEnd());
            });
            this.getCbYearEnd().addActionListener((ActionEvent e) -> {
                setDate(this.getCbDayEnd(), this.getCbMonthEnd(), this.getCbYearEnd());
        });
        } else {
            setSeenModelForStaff();
        }
        
        
        //set button FIND
        JPanel pFind = new JPanel();
        pFind.setPreferredSize(new Dimension(140, 40));
        pFind.setLayout(new FlowLayout(FlowLayout.RIGHT, 2, 0));
        pFind.setBorder(new EmptyBorder(0, 0, 0, 3));
        pFind.setBackground(Color.LIGHT_GRAY);
        this.setbFind(new JButton("Find"));
        this.getbFind().setPreferredSize(new Dimension(80, 35));
        this.getbFind().setFont(new Font("Arial", Font.BOLD, 15));
        this.getbFind().setFocusPainted(false);
        this.getbFind().setBorder(BorderFactory.createLoweredSoftBevelBorder());
        this.getbFind().setCursor(new Cursor(HAND_CURSOR));
        this.getbFind().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getbFind().setBackground(HOVER_COLOR);
                getbFind().setFont(new Font("Arial", Font.BOLD, 17));
                getbFind().setBorder(BorderFactory.createLoweredBevelBorder());
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                getbFind().setBackground(defaultColor);
                getbFind().setFont(new Font("Arial", Font.BOLD, 15));
                getbFind().setBorder(BorderFactory.createLoweredSoftBevelBorder());
            }
            
        });
        this.getbFind().addActionListener((ActionEvent e) -> {
            String dateStart = getCbYearStart().getSelectedItem() + "-" + getCbMonthStart().getSelectedItem() + "-" + getCbDayStart().getSelectedItem();
            String dateEnd = getCbYearEnd().getSelectedItem() + "-" + getCbMonthEnd().getSelectedItem() + "-" + getCbDayEnd().getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date dateS = null;
            Date dateE = null;
            try {
                dateS = sdf.parse(dateStart);
                dateE = sdf.parse(dateEnd);
            } catch (ParseException ex) {
                System.err.println("Error at event Find!");
                System.err.println(ex);
            }
            if(dateS.compareTo(dateE) == -1 || dateS.compareTo(dateE) == 0 ) {
                fillStatisticProductDataToTable(dateStart, dateEnd);
                fillStatisticToppingDataToTable(dateStart, dateEnd);
                setFromTo();
            } else {
                JOptionPane.showMessageDialog(StatisticGUI.this, "Error! Invalid End Date!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        
        this.getpBodyLeftFooter().add(this.getlFisnish());
        this.getpBodyLeftFooter().add(this.createJPanelCB(this.getlDayEnd(), this.getCbDayEnd()));
        this.getpBodyLeftFooter().add(this.createJPanelCB(this.getlMonthEnd(), this.getCbMonthEnd()));
        this.getpBodyLeftFooter().add(this.createJPanelCB(this.getlYearEnd(), this.getCbYearEnd()));
        pFind.add(this.getbFind());
        this.getpBodyLeftFooter().add(pFind);
        
        
        this.getpBodyLeft().add(this.getpBodyLeftHeader(), BorderLayout.NORTH);
        this.getpBodyLeft().add(this.getpBodyLeftBody(), BorderLayout.CENTER);
        this.getpBodyLeft().add(this.getpBodyLeftFooter(), BorderLayout.SOUTH);
        
        //set pBodyRight
        this.setpBodyRight(new JPanel());
        this.getpBodyRight().setPreferredSize(new Dimension(JPanel.WIDTH, JPanel.HEIGHT));
        this.getpBodyRight().setLayout(new CardLayout());
        
        this.setProductModel(new DefaultTableModel());
        this.setTbProduct(new JTable(this.getProductModel()));
        
        this.setToppingModel(new DefaultTableModel());
        this.setTbTopping(new JTable(this.getToppingModel()));
        this.getTbTopping().getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        
        this.setsProduct(new JScrollPane(this.getTbProduct()));
        this.getsProduct().setPreferredSize(new Dimension(JPanel.WIDTH, JPanel.HEIGHT));
        this.getsProduct().getViewport().setBackground(new Color(230, 222, 178));
        
        this.setsTopping(new JScrollPane(this.getTbTopping()));
        this.getsTopping().getViewport().setBackground(new Color(230, 222, 178));
        
        this.getpBodyRight().add(this.getsProduct(), "Product");
        this.getpBodyRight().add(this.getsTopping(), "Topping");
        
        this.setPrint("Product");
        
        //set colums in table product
        this.getProductModel().addColumn("ProductName");
        this.getProductModel().addColumn("Price/S");
        this.getProductModel().addColumn("QtyS");
        this.getProductModel().addColumn("SalesS");
        this.getProductModel().addColumn("Price/M");
        this.getProductModel().addColumn("QtyM");
        this.getProductModel().addColumn("SalesM");
        this.getProductModel().addColumn("Price/L");
        this.getProductModel().addColumn("QtyL");
        this.getProductModel().addColumn("SalesL");
        this.getProductModel().addColumn("CountSum");
        this.getProductModel().addColumn("SalesSum");
        
        this.getTbProduct().getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));
        this.getTbProduct().getColumnModel().getColumn(0).setPreferredWidth(180);
        this.getTbProduct().setBackground(BACKGROUND_COLOR);
        
        //set colums in table topping
        this.getToppingModel().addColumn("ToppingID");
        this.getToppingModel().addColumn("ToppingName");
        this.getToppingModel().addColumn("Price/Topping");
        this.getToppingModel().addColumn("Quantity");
        this.getToppingModel().addColumn("Sales");
        
        this.getTbTopping().setBackground(BACKGROUND_COLOR);
        
        //Khoi dong chuc nang se mac dinh la thong ke cua ngay hien tai
        MyDate date = new MyDate();
        date.getDateNow();
        String dateNow = date.getYear() + "-" + date.getMonth() + "-" + date.getDay();
        this.fillStatisticProductDataToTable(dateNow, dateNow);
        this.fillStatisticToppingDataToTable(dateNow, dateNow);
        
        //add
        this.getpBody().add(this.getpBodyLeft(), BorderLayout.WEST);
        this.getpBody().add(this.getpBodyRight(), BorderLayout.CENTER);
    }
    
    //create footer
    private void createFooter() {
        //create frame container
        this.setpFooter(new JPanel());
        this.getpFooter().setPreferredSize(new Dimension(JFrame.WIDTH, 60));
        this.getpFooter().setBackground(BROWN_COLOR);
        this.getpFooter().setBorder(new LineBorder(Color.BLACK, 2));
        this.getpFooter().setLayout(new BorderLayout());
        
        //set components of getpFooter
        //West
        this.setlStatistic(new JLabel("Statistic", new ImageIcon("Resource\\statistics2-icon.png"), JLabel.CENTER));
        this.getlStatistic().setFont(new Font("Arial", Font.BOLD, 32));
        this.getlStatistic().setForeground(Color.WHITE);
        this.getlStatistic().setPreferredSize(new Dimension(250, 50));
        this.getlStatistic().setBorder(new MatteBorder(new Insets(0, 0, 0, 1), Color.BLACK));
        
        //Center
        JPanel panelFromTo = new JPanel();
        panelFromTo.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelFromTo.setBorder(new EmptyBorder(0, 0, -10, 0));
        panelFromTo.setBackground(BROWN_COLOR);
        
        MyDate date = new MyDate();
        date.getDateNow();
                
        this.setlFrom(new JLabel("From: " + date.toString()));
        this.getlFrom().setFont(new Font("Arial", Font.BOLD, 15));
        this.getlFrom().setPreferredSize(new Dimension(200, 20));
        this.setlTo(new JLabel("To: " + date.toString()));
        this.getlTo().setFont(new Font("Arial", Font.BOLD, 15));
        this.getlTo().setPreferredSize(new Dimension(200, 20));
        
        panelFromTo.add(this.getlFrom());
        panelFromTo.add(this.getlTo());
        
        //East
        JPanel tempContainer = new JPanel();
        tempContainer.setPreferredSize(new Dimension(850, 80));
        tempContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 8));
        tempContainer.setBorder(new EmptyBorder(0, -200, 0, 0));
        tempContainer.setBackground(BROWN_COLOR);
        this.setbProduct(this.createJButton("Product", 100, 40, Color.LIGHT_GRAY));
        this.setbTopping(this.createJButton("Topping", 100, 40, Color.LIGHT_GRAY));
        this.setbPrint(new JButton(new ImageIcon("Resource\\print-icon.png")));
        this.getbPrint().setPreferredSize(new Dimension(100, 40));
        this.getbPrint().setFocusPainted(false);
        this.getbPrint().setCursor(new Cursor(HAND_CURSOR));
        this.getbPrint().setBackground(BROWN_COLOR);
        this.getbPrint().setBorder(null);
        this.getbPrint().setContentAreaFilled(false);
        this.getbPrint().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getbPrint().setIcon(new ImageIcon("Resource\\print-icon-hover.png"));
            }
            
            @Override
            public void mouseReleased(MouseEvent e) {
                getbPrint().setIcon(new ImageIcon("Resource\\print-icon.png"));
            }
        });
        this.getbPrint().addActionListener((ActionEvent e) -> {
            if(this.getPrint().equalsIgnoreCase("Topping")) {
                int result = JOptionPane.showConfirmDialog(StatisticGUI.this, "Do You Want To Print This Toppings Statistic?", "Print Toppings Statistic", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    this.getStatisticBUS().printToppingStatistic(this.getTbTopping(), this.getlFrom().getText().split("\\s")[1], this.getlTo().getText().split("\\s")[1], this.getStaffID());
                    JOptionPane.showMessageDialog(StatisticGUI.this, "Successfully!", "Notification", JOptionPane.CLOSED_OPTION);
                }
            } else {
                int result = JOptionPane.showConfirmDialog(StatisticGUI.this, "Do You Want To Print This Products Statistic?", "Print Products Statistic", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                   this.getStatisticBUS().printProductStatistic(this.getTbProduct(), this.getlFrom().getText().split("\\s")[1], this.getlTo().getText().split("\\s")[1], this.getStaffID());
                   JOptionPane.showMessageDialog(StatisticGUI.this, "Successfully!", "Notification", JOptionPane.CLOSED_OPTION);
                }
            }
  
        });
        
        tempContainer.add(this.getbProduct());
        tempContainer.add(this.getbTopping());
        tempContainer.add(this.getbPrint());
        
        //add
        this.getpFooter().add(this.getlStatistic(), BorderLayout.WEST);
        this.getpFooter().add(panelFromTo, BorderLayout.CENTER);
        this.getpFooter().add(tempContainer, BorderLayout.EAST);
        
    }
    
    //create panel chua cb
    private JPanel createJPanelCB(JLabel label, JComboBox cb) {
        JPanel panel= new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(new Dimension(140, 50));
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setPreferredSize(new Dimension(65, 30));
        cb.setPreferredSize(new Dimension(60, 30));
        cb.setCursor(new Cursor(HAND_CURSOR));
        panel.add(label);
        panel.add(cb);
        panel.setBackground(Color.LIGHT_GRAY);
        return panel;
    }
        
    //Set cac cb la ngay hien tai
    private void setDateNowForComBoBox(JComboBox day, JComboBox month, JComboBox year) {
        MyDate date = new MyDate();
        date.getDateNow();
        
        month.setSelectedItem(date.getMonth());
        year.setSelectedItem(date.getYear());
        
        int dayOfMonth = MyDate.getArrDaysOfMonth()[MyDate.checkLeapYear(Integer.parseInt((String) year.getSelectedItem()))][Integer.parseInt((String) month.getSelectedItem())];
        for(int i = 1; i <= dayOfMonth; i++) {
            day.addItem(String.format("%02d", i));
        }
        day.setSelectedItem(date.getDay());
    }
    
    //set lai ngay khi tac dong vao cb month or year
    private void setDate(JComboBox day, JComboBox month, JComboBox year) {
        String temp = (String) day.getSelectedItem();
        day.removeAllItems();
        int dayOfMonth = MyDate.getArrDaysOfMonth()[MyDate.checkLeapYear(Integer.parseInt((String) year.getSelectedItem()))][Integer.parseInt((String) month.getSelectedItem())];
        for(int i = 1; i <= dayOfMonth; i++) {
            day.addItem(String.format("%02d", i));
        }
        if(Integer.parseInt(temp) <= dayOfMonth) {
            day.setSelectedItem(temp);
        } else {
            day.setSelectedItem(dayOfMonth + "");
        }
    }
    
    //Nhan vien chi duoc xem thong ke san pham theo ngay
    private void setSeenModelForStaff() {
        MyDate date = new MyDate();
        date.getDateNow();
        
        //Date start
        this.getCbDayStart().addItem(date.getDay());
        this.getCbDayStart().setEnabled(false);
        
        this.getCbMonthStart().removeAllItems();
        this.getCbMonthStart().addItem(date.getMonth());
        this.getCbMonthStart().setEnabled(false);
        
        this.getCbYearStart().removeAllItems();
        this.getCbYearStart().addItem(date.getYear());
        this.getCbYearStart().setEnabled(false);
        
        //Date finish
        this.getCbDayEnd().addItem(date.getDay());
        this.getCbDayEnd().setEnabled(false);
        
        this.getCbMonthEnd().removeAllItems();
        this.getCbMonthEnd().addItem(date.getMonth());
        this.getCbMonthEnd().setEnabled(false);
        
        this.getCbYearEnd().removeAllItems();
        this.getCbYearEnd().addItem(date.getYear());
        this.getCbYearEnd().setEnabled(false);
    }
    
    //method fill data statistic of product to table
    private void fillStatisticProductDataToTable(String dateStart, String dateEnd) {
        this.getProductModel().setRowCount(0);
        for(StatisticProductDTO statistic: this.getStatisticBUS().getSatisticProductDTO(dateStart, dateEnd)) {
            this.getProductModel().addRow(new Object[] {this.getSellBUS().getProductBUS().getProductFromId(statistic.getProductId()).getProductName(),
                                                        this.getSellBUS().getProductSizeBUS().getPriceToStatistic(statistic.getProductId(), "S"), statistic.getSalesOfSize()[0][0], 
                                                        statistic.getSalesOfSize()[1][0], this.getSellBUS().getProductSizeBUS().getPriceToStatistic(statistic.getProductId(), "M"),
                                                        statistic.getSalesOfSize()[0][1], statistic.getSalesOfSize()[1][1],
                                                        this.getSellBUS().getProductSizeBUS().getPriceToStatistic(statistic.getProductId(), "L"), statistic.getSalesOfSize()[0][2],
                                                        statistic.getSalesOfSize()[1][2], statistic.getSalesOfSize()[0][3], statistic.getSalesOfSize()[1][3]});                                         
        }
    }
    
    //method fill date statistic of topping to table
    private void fillStatisticToppingDataToTable(String dateStart, String dateEnd) {
        this.getToppingModel().setRowCount(0);
        for(StatisticToppingDTO statisticTopping: this.getStatisticBUS().getStatisticToppingList(dateStart, dateEnd)) {
            this.getToppingModel().addRow(new Object[] {statisticTopping.getToppingId(), this.getSellBUS().getToppingBUS().getToppingFromId(statisticTopping.getToppingId()).getToppingName(),
            this.getSellBUS().getToppingBUS().getPriceFromId(statisticTopping.getToppingId()), statisticTopping.getQuantity(), statisticTopping.getSales()});
        }
    }
    
    //method fill data statistic of product to table from keyWord and date
    private void fillStatisticProductDataToTable(String keyWord, String dateStart, String dateEnd) {
        this.getProductModel().setRowCount(0);
        for(StatisticProductDTO statisticProduct: this.getStatisticBUS().getStatisticProductList(keyWord, dateStart, dateEnd)) {
            this.getProductModel().addRow(new Object[] {this.getSellBUS().getProductBUS().getProductFromId(statisticProduct.getProductId()).getProductName(),
                                                        this.getSellBUS().getProductSizeBUS().getPriceToStatistic(statisticProduct.getProductId(), "S"), statisticProduct.getSalesOfSize()[0][0], 
                                                        statisticProduct.getSalesOfSize()[1][0], this.getSellBUS().getProductSizeBUS().getPriceToStatistic(statisticProduct.getProductId(), "M"),
                                                        statisticProduct.getSalesOfSize()[0][1], statisticProduct.getSalesOfSize()[1][1],
                                                        this.getSellBUS().getProductSizeBUS().getPriceToStatistic(statisticProduct.getProductId(), "L"), statisticProduct.getSalesOfSize()[0][2],
                                                        statisticProduct.getSalesOfSize()[1][2], statisticProduct.getSalesOfSize()[0][3], statisticProduct.getSalesOfSize()[1][3]}); 
        }
    }
    
    //method fill data statistic of topping to table from keyWord and date
    private void fillStatisticToppingDataToTable(String keyWord, String dateStart, String dateEnd) {
        this.getToppingModel().setRowCount(0);
        for(StatisticToppingDTO statisticTopping: this.getStatisticBUS().getStatisticToppingList(keyWord, dateStart, dateEnd)) {
            this.getToppingModel().addRow(new Object[] {statisticTopping.getToppingId(), this.getSellBUS().getToppingBUS().getToppingFromId(statisticTopping.getToppingId()).getToppingName(),
            this.getSellBUS().getToppingBUS().getPriceFromId(statisticTopping.getToppingId()), statisticTopping.getQuantity(), statisticTopping.getSales()});
        }
    }
    
    //set lFrom and lTo
    private void setFromTo() {
        String dateFrom = this.getCbDayStart().getSelectedItem() + "/" + this.getCbMonthStart().getSelectedItem() + "/" + this.getCbYearStart().getSelectedItem();
        String dateTo = this.getCbDayEnd().getSelectedItem() + "/" + this.getCbMonthEnd().getSelectedItem() + "/" + this.getCbYearEnd().getSelectedItem();
        this.getlFrom().setText("From: " + dateFrom);
        this.getlTo().setText("To: " + dateTo);
    }
}
