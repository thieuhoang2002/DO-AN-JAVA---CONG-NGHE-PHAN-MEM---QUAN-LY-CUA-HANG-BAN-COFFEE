package GUI;

import ApplicationHelper.MyDate;
import BUS.SellBUS;
import DTO.BillDTO;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public final class SalesGUI extends JFrame{
    //attribute
    private JComboBox cbcbDayStart, cbMonthStart, cbYearStart, cbDayEnd, cbcbMonthEnd, cbYearEnd;
    private JButton bSearch, bHome, bPrint;
    private JPanel pScrossBarSales, pBodySales, pInfo, pTakeAway, pSpot, pTempSpot, pTempTakeAway, pFooterSales, pTakeAwayContainer, pSpotContainer;
    private JScrollPane sTakeAway, sSpot, sTempSpot, sTempTakeAway;
    private JLabel lFrom, lTo, lCountSpotBill, lCountTakeAwayBill, lCountBetween, lSales;
    private Vector<JPanel> billPanel;
    private String staffID;
    
    Color BROWN_COLOR = new Color(145, 91, 54);
    Color BACKGROUND_COLOR = new Color(234, 231, 214);
    Color HOVER_COLOR = new Color(149, 231, 231);
    private SellBUS sellBUS;
    Color defaultColor = (Color) this.getBackground();
    
    private static String[] yearString = new String[] {"2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030", "2031"};
    private static String[] monthString = new String[] {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
    
    //constructor
    public SalesGUI(String staffID) {
        this.setStaffID(staffID);
        this.init();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    //setter and getter
    public JComboBox getcbDayStart() {
        return cbcbDayStart;
    }

    public void setcbDayStart(JComboBox cbcbDayStart) {
        this.cbcbDayStart = cbcbDayStart;
    }

    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public JComboBox getcbMonthStart() {
        return cbMonthStart;
    }

    public void setCbMonthStart(JComboBox cbMonthStart) {
        this.cbMonthStart = cbMonthStart;
    }

    public void setcbMonthStart(JComboBox cbMonthStart) {
        this.cbMonthStart = cbMonthStart;
    }

    public JComboBox getcbYearStart() {
        return cbYearStart;
    }

    public void setcbYearStart(JComboBox cbYearStart) {
        this.cbYearStart = cbYearStart;
    }

    public JComboBox getcbDayEnd() {
        return cbDayEnd;
    }

    public void setcbDayEnd(JComboBox cbDayEnd) {
        this.cbDayEnd = cbDayEnd;
    }

    public JComboBox getcbMonthEnd() {
        return cbcbMonthEnd;
    }

    public void setcbMonthEnd(JComboBox cbcbMonthEnd) {
        this.cbcbMonthEnd = cbcbMonthEnd;
    }

    public JComboBox getcbYearEnd() {
        return cbYearEnd;
    }

    public void setcbYearEnd(JComboBox cbYearEnd) {
        this.cbYearEnd = cbYearEnd;
    }

    public JButton getbSearch() {
        return bSearch;
    }

    public void setbSearch(JButton bSearch) {
        this.bSearch = bSearch;
    }

    public JButton getbHome() {
        return bHome;
    }

    public void setbHome(JButton bHome) {
        this.bHome = bHome;
    }

    public JPanel getpScrossBarSales() {
        return pScrossBarSales;
    }

    public void setpScrossBarSales(JPanel pScrossBarSales) {
        this.pScrossBarSales = pScrossBarSales;
    }

    public JPanel getpBodySales() {
        return pBodySales;
    }

    public void setpBodySales(JPanel pBodySales) {
        this.pBodySales = pBodySales;
    }

    public JPanel getpFooterSales() {
        return pFooterSales;
    }

    public void setpFooterSales(JPanel pFooterSales) {
        this.pFooterSales = pFooterSales;
    }

    public JPanel getpTakeAway() {
        return pTakeAway;
    }

    public void setpTakeAway(JPanel pTakeAway) {
        this.pTakeAway = pTakeAway;
    }

    public JPanel getpSpot() {
        return pSpot;
    }

    public void setpSpot(JPanel pSpot) {
        this.pSpot = pSpot;
    }

    public JPanel getpInfo() {
        return pInfo;
    }

    public void setpInfo(JPanel pInfo) {
        this.pInfo = pInfo;
    }

    public JPanel getpTempSpot() {
        return pTempSpot;
    }

    public void setpTempSpot(JPanel pTempSpot) {
        this.pTempSpot = pTempSpot;
    }

    public JScrollPane getsTakeAway() {
        return sTakeAway;
    }

    public void setsTakeAway(JScrollPane sTakeAway) {
        this.sTakeAway = sTakeAway;
    }

    public JScrollPane getsSpot() {
        return sSpot;
    }

    public void setsSpot(JScrollPane sSpot) {
        this.sSpot = sSpot;
    }

    public JScrollPane getsTempSpot() {
        return sTempSpot;
    }

    public void setsTempSpot(JScrollPane sTempSpot) {
        this.sTempSpot = sTempSpot;
    }

    public JPanel getpTempTakeAway() {
        return pTempTakeAway;
    }

    public void setpTempTakeAway(JPanel pTempTakeAway) {
        this.pTempTakeAway = pTempTakeAway;
    }

    public JScrollPane getsTempTakeAway() {
        return sTempTakeAway;
    }

    public void setsTempTakeAway(JScrollPane sTempTakeAway) {
        this.sTempTakeAway = sTempTakeAway;
    }
    
    public JPanel getpTakeAwayContainer() {
        return pTakeAwayContainer;
    }

    public void setpTakeAwayContainer(JPanel pTakeAwayContainer) {
        this.pTakeAwayContainer = pTakeAwayContainer;
    }

    public JPanel getpSpotContainer() {
        return pSpotContainer;
    }

    public void setpSpotContainer(JPanel pSpotContainer) {
        this.pSpotContainer = pSpotContainer;
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

    public JLabel getlCountSpotBill() {
        return lCountSpotBill;
    }

    public void setlCountSpotBill(JLabel lCountSpotBill) {
        this.lCountSpotBill = lCountSpotBill;
    }

    public JLabel getlCountTakeAwayBill() {
        return lCountTakeAwayBill;
    }

    public void setlCountTakeAwayBill(JLabel lCountTakeAwayBill) {
        this.lCountTakeAwayBill = lCountTakeAwayBill;
    }

    public JLabel getlCountBetween() {
        return lCountBetween;
    }

    public void setlCountBetween(JLabel lCountBetween) {
        this.lCountBetween = lCountBetween;
    }

    public JLabel getlSales() {
        return lSales;
    }

    public void setlSales(JLabel lSales) {
        this.lSales = lSales;
    }

    public static String[] getYearString() {
        return yearString;
    }

    public static void setYearString(String[] yearString) {
        SalesGUI.yearString = yearString;
    }

    public static String[] getMonthString() {
        return monthString;
    }

    public static void setMonthString(String[] monthString) {
        SalesGUI.monthString = monthString;
    }

    public Vector<JPanel> getBillPanel() {
        return billPanel;
    }

    public void setBillPanel(Vector<JPanel> billPanel) {
        this.billPanel = billPanel;
    }

    public SellBUS getSellBUS() {
        return sellBUS;
    }

    public void setSellBUS(SellBUS sellBUS) {
        this.sellBUS = sellBUS;
    }

    public JButton getbPrint() {
        return bPrint;
    }

    public void setbPrint(JButton bPrint) {
        this.bPrint = bPrint;
    }
    
    //method
    private void init() {
        //Create frame container
        this.setJFrame();
        
        //Set components
        //ScrossBar
        this.setScrossBarSales();
        
        //set body
        this.setBody();
        
        //pFooter
        this.setFooter();
        
        //add components to frame
        this.add(this.getpScrossBarSales(), BorderLayout.NORTH);
        this.add(this.getpBodySales(), BorderLayout.CENTER);
        this.add(this.getpFooterSales(), BorderLayout.SOUTH);
        
        
    }
    
    //set frame
    private void setJFrame() {
        this.setTitle("Sales Form");
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("Resource\\iconJFrame.png"));
        this.setSize(new Dimension(1300, 760));
        this.setResizable(false);
        this.setLayout(new BorderLayout());
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
        this.setBillPanel(new Vector<>());
        this.setSellBUS(new SellBUS());
    }
    
    //set scrossbar
    private void setScrossBarSales() {
        //Tao khung chua chung
        this.setpScrossBarSales(new JPanel());
        this.getpScrossBarSales().setPreferredSize(new Dimension(JFrame.WIDTH, 40));
        this.getpScrossBarSales().setBackground(BROWN_COLOR);
        this.getpScrossBarSales().setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 2), new EmptyBorder(0, 5, 0, 0)));
        this.getpScrossBarSales().setLayout(new BorderLayout());
        
        //set icon home
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
        
        //add
        this.getpScrossBarSales().add(this.getbHome(), BorderLayout.WEST);
        
    }
    
    //set body
    private void setBody() {
        //Tao khung chua chung
        this.setpBodySales(new JPanel());
        this.getpBodySales().setLayout(new BorderLayout());
        
        //Set components
        //Left
        this.setpInfo(new JPanel());
        this.getpInfo().setPreferredSize(new Dimension(150, JPanel.HEIGHT));
        this.getpInfo().setLayout(new BorderLayout());
        this.getpInfo().setBorder(new MatteBorder(0, 2, 0, 2, Color.DARK_GRAY));
        
        //set header for info
        JPanel pHeaderInfo = new JPanel();
        pHeaderInfo.setPreferredSize(new Dimension(JPanel.WIDTH, 40));
        pHeaderInfo.setBackground(Color.WHITE);
        pHeaderInfo.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(0, 0, 2, 0, Color.DARK_GRAY), new EmptyBorder(-2, 0, 0, 0)));
        
        JLabel lTime = new JLabel("Calendar", new ImageIcon("Resource\\Calendar-icon.png"), JLabel.CENTER);
        lTime.setFont(new Font("Arial", Font.BOLD, 18));
        
        //add lTime to pHeaderInfo
        pHeaderInfo.add(lTime);
        
        //set center for info
        JPanel pCenterInfo = new JPanel();
        pCenterInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 18));
        pCenterInfo.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(new Insets(0, 0, 2, 0), Color.BLACK), new EmptyBorder(10, 0, 0, 0)));
        
        //lStart
        JLabel lStart = new JLabel("Start:", JLabel.LEFT);
        lStart.setFont(new Font("Arial", Font.BOLD, 16));
        lStart.setPreferredSize(new Dimension(150, 30));
        
        //add components for center  
        this.setcbDayStart(new JComboBox());
        this.setcbYearStart(new JComboBox(SalesGUI.getYearString()));
        this.setcbMonthStart(new JComboBox(SalesGUI.getMonthString()));
        
        this.setcbDayEnd(new JComboBox());
        this.setcbMonthEnd(new JComboBox(SalesGUI.getMonthString()));
        this.setcbYearEnd(new JComboBox(SalesGUI.getYearString()));

        

        if(this.getSellBUS().getStaffBUS().getStaffFromId(this.getStaffID()).getPosition().equalsIgnoreCase("Manager")) {
            MyDate date = new MyDate();
            date.getDateNow();
            int dayOfMonth = MyDate.getArrDaysOfMonth()[MyDate.checkLeapYear(Integer.parseInt(date.getYear()))][Integer.parseInt(date.getMonth())];
            for(int i = 1; i <= dayOfMonth; i++) {
                this.getcbDayStart().addItem(String.format("%02d", i));
            }
            for(int i = 1; i <= dayOfMonth; i++) {
                this.getcbDayEnd().addItem(String.format("%02d", i));
            }

            this.getcbDayStart().setSelectedItem(date.getDay());
            this.getcbYearStart().setSelectedItem(date.getYear());
            this.getcbMonthStart().setSelectedItem(date.getMonth());

            this.getcbDayEnd().setSelectedItem(date.getDay());
            this.getcbMonthEnd().setSelectedItem(date.getMonth());
            this.getcbYearEnd().setSelectedItem(date.getYear());

            this.getcbMonthEnd().addActionListener((ActionEvent e) -> {
                jComboBoxEndEvent(e);
            }); 
            this.getcbYearEnd().addActionListener((ActionEvent e) -> {
                jComboBoxEndEvent(e);
            });
            this.getcbMonthStart().addActionListener((ActionEvent e) -> {
                jComboBoxStartEvent(e);
            });
            this.getcbYearStart().addActionListener((ActionEvent e) -> {
                jComboBoxStartEvent(e);
            });
        } else {
            this.setSennModelForStaff();
        }
        
        pCenterInfo.add(lStart);
        pCenterInfo.add(this.createDatePanel("○ Day", this.getcbDayStart()));
        pCenterInfo.add(this.createDatePanel("○ Month", this.getcbMonthStart()));
        pCenterInfo.add(this.createDatePanel("○ Year", this.getcbYearStart()));
        
        //set footer for info
        JPanel pFooterInfo = new JPanel();
        pFooterInfo.setPreferredSize(new Dimension(JPanel.WIDTH, 310));
        pFooterInfo.setLayout(new FlowLayout(FlowLayout.LEFT, 4, 18));
        pFooterInfo.setBorder(BorderFactory.createCompoundBorder(new MatteBorder(new Insets(0, 0, 2, 0), Color.BLACK), new EmptyBorder(10, 0, 0, 0)));
        
        //lEnd
        JLabel lEnd = new JLabel("Finish:", JLabel.LEFT);
        lEnd.setFont(new Font("Arial", Font.BOLD, 16));
        lEnd.setPreferredSize(new Dimension(150, 30));
        
        pFooterInfo.add(lEnd);
        pFooterInfo.add(this.createDatePanel("○ Day", this.getcbDayEnd()));
        pFooterInfo.add(this.createDatePanel("○ Month", this.getcbMonthEnd()));
        pFooterInfo.add(this.createDatePanel("○ Year", this.getcbYearEnd()));
        
        JPanel pSearch = new JPanel();
        pSearch.setBorder(new EmptyBorder(0, 70, 0, 0));
        this.setbSearch(new JButton("Find"));
        this.getbSearch().setPreferredSize(new Dimension(60, 30));
        this.getbSearch().setFont(new Font("Arial", Font.BOLD, 12));
        this.getbSearch().setFocusPainted(false);
        this.getbSearch().setCursor(new Cursor(HAND_CURSOR));
        this.getbSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getbSearch().setBackground(HOVER_COLOR);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                getbSearch().setBackground(defaultColor);
            }
        });
        this.getbSearch().addActionListener((ActionEvent e) -> {
            String dateStart = (String) this.getcbYearStart().getSelectedItem() + "-" + (String) this.getcbMonthStart().getSelectedItem() + "-" + (String) this.getcbDayStart().getSelectedItem();
            String dateEnd = (String) this.getcbYearEnd().getSelectedItem() + "-" + (String) this.getcbMonthEnd().getSelectedItem() + "-" + (String) this.getcbDayEnd().getSelectedItem();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = null;
            Date date2 = null;
            try {
                date1 = sdf.parse(dateStart);
                date2 = sdf.parse(dateEnd);
            } catch (ParseException ex) {
                System.err.println(ex);
            }
            if(date1.compareTo(date2) == -1 || date1.compareTo(date2) == 0) {
                createpBillList(this.getpSpot(), "Spot");
                nextCard(this.getpSpotContainer(), "Spot");
                createpBillList(this.getpTakeAway(), "Take Away");
                nextCard(this.getpTakeAwayContainer(), "Take Away");
                resetpFooter();
            } else {
                JOptionPane.showMessageDialog(SalesGUI.this, "Error! Invalid End Date!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        pSearch.add(this.getbSearch());
        
        pFooterInfo.add(pSearch);
        
        //add components to info
        this.getpInfo().add(pHeaderInfo, BorderLayout.NORTH);
        this.getpInfo().add(pCenterInfo, BorderLayout.CENTER);
        this.getpInfo().add(pFooterInfo, BorderLayout.SOUTH);
        
        //Center
        this.setpSpotContainer(new JPanel());
        this.getpSpotContainer().setLayout(new CardLayout());
        
        this.setpSpot(new JPanel());
        this.getpSpot().setPreferredSize(new Dimension(575, 5000));
        this.getpSpot().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.getpSpot().setBackground(BACKGROUND_COLOR);
        this.setsSpot(new JScrollPane(this.getpSpot(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        //set pSpotBill default la ngay hien tai
        this.createpBillList(this.getpSpot(), "Spot");
        
        //Temp
        JLabel empty1 = new JLabel("(Empty)");
        empty1.setFont(new Font("Arial", Font.ITALIC, 18));
        
        this.setpTempSpot(new JPanel());
        this.getpTempSpot().setPreferredSize(new Dimension(575, 560));
        this.getpTempSpot().setBackground(BACKGROUND_COLOR);
        this.getpTempSpot().setLayout(new BorderLayout());
        this.getpTempSpot().setBorder(new EmptyBorder(0, 250, 0, 0));
        this.getpTempSpot().add(empty1);
        this.setsTempSpot(new JScrollPane(this.getpTempSpot(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        JLabel empty2 = new JLabel("(Empty)");
        empty2.setFont(new Font("Arial", Font.ITALIC, 18));
        
        this.setpTempTakeAway(new JPanel());
        this.getpTempTakeAway().setPreferredSize(new Dimension(575, 560));
        this.getpTempTakeAway().setBackground(BACKGROUND_COLOR);
        this.getpTempTakeAway().setLayout(new BorderLayout());
        this.getpTempTakeAway().setBorder(new EmptyBorder(0, 250, 0, 0));
        this.getpTempTakeAway().add(empty2);
        this.setsTempTakeAway(new JScrollPane(this.getpTempTakeAway(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        //Right
        this.setpTakeAwayContainer(new JPanel());
        this.getpTakeAwayContainer().setLayout(new CardLayout());
        
        this.setpTakeAway(new JPanel());
        this.getpTakeAway().setPreferredSize(new Dimension(575, 5000));
        this.getpTakeAway().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.getpTakeAway().setBackground(BACKGROUND_COLOR);
        this.setsTakeAway(new JScrollPane(this.getpTakeAway(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        //set pTakeAwayBill default la ngay hien tai
        this.createpBillList(this.getpTakeAway(), "Take Away");
        
        this.getpSpotContainer().add(this.getsSpot(), "Spot");
        this.getpSpotContainer().add(this.getsTempSpot(), "Temp");
       
        this.getpTakeAwayContainer().add(this.getsTakeAway(), "Take Away");
        this.getpTakeAwayContainer().add(this.getsTempTakeAway(), "Temp");
        
        //Add
        this.getpBodySales().add(this.getpInfo(), BorderLayout.WEST);
        this.getpBodySales().add(this.createJPanelBill(this.getpSpotContainer(), "Spot Bill"), BorderLayout.CENTER);
        this.getpBodySales().add(this.createJPanelBill(this.getpTakeAwayContainer(), "Take Away Bill"), BorderLayout.EAST);
    }
    
    //set footer
    private void setFooter() {
        //Tao khung chua chung
        this.setpFooterSales(new JPanel());
        this.getpFooterSales().setPreferredSize(new Dimension(JFrame.WIDTH, 80));
        this.getpFooterSales().setBackground(BROWN_COLOR);
        this.getpFooterSales().setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 2), new EmptyBorder(0, 0, 0, 0)));
        this.getpFooterSales().setLayout(new FlowLayout(FlowLayout.LEFT, 20, 0));
        
        //JLabel dollar
        JLabel lDollar = new JLabel("SALES", new ImageIcon("Resource\\dollar-icon.png"), JLabel.LEFT);
        lDollar.setFont(new Font("Arial", Font.BOLD, 32));
        lDollar.setForeground(Color.WHITE);
        lDollar.setPreferredSize(new Dimension(200, 80));
        
        //Jlabel From and To
        JPanel pFromTo = new JPanel();
        pFromTo.setPreferredSize(new Dimension(180, 80));
        pFromTo.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 12));
        pFromTo.setBackground(BROWN_COLOR);
        pFromTo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.BLACK), BorderFactory.createEmptyBorder(0, 10, 0, 0)));
        
        MyDate date = new MyDate();
        date.getDateNow();
        this.setlFrom(new JLabel("From: " + date.toString()));
        this.getlFrom().setFont(new Font("Arial", Font.BOLD, 16));
        this.setlTo(new JLabel("To: " + date.toString()));
        this.getlTo().setFont(new Font("Arial", Font.BOLD, 16));
        
        pFromTo.add(this.getlFrom());
        pFromTo.add(this.getlTo());
        
        //JLabel countSpot, countTA, countBetween and Sales
        JPanel pCount = new JPanel();
        pCount.setPreferredSize(new Dimension(720, 80));
        pCount.setLayout(new GridLayout(1, 4));
        pCount.setBackground(BROWN_COLOR);
        
        this.setlCountSpotBill(new JLabel());
        this.getlCountSpotBill().setFont(new Font("Arial", Font.BOLD, 16));
        this.setlCountTakeAwayBill(new JLabel());
        this.getlCountTakeAwayBill().setFont(new Font("Arial", Font.BOLD, 16));
        this.setlCountBetween(new JLabel());
        this.getlCountBetween().setFont(new Font("Arial", Font.BOLD, 16));
        this.setlSales(new JLabel());
        this.getlSales().setFont(new Font("Arial", Font.BOLD, 16));
        
        pCount.add(this.getlCountSpotBill());
        pCount.add(this.getlCountTakeAwayBill());
        pCount.add(this.getlCountBetween());
        pCount.add(this.getlSales());
        
        this.resetpFooter();
        
        //button print
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
            int result = JOptionPane.showConfirmDialog(SalesGUI.this, "Do You Want To Print This Sales?", "Print Sales", JOptionPane.YES_NO_OPTION);
            if(result == JOptionPane.YES_OPTION) {
                this.getSellBUS().printSales(getStaffID(), getlFrom().getText().split("\\s")[1], getlTo().getText().split("\\s")[1], 
                                             Integer.parseInt(getlCountSpotBill().getText().split("\\s")[1]),
                                             Integer.parseInt(getlCountTakeAwayBill().getText().split("\\s")[1]),
                                             Integer.parseInt(getlCountBetween().getText().split("\\s")[1]),
                                             Double.parseDouble(getlSales().getText().split("\\s")[1]));
                JOptionPane.showMessageDialog(SalesGUI.this, "Successfully!", "Notification", JOptionPane.CLOSED_OPTION);
            }
        });
        
        //add
        this.getpFooterSales().add(lDollar);
        this.getpFooterSales().add(pFromTo);
        this.getpFooterSales().add(pCount);
        this.getpFooterSales().add(this.getbPrint());
        
    }
    
    //create pDate
    private JPanel createDatePanel(String label, JComboBox cb) {
        //Tao khung chua chung
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(150, 40));
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        //Tao JLabel
        JLabel lFist = new JLabel(label);
        lFist.setPreferredSize(new Dimension(65, 30));
        lFist.setFont(new Font("Arial", Font.BOLD, 14));
        
        //Set JComboBox
        cb.setPreferredSize(new Dimension(60, 30));
        cb.setCursor(new Cursor(HAND_CURSOR));
        
        //add componetns to JPanel
        panel.add(lFist);
        panel.add(cb);
        return panel;
    }
    
    //Create JPanel for TakeAway and Spot
    private JPanel createJPanelBill(JPanel container, String text){
        //Tao khung chua chung
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(575, JPanel.HEIGHT));
        panel.setBorder(new MatteBorder(0, 0, 0, 2, Color.BLACK));
        panel.setLayout(new BorderLayout());
        
        //set components
        //Header
        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(JPanel.WIDTH, 40));
        header.setBackground(new Color(117, 74, 43, 46));
        header.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(0, 10, 0, -15)));
        header.setLayout(new GridLayout(1, 4));
        JLabel lBillId = new JLabel("ID");
        lBillId.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel lBillDate = new JLabel("Date");
        lBillDate.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel lStaffId = new JLabel("StaffId");
        lStaffId.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel lTotal = new JLabel("Total");
        lTotal.setFont(new Font("Arial", Font.BOLD, 15));
        
        //add components to header
        header.add(lBillId);
        header.add(lBillDate);
        header.add(lStaffId);
        header.add(lTotal);
        
        //center
        container.setPreferredSize(new Dimension(JPanel.WIDTH, 564));
        
        //footer
        JPanel footer = new JPanel();
        footer.setPreferredSize(new Dimension(JPanel.WIDTH, 40));
        footer.setBackground(new Color(117, 74, 43, 46));
        footer.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), new EmptyBorder(3, 0, 0, 0)));
        
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        
        footer.add(label);
        
        //add components to panel
        panel.add(header, BorderLayout.NORTH);
        panel.add(container, BorderLayout.CENTER);
        panel.add(footer, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void jComboBoxStartEvent(ActionEvent e) {
        String dayChoose = (String)getcbDayStart().getSelectedItem();
        int temp = MyDate.getArrDaysOfMonth()[MyDate.checkLeapYear(Integer.parseInt((String)getcbYearStart().getSelectedItem()))][Integer.parseInt((String)getcbMonthStart().getSelectedItem())];
        getcbDayStart().removeAllItems();
        for(int i = 1; i <= temp; i++) {
            getcbDayStart().addItem(String.format("%02d", i));
        }
        if (Integer.parseInt(dayChoose) <= temp) {
            getcbDayStart().setSelectedItem(dayChoose);
        } else {
            getcbDayStart().setSelectedItem(temp + "");
        }
    }
    
    private void jComboBoxEndEvent(ActionEvent e) {
        String dayChoose = (String) getcbDayEnd().getSelectedItem();
        int temp = MyDate.getArrDaysOfMonth()[MyDate.checkLeapYear(Integer.parseInt((String)getcbYearEnd().getSelectedItem()))][Integer.parseInt((String)getcbMonthEnd().getSelectedItem())];
        this.getcbDayEnd().removeAllItems();
        for(int i = 1; i <= temp; i++) {
            this.getcbDayEnd().addItem(String.format("%02d", i));
        }
        if(Integer.parseInt(dayChoose) <= temp) {
            getcbDayEnd().setSelectedItem(dayChoose);
        } else {
            getcbDayEnd().setSelectedItem(temp + "");
        }
    }
    
    private JPanel createBillPanelFromBillDTO(BillDTO bill, Color color) {
        JPanel pBill = new JPanel();
        pBill.setPreferredSize(new Dimension(575, 40));
        pBill.setBorder(new EmptyBorder(0, 10, 0, 0));
        pBill.setBackground(color);
        pBill.setLayout(new GridLayout(1, 4));
        JLabel lBillId = new JLabel(bill.getBillId());
        lBillId.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel lBillDate = new JLabel(bill.getDate().toString());
        lBillDate.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel lStaffId = new JLabel(bill.getStaffId());
        lStaffId.setFont(new Font("Arial", Font.BOLD, 15));
        JLabel lTotal = new JLabel(bill.getTotal() + "");
        lTotal.setFont(new Font("Arial", Font.BOLD, 15));
        
        //add
        pBill.add(lBillId);
        pBill.add(lBillDate);
        pBill.add(lStaffId);
        pBill.add(lTotal);
        
        return pBill;
    }
    
    //set lai pSpot hoac pTakeAway sau do reset lai tren mang hinh
    private void createpBillList(JPanel pBill, String type) {
        //set ngay bat dau va ngay ket thuc
        pBill.removeAll();
        String dateStart = (String) this.getcbYearStart().getSelectedItem() + "-" + (String) this.getcbMonthStart().getSelectedItem() + "-" + (String) this.getcbDayStart().getSelectedItem();
        String dateEnd = (String) this.getcbYearEnd().getSelectedItem() + "-" + (String) this.getcbMonthEnd().getSelectedItem() + "-" + (String) this.getcbDayEnd().getSelectedItem();
        int i = 0;
        try {
            for(BillDTO bill: this.getSellBUS().getBillBUS().getBillList(type, dateStart, dateEnd)) {
                if (i%2 == 0) {
                    pBill.add(this.createBillPanelFromBillDTO(bill, Color.WHITE));
                } else {
                    pBill.add(this.createBillPanelFromBillDTO(bill, BACKGROUND_COLOR));
                }
                i++;
            }
            int height = i*40 + 1000;
            pBill.setPreferredSize(new Dimension(JPanel.WIDTH, height));
        } catch (ParseException e) {
            System.err.println("Error at createpBillList method of SalesGUI class!");
            System.err.println(e);
        }
    }
    
    private void nextCard(JPanel panel, String type) {
        CardLayout card = (CardLayout) panel.getLayout();
        card.show(panel, "Temp");
        card.show(panel, type);
    }
    
    private void resetpFooter() {
        String dateStart1 = (String) this.getcbDayStart().getSelectedItem() + "/" + (String) this.getcbMonthStart().getSelectedItem() + "/" + (String) this.getcbYearStart().getSelectedItem();
        String dateSEnd1 = (String) this.getcbDayEnd().getSelectedItem() + "/" + (String) this.getcbMonthEnd().getSelectedItem() + "/" + (String) this.getcbYearEnd().getSelectedItem();
        this.getlFrom().setText("From: " + dateStart1);
        this.getlTo().setText("To: " + dateSEnd1);
        
        String dateStart2 = (String) this.getcbYearStart().getSelectedItem() + "-" + (String) this.getcbMonthStart().getSelectedItem() + "-" + (String) this.getcbDayStart().getSelectedItem();
        String dateEnd2 = (String) this.getcbYearEnd().getSelectedItem() + "-" + (String) this.getcbMonthEnd().getSelectedItem() + "-" + (String) this.getcbDayEnd().getSelectedItem();
        
        try {
            this.getlCountSpotBill().setText("SpotBill: " + this.getSellBUS().getBillBUS().getCountBill("Spot", dateStart2, dateEnd2) + "");
            this.getlCountTakeAwayBill().setText("TakeAwayBill: " + this.getSellBUS().getBillBUS().getCountBill("Take Away", dateStart2, dateEnd2) + "");
            this.getlCountBetween().setText("Sum: " + this.getSellBUS().getBillBUS().getSumCountBill(dateStart2, dateEnd2) + "");
            this.getlSales().setText("Sales(VND): " + this.getSellBUS().getBillBUS().getTotalOfBillList(dateStart2, dateEnd2) + "");
        } catch (ParseException e) {
            System.err.println("Error at resetpFooter method of SalesGUI class!");
            System.err.println(e);
        }
    }
    
    //Neu la nhan vien chi duoc xem doanh thu cua ngay hom do
    private void setSennModelForStaff() {
        MyDate date = new MyDate();
        date.getDateNow();
        
        //Date start
        this.getcbDayStart().addItem(date.getDay());
        this.getcbDayStart().setEnabled(false);
        
        this.getcbMonthStart().removeAllItems();
        this.getcbMonthStart().addItem(date.getMonth());
        this.getcbMonthStart().setEnabled(false);
        
        this.getcbYearStart().removeAllItems();
        this.getcbYearStart().addItem(date.getYear());
        this.getcbYearStart().setEnabled(false);
        
        //Date finish
        this.getcbDayEnd().addItem(date.getDay());
        this.getcbDayEnd().setEnabled(false);
        
        this.getcbMonthEnd().removeAllItems();
        this.getcbMonthEnd().addItem(date.getMonth());
        this.getcbMonthEnd().setEnabled(false);
        
        this.getcbYearEnd().removeAllItems();
        this.getcbYearEnd().addItem(date.getYear());
        this.getcbYearEnd().setEnabled(false);
    }
}
