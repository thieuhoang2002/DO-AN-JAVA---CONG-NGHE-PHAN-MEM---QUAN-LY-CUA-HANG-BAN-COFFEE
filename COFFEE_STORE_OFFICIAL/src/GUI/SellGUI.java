package GUI;

import ApplicationHelper.ID;
import ApplicationHelper.MyDate;
import BUS.SellBUS;
import DTO.BillDetail_ToppingDTO;
import DTO.ClassifyDTO;
import DTO.ProductDTO;
import DTO.TableDTO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.border.*;

public final class SellGUI extends JFrame{
    //attribute
    private JPanel pOrderInfo, pOrderHeader, pOrderBodyContainer, pOrderBody, pOrderBodyTemp, pOrderFooter,
                   pMenus, pHeaderMenus, pBodyMenus, pScrossBar1, pEastScrossBar1, pClassifyMenu, pSrossBar2, pTable, pItemMenu, pTemp;
    
    private JScrollPane sOrderBody, sOrderBodyTemp, sItemMenu, sTemp;
    
    private ArrayList<JButton> buttonList;
    
    private ArrayList<JPanel> detailPanelList;
    
    private ArrayList<TablePanelGUI> panelList;
    
    private JButton bNew, bDel, bHome, bSearch, bOk;
    
    private JLabel lOrder, lBillId, lResultBillId, lDateNow, lResultDateNow, lStaffId, lResultStaffId, lTableId, lResultTableId, lTotal, lReceived, lExcess, lToTalResult, lExcessResult;
    
    private CardLayout card;
    
    private JTextField tfSearch, tfReceived;
    
    private SellBUS sellBUS;
    
    private String billID;
    
    private String staffId;
    
    Color BROWN_COLOR = new Color(145, 91, 54);
    Color BACKGROUND_COLOR = new Color(234, 231, 214);
    Color HOVER_COLOR = new Color(149, 231, 231);
    Color BUTTON_COLOR = new Color(239, 228, 200);
    Color defaultColor = (Color) this.getBackground();
    
    //constructor
    public SellGUI(String staffId) {
        this.setStaffId(staffId);
        this.init();
        //Xoa nhung don hang mang ve chua thanh toan do gap su co he thong nhu cup dien, tat nguon, het pin
        this.getSellBUS().getBillBUS().deleteTakeAwayBillDoesNotPayment();
        this.setVisible(true);
    }

    //setter and getter
    public JLabel getlTableId() {
        return lTableId;
    }

    public void setlTableId(JLabel lTableId) {
        this.lTableId = lTableId;
    }

    public ArrayList<JPanel> getDetailPanelList() {
        return detailPanelList;
    }

    public void setDetailPanelList(ArrayList<JPanel> detailPanelList) {
        this.detailPanelList = detailPanelList;
    }

    public String getStaffId() {
        return staffId;
    }
    
    public void setStaffId(String staffId) {    
        this.staffId = staffId;
    }

    public JScrollPane getsOrderBodyTemp() {
        return sOrderBodyTemp;
    }

    public void setsOrderBodyTemp(JScrollPane sOrderBodyTemp) {
        this.sOrderBodyTemp = sOrderBodyTemp;
    }

    public JPanel getpOrderBodyContainer() {
        return pOrderBodyContainer;
    }

    public void setpOrderBodyContainer(JPanel pOrderBodyContainer) {
        this.pOrderBodyContainer = pOrderBodyContainer;
    }

    public JPanel getpOrderBodyTemp() {
        return pOrderBodyTemp;
    }

    public void setpOrderBodyTemp(JPanel pOrderBodyTemp) {
        this.pOrderBodyTemp = pOrderBodyTemp;
    }
    
    public JPanel getpOrderInfo() {
        return pOrderInfo;
    }

    public JTextField getTfReceived() {
        return tfReceived;
    }

    public JLabel getlResultBillId() {
        return lResultBillId;
    }

    public void setlResultBillId(JLabel lResultBillId) {
        this.lResultBillId = lResultBillId;
    }

    public JLabel getlResultDateNow() {
        return lResultDateNow;
    }

    public void setlResultDateNow(JLabel lResultDateNow) {
        this.lResultDateNow = lResultDateNow;
    }

    public JLabel getlResultStaffId() {
        return lResultStaffId;
    }

    public void setlResultStaffId(JLabel lResultStaffId) {
        this.lResultStaffId = lResultStaffId;
    }

    public JLabel getlResultTableId() {
        return lResultTableId;
    }

    public void setlResultTableId(JLabel lResultTableId) {
        this.lResultTableId = lResultTableId;
    }

    public JPanel getpEastScrossBar1() {
        return pEastScrossBar1;
    }

    public void setpEastScrossBar1(JPanel pEastScrossBar1) {
        this.pEastScrossBar1 = pEastScrossBar1;
    }

    public JButton getbDel() {
        return bDel;
    }

    public void setbDel(JButton bDel) {
        this.bDel = bDel;
    }

    public JLabel getlToTalResult() {
        return lToTalResult;
    }

    public void setlToTalResult(JLabel lToTalResult) {
        this.lToTalResult = lToTalResult;
    }

    public JLabel getlExcessResult() {
        return lExcessResult;
    }

    public void setlExcessResult(JLabel lExcessResult) {
        this.lExcessResult = lExcessResult;
    }
    
    

    public void setTfReceived(JTextField tfReceived) {
        this.tfReceived = tfReceived;
    }

    public void setpOrderInfo(JPanel pOrderInfo) {
        this.pOrderInfo = pOrderInfo;
    }

    public JPanel getpOrderHeader() {
        return pOrderHeader;
    }

    public void setpOrderHeader(JPanel pOrderHeader) {
        this.pOrderHeader = pOrderHeader;
    }

    public JPanel getpOrderBody() {
        return pOrderBody;
    }

    public void setpOrderBody(JPanel pOrderBody) {
        this.pOrderBody = pOrderBody;
    }

    public JPanel getpOrderFooter() {
        return pOrderFooter;
    }

    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public void setpOrderFooter(JPanel pOrderFooter) {
        this.pOrderFooter = pOrderFooter;
    }

    public JPanel getpMenus() {
        return pMenus;
    }

    public void setpMenus(JPanel pMenus) {
        this.pMenus = pMenus;
    }

    public JPanel getpHeaderMenus() {
        return pHeaderMenus;
    }

    public void setpHeaderMenus(JPanel pHeaderMenus) {
        this.pHeaderMenus = pHeaderMenus;
    }

    public JPanel getpBodyMenus() {
        return pBodyMenus;
    }

    public void setpBodyMenus(JPanel pBodyMenus) {
        this.pBodyMenus = pBodyMenus;
    }

    public JPanel getpScrossBar1() {
        return pScrossBar1;
    }

    public void setpScrossBar1(JPanel pScrossBar1) {
        this.pScrossBar1 = pScrossBar1;
    }

    public JPanel getpClassifyMenu() {
        return pClassifyMenu;
    }

    public void setpClassifyMenu(JPanel pClassifyMenu) {
        this.pClassifyMenu = pClassifyMenu;
    }

    public JPanel getpScrossBar2() {
        return pSrossBar2;
    }

    public void setpSrossBar2(JPanel pSrossBar2) {
        this.pSrossBar2 = pSrossBar2;
    }

    public JScrollPane getsOrderBody() {
        return sOrderBody;
    }

    public void setsOrderBody(JScrollPane sOrderBody) {
        this.sOrderBody = sOrderBody;
    }

    public ArrayList<JButton> getButtonList() {
        return buttonList;
    }

    public void setButtonList(ArrayList<JButton> buttonList) {
        this.buttonList = buttonList;
    }

    public JButton getbNew() {
        return bNew;
    }

    public void setbNew(JButton bNew) {
        this.bNew = bNew;
    }

    public JButton getbHome() {
        return bHome;
    }

    public void setbHome(JButton bHome) {
        this.bHome = bHome;
    }

    public JLabel getlOrder() {
        return lOrder;
    }

    public void setlOrder(JLabel lOrder) {
        this.lOrder = lOrder;
    }

    public JButton getbOk() {
        return bOk;
    }

    public void setbOk(JButton bOk) {
        this.bOk = bOk;
    }

    public void setCard(CardLayout card) {
        this.card = card;
    }

    public CardLayout getCard() {
        return card;
    }

    public SellBUS getSellBUS() {
        return sellBUS;
    }

    public void setSellBUS(SellBUS sellBUS) {
        this.sellBUS = sellBUS;
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

    public JPanel getpTemp() {
        return pTemp;
    }

    public void setpTemp(JPanel pTemp) {
        this.pTemp = pTemp;
    }
    
    public JScrollPane getsTemp() {
        return sTemp;
    }

    public void setsTemp(JScrollPane sTemp) {
        this.sTemp = sTemp;
    }

    public JPanel getpTable() {
        return pTable;
    }

    public void setpTable(JPanel pTable) {
        this.pTable = pTable;
    }

    public JScrollPane getsItemMenu() {
        return sItemMenu;
    }

    public void setsItemMenu(JScrollPane sItemMenu) {
        this.sItemMenu = sItemMenu;
    }

    public JPanel getpItemMenu() {
        return pItemMenu;
    }

    public void setpItemMenu(JPanel pItemMenu) {
        this.pItemMenu = pItemMenu;
    }

    public ArrayList<TablePanelGUI> getPanelList() {
        return panelList;
    }

    public void setPanelList(ArrayList<TablePanelGUI> panelList) {
        this.panelList = panelList;
    }

    public JLabel getlBillId() {
        return lBillId;
    }

    public void setlBillId(JLabel lBillId) {
        this.lBillId = lBillId;
    }

    public JLabel getlDateNow() {
        return lDateNow;
    }

    public void setlDateNow(JLabel lDateNow) {
        this.lDateNow = lDateNow;
    }

    public JLabel getlStaffId() {
        return lStaffId;
    }

    public void setlStaffId(JLabel lStaffId) {
        this.lStaffId = lStaffId;
    }

    public JLabel getlTotal() {
        return lTotal;
    }

    public void setlTotal(JLabel lTotal) {
        this.lTotal = lTotal;
    }

    public JLabel getlReceived() {
        return lReceived;
    }

    public void setlReceived(JLabel lReceived) {
        this.lReceived = lReceived;
    }

    public JLabel getlExcess() {
        return lExcess;
    }

    public void setlExcess(JLabel lExcess) {
        this.lExcess = lExcess;
    }
    
    //method
    private void init() {
        this.setDetailPanelList(new ArrayList<>());
        this.setSellBUS(new SellBUS());
        //Tao cua so ung dung
        this.createJFrame();
        
        //Tao khung chua thong tin don hang ben trai (pOrderInfo)
        this.createpOrderInfo();
        
        //Tao khung chua cac menu ben phai (pMenus)
        this.createpMenus();
        
        //Them cac thanh phan vao JFrame
        this.add(this.getpOrderInfo(), BorderLayout.WEST);
        this.add(this.getpMenus(), BorderLayout.CENTER);   
    }
    
    //Tao cua so ung dung (JFrame Container)
    private void createJFrame() {
        this.setTitle("Sell Form");
        this.setIconImage(Toolkit.getDefaultToolkit().createImage("Resource\\iconJFrame.png"));
        this.setSize(1300, 760);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        //Su dung thay cho this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
                //Dang bam bill mang ve ma thoat ra :))) thi xoa bill mang ve do. Khi mo lai ung dung thi bam lai
                if(getlResultTableId().getText().equalsIgnoreCase("")) {
                    getSellBUS().getBillBUS().deleteBill(getlResultBillId().getText());
                }
                if(getSellBUS().getStaffBUS().checkPosition(getStaffId())) {
                    ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(getStaffId());
                    dispose();
                } else {
                    SellMenuGUI sellMenuGUI = new SellMenuGUI(getStaffId());
                    dispose();
                }
            }
        });
        this.setLayout(new BorderLayout());
    }
    
    //Tao khung chua thong tin don hang ben trai
    private void createpOrderInfo() {
        //Tao khung chua chung
        this.setpOrderInfo(new JPanel());
        this.getpOrderInfo().setPreferredSize(new Dimension(420, JFrame.MAXIMIZED_VERT));
        this.getpOrderInfo().setLayout(new BorderLayout());
        
        //Header
        this.setpOrderHeader(new JPanel());
        this.getpOrderHeader().setPreferredSize(new Dimension(420, 100));
        this.getpOrderHeader().setBackground(new Color(229, 167, 123));
        this.getpOrderHeader().setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 2), new EmptyBorder(2, 10, 2, 2)));
        this.getpOrderHeader().setLayout(new GridLayout(4, 1, 5, 5));
        
        //Tao JLabel lBIllID
        this.setlBillId(this.createJLabelForOrder("Order  : ", Color.BLACK));
        this.setBillID(ID.createBillId());
        this.setlResultBillId(this.createJLabelForOrder(this.getBillID(), Color.BLACK));
        
        JPanel billTemp = new JPanel();
        billTemp.setLayout(new BorderLayout());
        billTemp.add(this.getlBillId(), BorderLayout.WEST);
        billTemp.add(this.getlResultBillId(), BorderLayout.CENTER);
        billTemp.setBackground(new Color(229, 167, 123));
        
        //Tao JLabel lDateNow
        MyDate dateNow = new MyDate();
        dateNow.getDateNow();
        this.setlDateNow(this.createJLabelForOrder("Date    : ", Color.BLACK));
        this.setlResultDateNow(this.createJLabelForOrder(dateNow.toString(), Color.BLACK));
        
        
        JPanel dateTemp = new JPanel();
        dateTemp.setLayout(new BorderLayout());
        dateTemp.add(this.getlDateNow(), BorderLayout.WEST);
        dateTemp.add(this.getlResultDateNow(), BorderLayout.CENTER);
        dateTemp.setBackground(new Color(229, 167, 123));
        
        //Tao JLabel StaffName
        this.setlStaffId(this.createJLabelForOrder("Staff    : ", Color.BLACK));
        this.setlResultStaffId(this.createJLabelForOrder(this.getSellBUS().getStaffBUS().getStaffFromId(this.getStaffId()).getStaffName(), Color.BLACK));
        
        JPanel staffTemp = new JPanel();
        staffTemp.setLayout(new BorderLayout());
        staffTemp.add(this.getlStaffId(), BorderLayout.WEST);
        staffTemp.add(this.getlResultStaffId(), BorderLayout.CENTER);
        staffTemp.setBackground(new Color(229, 167, 123));
        
        //Tao JLabel TableId
        this.setlTableId(this.createJLabelForOrder("", Color.BLACK));
        this.setlResultTableId(this.createJLabelForOrder("", Color.BLACK));
        
        JPanel tableTemp = new JPanel();
        tableTemp.setLayout(new BorderLayout());
        tableTemp.add(this.getlTableId(), BorderLayout.WEST);
        tableTemp.add(this.getlResultTableId(), BorderLayout.CENTER);
        tableTemp.setBackground(new Color(229, 167, 123));
        
        //Them cac thanh phan vao Header
        this.getpOrderHeader().add(billTemp);
        this.getpOrderHeader().add(dateTemp);
        this.getpOrderHeader().add(staffTemp);
        this.getpOrderHeader().add(tableTemp);
        
        //Body
        this.setpOrderBody(new JPanel());
        this.getpOrderBody().setPreferredSize(new Dimension(400, 5000));
        this.getpOrderBody().setBackground(BACKGROUND_COLOR);
        this.getpOrderBody().setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setsOrderBody(new JScrollPane(this.getpOrderBody(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        this.setpOrderBodyTemp(new JPanel());
        this.getpOrderBodyTemp().setPreferredSize(new Dimension(400, JPanel.HEIGHT));
        this.getpOrderBodyTemp().setBackground(BACKGROUND_COLOR);
        this.setsOrderBodyTemp(new JScrollPane(this.getpOrderBodyTemp(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        this.setpOrderBodyContainer(new JPanel());
        this.getpOrderBodyContainer().setLayout(new CardLayout());
        
        this.getpOrderBodyContainer().add(this.getsOrderBodyTemp(), "OrderBodyTemp");
        this.getpOrderBodyContainer().add(this.getsOrderBody(), "OrderBody");
        
        //Footer
        this.setpOrderFooter(new JPanel());
        this.getpOrderFooter().setPreferredSize(new Dimension(400, 150));
        this.getpOrderFooter().setBackground(BROWN_COLOR);
        this.getpOrderFooter().setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK, 2), new EmptyBorder(2, 10, 10, 2)));
        this.getpOrderFooter().setLayout(new GridLayout(3, 3, 5, 5));
        
        //Tao phan JLabel total
        this.setlTotal(this.createJLabelForOrder("Total:", Color.WHITE));
        
        //Tao JLabel lTotalResult
        this.setlToTalResult(this.createJLabelForOrder("0.00", Color.WHITE));
        
        //Tao phan JLabel received
        this.setlReceived(this.createJLabelForOrder("Received:", Color.WHITE));
        
        //Tao panel chua JTextField va tfReceived
        JPanel panelReceived = new JPanel();
        panelReceived.setLayout(new BorderLayout(2, 2));
        panelReceived.setBackground(Color.LIGHT_GRAY);
        
        //Tao JTextField tfReceived;
        this.setTfReceived(new JTextField(10));
        this.getTfReceived().setFont(new Font("Arial", Font.BOLD, 15));
        this.getTfReceived().setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.BLACK));
        this.getTfReceived().setCursor(new Cursor(TEXT_CURSOR));
        this.getTfReceived().setBackground(new Color(235, 238, 236));
        
        //Tao button ok
        this.setbOk(new JButton("OK"));
        this.getbOk().setPreferredSize(new Dimension(50, 50));
        this.getbOk().setFocusPainted(false);
        this.getbOk().setCursor(new Cursor(HAND_CURSOR));
        this.getbOk().setBorder(BorderFactory.createLoweredBevelBorder());
        this.getbOk().setFont(new Font("Arial", Font.BOLD, 15));
        this.getbOk().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                getbOk().setBackground(HOVER_COLOR);
                getbOk().setFont(new Font("Arial", Font.BOLD, 18));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                getbOk().setBackground(defaultColor);
                getbOk().setFont(new Font("Arial", Font.BOLD, 15));
            }
        });
        this.getbOk().addActionListener((ActionEvent e) -> {
            if(Double.parseDouble(getlToTalResult().getText()) != 0 && !getTfReceived().getText().equals("")) {
                if (Double.parseDouble(getTfReceived().getText()) < Double.parseDouble(getlToTalResult().getText())) {
                    JOptionPane.showMessageDialog(SellGUI.this, "Invalid Received Money! Please Check Again!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Double excess = Double.parseDouble(getTfReceived().getText()) - Double.parseDouble(getlToTalResult().getText());
                    getlExcessResult().setText(excess + "");
                }
            }
        });
        
        //Them cac thanh phan vao panelReceived
        panelReceived.add(this.getbOk(), BorderLayout.EAST);
        panelReceived.add(this.getTfReceived(), BorderLayout.WEST);
        
        
        //Tao phan JLabel excess
        this.setlExcess(this.createJLabelForOrder("Excess Cash:", Color.WHITE));
        
        //Tao JLabel lExcessResult
        this.setlExcessResult(this.createJLabelForOrder("0.00", Color.WHITE));
                
        //Them cac thanh phan vao footer
        this.getpOrderFooter().add(this.getlTotal());
        this.getpOrderFooter().add(this.getlToTalResult());
        this.getpOrderFooter().add(this.getlReceived());
        this.getpOrderFooter().add(panelReceived);
        this.getpOrderFooter().add(this.getlExcess());
        this.getpOrderFooter().add(this.getlExcessResult());
        
        //Them cac thanh phan vao panel pOderInfo
        this.getpOrderInfo().add(this.getpOrderHeader(), BorderLayout.NORTH);
        this.getpOrderInfo().add(this.getpOrderBodyContainer(), BorderLayout.CENTER);
        this.getpOrderInfo().add(this.getpOrderFooter(), BorderLayout.SOUTH);
    }
    
    //Tao khung chua cac menu ben phai
    private void createpMenus() {
        //Tao khung chua chung
        this.setpMenus(new JPanel());
        this.getpMenus().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
        this.getpMenus().setLayout(new BorderLayout());

        //Khung chua chung cho thanh phan phia North
        this.setpHeaderMenus(new JPanel());
        this.getpHeaderMenus().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 300));
        this.getpHeaderMenus().setLayout(new BorderLayout());
        
        //pSrossBar1
        this.setpScrossBar1(new JPanel());
        this.getpScrossBar1().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 40));
        this.getpScrossBar1().setBackground(BROWN_COLOR);
        this.getpScrossBar1().setBorder(BorderFactory.createMatteBorder(2, 0, 2, 2, Color.BLACK));
        this.getpScrossBar1().setLayout(new BorderLayout());
        
        //set pEastScrossBar1
        this.setpEastScrossBar1(new JPanel(new BorderLayout()));
        
        //Set button "New"
        this.setbNew(new JButton("New"));
        this.getbNew().setActionCommand("New");
        this.getbNew().setPreferredSize(new Dimension(70, 20));
        this.getbNew().setBackground(BROWN_COLOR);
        this.getbNew().setForeground(Color.WHITE);
        this.getbNew().setFont(new Font("Arial", Font.BOLD, 22));
        this.getbNew().setBorder(null);
        //delete khung bao jbutton moi khi nhap vao (mac dinh)
        this.getbNew().setFocusPainted(false);
        //Di chuot vao doi tuong va doi thanh hinh ban tay
        this.getbNew().setCursor(new Cursor(HAND_CURSOR));
        //Su ly su kien chuot cho "New" JButton
        this.getbNew().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseEntered(MouseEvent e) {
               getbNew().setBackground(HOVER_COLOR);
               getbNew().setForeground(Color.BLACK);
               getbNew().setBorder(BorderFactory.createRaisedBevelBorder());
           }
           
           @Override
           public void mouseExited(MouseEvent e) {
               getbNew().setBackground(BROWN_COLOR);
               getbNew().setForeground(Color.WHITE);
               getbNew().setBorder(null);
           }
        });
        this.getbNew().addActionListener((ActionEvent e) -> {
            if(this.getSellBUS().getBillBUS().checkExists(this.getlResultBillId().getText()) == false) {
                int result = JOptionPane.showConfirmDialog(SellGUI.this, "Do You Want To Create A New Bill?", "Create A New Bill", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    if(this.getlResultTableId().getText().equalsIgnoreCase("")) {
                        this.getSellBUS().getBillBUS().deleteBill(this.getlResultBillId().getText());
                    }
                    setNewOrder();
                    resetAndNextCardTable();
                }
                
            }
        });
        
        //Set button pDel
        this.setbDel(new JButton("Del"));
        this.getbDel().setActionCommand("Del");
        this.getbDel().setPreferredSize(new Dimension(70, 20));
        this.getbDel().setBackground(BROWN_COLOR);
        this.getbDel().setForeground(Color.WHITE);
        this.getbDel().setFont(new Font("Arial", Font.BOLD, 22));
        this.getbDel().setBorder(null);
        //delete khung bao jbutton moi khi nhap vao (mac dinh)
        this.getbDel().setFocusPainted(false);
        //Di chuot vao doi tuong va doi thanh hinh ban tay
        this.getbDel().setCursor(new Cursor(HAND_CURSOR));
        //Su ly su kien chuot cho "Del" JButton
        this.getbDel().addMouseListener(new MouseAdapter() {
           @Override
           public void mouseEntered(MouseEvent e) {
               getbDel().setBackground(HOVER_COLOR);
               getbDel().setForeground(Color.BLACK);
               getbDel().setBorder(BorderFactory.createRaisedBevelBorder());
           }
           
           @Override
           public void mouseExited(MouseEvent e) {
               getbDel().setBackground(BROWN_COLOR);
               getbDel().setForeground(Color.WHITE);
               getbDel().setBorder(null);
           }
        });
        this.getbDel().addActionListener((ActionEvent e) -> {
            if(this.getSellBUS().getBillBUS().checkExists(this.getlResultBillId().getText()) == false) {
                int result = JOptionPane.showConfirmDialog(SellGUI.this, "Do You Want To Delete This Bill?", "Delete", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    getSellBUS().getBillBUS().deleteBill(getlResultBillId().getText());
                    setNewOrder();
                    resetAndNextCardTable();
                }
            }
        });
        
        
        //set button has home icon
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
            if(this.getSellBUS().getStaffBUS().checkPosition(this.getStaffId())) {
                ManagementMenuGUI managementMenuGUI = new ManagementMenuGUI(this.getStaffId());
                this.dispose();
            } else {
                SellMenuGUI sellMenuGUI = new SellMenuGUI(this.getStaffId());
                this.dispose();
            }
        });
        
        //add button New and Del to pEastScrossBar1
        this.getpEastScrossBar1().add(this.getbDel(), BorderLayout.WEST);
        this.getpEastScrossBar1().add(this.getbNew(), BorderLayout.EAST);
        
        //add components to pScrossBar1
        this.getpScrossBar1().add(this.getbHome(), BorderLayout.WEST);
         
        this.getpScrossBar1().add(this.getpEastScrossBar1(), BorderLayout.EAST);
        
        
        //pClassifyMenu
        this.setpClassifyMenu(new JPanel());
        this.getpClassifyMenu().setBackground(BACKGROUND_COLOR);
        this.getpClassifyMenu().setLayout(new GridLayout(2, 6, 10, 10));
        this.getpClassifyMenu().setBorder(new EmptyBorder(10, 10, 10, 10));
        
        //hien thi menu classify
        this.setButtonList(new ArrayList<>());
        this.setPanelList(new ArrayList<>());
        this.createClassifyButtonList();
        this.addComponentsInButtonListToJPanel(this.getButtonList(), this.getpClassifyMenu());

        //pScrossBar2
        this.setpSrossBar2(new JPanel());
        this.getpScrossBar2().setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 40));
        this.getpScrossBar2().setBackground(BROWN_COLOR);
        Border matteBorder = BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK);
        Border emptyBorder = BorderFactory.createEmptyBorder(0, 170, 0, 0);
        this.getpScrossBar2().setBorder(BorderFactory.createCompoundBorder(matteBorder, emptyBorder));
        this.getpScrossBar2().setLayout(new BorderLayout());
        
        //set label "Order"
        this.setlOrder(new JLabel("Order"));
        this.getlOrder().setFont(new Font("Arial", Font.ITALIC, 24));
        this.getlOrder().setForeground(Color.BLACK);
        this.getlOrder().setPreferredSize(new Dimension(220, 40));
        
        //set jtextfield search
        this.setTfSearch(new JTextField("search product here"));
        this.getTfSearch().setFont(new Font("Arial", Font.ITALIC, 16));
        this.getTfSearch().setBackground(new Color(235, 238, 236));
        this.getTfSearch().setBorder(BorderFactory.createRaisedBevelBorder());
        
        //set button search
        this.setbSearch(new JButton("Search"));
        this.getbSearch().setPreferredSize(new Dimension(100, 40));
        this.getbSearch().setFocusPainted(false);
        this.getbSearch().setFont(new Font("Arial", Font.BOLD, 18));
        this.getbSearch().setBackground(Color.LIGHT_GRAY);
        this.getbSearch().setCursor(new Cursor(HAND_CURSOR));
        this.getbSearch().setBorder(BorderFactory.createRaisedBevelBorder());
        this.getbSearch().addMouseListener(new MouseAdapter() {      
            @Override
            public void mouseEntered(MouseEvent e) {
                getbSearch().setBackground(HOVER_COLOR);
                getbSearch().setFont(new Font("Arial", Font.BOLD, 20));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                getbSearch().setBackground(Color.LIGHT_GRAY);
                getbSearch().setFont(new Font("Arial", Font.BOLD, 18));
            }
        });
        this.getbSearch().addActionListener((ActionEvent e) -> {
            if(this.getTfSearch().getText().equalsIgnoreCase("") || this.getTfSearch().getText().equalsIgnoreCase("search product here")) {
                JOptionPane.showMessageDialog(SellGUI.this, "Empty Search Box!", "Search Product", JOptionPane.OK_OPTION);
            } else {
                createProductButtonSearchList(getTfSearch().getText());
                getpItemMenu().removeAll();
                addComponentsInButtonListToJPanel(getButtonList(), getpItemMenu());
                getCard().show(getpBodyMenus(), "Item");
            }
        });
        
        this.getTfSearch().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                getCard().show(getpBodyMenus(), "Temp");
                getTfSearch().setText("");
            }
        });
        
        //add label "Order" to pScrossBar2
        this.getpScrossBar2().add(this.getlOrder(), BorderLayout.WEST);
        this.getpScrossBar2().add(this.getTfSearch(), BorderLayout.CENTER);
        this.getpScrossBar2().add(this.getbSearch(), BorderLayout.EAST);
        
        
        //Center
        this.setpBodyMenus(new JPanel());
        this.setCard(new CardLayout());
        this.getpBodyMenus().setLayout(this.getCard());
        
        
        this.setpTable(this.createItemMenuJPanel());
        this.getpTable().setBackground(new Color(194, 179, 152, 76));
        this.getpTable().setLayout(new FlowLayout(FlowLayout.LEFT, 12, 12));
        this.getpTable().setBorder(new EmptyBorder(4, 0, 0, 0));
        
        //create table panel list
        this.createpTable();
        
        this.setpItemMenu(this.createItemMenuJPanel());

        this.setpTemp(this.createItemMenuJPanel());
        
        //create JScollPane contains JPanel contains Products
        this.setsItemMenu(new JScrollPane(this.getpItemMenu(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        this.setsTemp(new JScrollPane(this.getpTemp(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER));
        
        this.getpBodyMenus().add(this.getpTable(), "Table");
        this.getpBodyMenus().add(this.getsItemMenu(), "Item");
        this.getpBodyMenus().add(this.getsTemp(), "Temp");
        
        //Them cac thanh phan vao panel pMenus
        this.getpHeaderMenus().add(this.getpScrossBar1(), BorderLayout.NORTH);
        this.getpHeaderMenus().add(this.getpClassifyMenu(), BorderLayout.CENTER);
        this.getpHeaderMenus().add(this.getpScrossBar2(), BorderLayout.SOUTH);
        
                
        this.getpMenus().add(this.getpHeaderMenus(), BorderLayout.NORTH);
        this.getpMenus().add(this.getpBodyMenus(), BorderLayout.CENTER);
        
        //End: pMenus
    }
    
    private JButton createChooseDrinkJButton(String text, String actioncommand, Border border) {
        JButton o = new JButton();
        o.setText(text);
        o.setActionCommand(actioncommand);
        o.setBackground(BUTTON_COLOR);
        o.setFocusPainted(false);
        o.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 17));
        o.setPreferredSize(new Dimension(158, 90));
        o.setBorder(border);
        o.setCursor(new Cursor(HAND_CURSOR));
        o.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                o.setBackground(HOVER_COLOR);
                o.setFont(new Font("Arial", Font.BOLD, 19));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                o.setBackground(BUTTON_COLOR);
                o.setFont(new Font("Arial", Font.LAYOUT_NO_LIMIT_CONTEXT, 17));
            }
        });
        o.addActionListener((ActionEvent e) -> {
            if (e.getActionCommand().equalsIgnoreCase("Table")) {
                getCard().show(getpBodyMenus(), "Table");
            } else if (e.getActionCommand().contains("CL0")) {
                getpItemMenu().removeAll();
                createProductButtonList(e.getActionCommand());
                addComponentsInButtonListToJPanel(getButtonList(), getpItemMenu());
                getCard().show(getpBodyMenus(), "Temp");
                getCard().show(getpBodyMenus(), "Item");
            } else if (!e.getActionCommand().equals("")) {
                ChoiceMenuOfProductGUI choiceMenu = new ChoiceMenuOfProductGUI(e.getActionCommand(), this);
                choiceMenu.getBtnCheck().setActionCommand("AddBill");
            }
        });
        return o;
    }
    
    private JButton createPaymentJButton() {
        JButton o = new JButton("Payment");
        o.setBackground(new Color(18, 247, 51));
        o.setBorder(BorderFactory.createRaisedBevelBorder());
        o.setFocusPainted(false);
        o.setCursor(new Cursor(HAND_CURSOR) {
        });
        o.setForeground(Color.WHITE);
        o.setFont(new Font("Arial", Font.BOLD, 17));
        o.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                o.setFont(new Font("Arial", Font.BOLD, 21));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                o.setFont(new Font("Arial", Font.BOLD, 17));
            }
        });
        o.addActionListener((ActionEvent e) -> {
            String billId = this.getlResultBillId().getText();
            if(this.getSellBUS().getBillBUS().getBillFromId(billId) != null) {
                Double received, excess;
                if(this.getTfReceived().getText().equals("")) {
                    received = 0.0;
                    excess = 0.0;
                } else {
                    received = Double.parseDouble(this.getTfReceived().getText());
                    excess = Double.parseDouble(this.getlExcessResult().getText());
                }

                this.getSellBUS().getBillBUS().updateBill(billId, true, received, excess);
                if(!this.getlResultTableId().getText().equalsIgnoreCase("")) {
                    this.getSellBUS().getTableBUS().updateStatusTable(this.getlResultTableId().getText(), true);
                }
                int result = JOptionPane.showConfirmDialog(SellGUI.this, "Do You Want To Print This Bill?", "Print Bill", JOptionPane.YES_NO_OPTION);
                if(result == JOptionPane.YES_OPTION) {
                    this.getSellBUS().printBill(billId);
                    JOptionPane.showMessageDialog(SellGUI.this, "Successfully!", "Notification", JOptionPane.CLOSED_OPTION);
                }
                this.setNewOrder();
                this.resetAndNextCardTable();
            }
            
        });
        return o;
    }
    
    private void setNewOrder() {
        //Tao mot billID moi hien thi len man hinh
        this.getlResultBillId().setText(ID.createBillId());
        
        this.getlTableId().setText("");
        this.getlResultTableId().setText("");
        this.getlToTalResult().setText("0.0");
        this.getTfReceived().setText("");
        this.getlExcessResult().setText("0.0");
        
        this.getDetailPanelList().clear();
        
        this.getpOrderBody().removeAll();
        
        CardLayout cardTemp = (CardLayout) this.getpOrderBodyContainer().getLayout();
        cardTemp.show(this.getpOrderBodyContainer(), "OrderBodyTemp");
        cardTemp.show(this.getpOrderBodyContainer(), "OrderBody");
        
    }
    
    private void addComponentsInButtonListToJPanel(ArrayList<JButton> list, JPanel jpanel) {
        for(JButton o: list) {
            jpanel.add(o);
        }
    }
    
    private void createClassifyButtonList() {
        this.getButtonList().clear();
        this.getpClassifyMenu().removeAll();
        Border mix = BorderFactory.createCompoundBorder(BorderFactory.createRaisedBevelBorder(), BorderFactory.createLoweredBevelBorder());
        Border line = BorderFactory.createTitledBorder(mix, "Menu", TitledBorder.RIGHT, TitledBorder.BELOW_TOP, new Font("Arial", Font.ITALIC, 10), Color.BLACK);
        this.getButtonList().add(this.createChooseDrinkJButton("Table", "Table", line));
        this.getSellBUS().getClassifyBUS().resetList();
        for(ClassifyDTO classify: this.getSellBUS().getClassifyBUS().getClassifyList()) {
            if(classify.isClassifyBusiness()) {
                this.getButtonList().add(this.createChooseDrinkJButton(classify.getClassifyName(), classify.getClassifyId(), line));
            }
        }
        if(this.getButtonList().size() < 11) {
            for(int i = this.getButtonList().size(); i < 11; i++) {
                this.getButtonList().add(this.createChooseDrinkJButton("", "", BorderFactory.createRaisedSoftBevelBorder()));
            }
        }
        this.getButtonList().add(this.createPaymentJButton());
    }
    
    private void createProductButtonList(String classifyId) {
        this.getButtonList().clear();
        this.getSellBUS().getProductBUS().resetList();
        for(ProductDTO product: this.getSellBUS().getProductBUS().getProductList()) {
            if(product.isProductBusiness() && product.getClassifyId().equalsIgnoreCase(classifyId)) {      
                this.getButtonList().add(this.createChooseDrinkJButton(product.getProductNickName(), product.getProductId(), BorderFactory.createRaisedBevelBorder()));
            }
        }
    }
    
    private void createProductButtonSearchList(String search) {
        this.getButtonList().clear();
        for(ProductDTO product: this.getSellBUS().getProductBUS().getProductList(search)) {
            this.getButtonList().add(this.createChooseDrinkJButton(product.getProductNickName(), product.getProductId(), BorderFactory.createRaisedBevelBorder()));
        }
    }
    
    private JPanel createItemMenuJPanel() {
        JPanel o = new JPanel();
        o.setBackground(BACKGROUND_COLOR);
        o.setPreferredSize(new Dimension(JFrame.MAXIMIZED_HORIZ, 1000));
        o.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
        return o;
    }
    
    private void createTablePanelList() {
        this.getPanelList().clear();
        for(TableDTO table: this.getSellBUS().getTableBUS().getTableList()) {
            this.getPanelList().add(new TablePanelGUI(table.getTableId(), this));
        }
    }
    
    private void addComponentsInTablePanelListToJPanel(ArrayList<TablePanelGUI> panelList, JPanel panel) {
        panel.removeAll();
        for(TablePanelGUI o: panelList) {
            panel.add(o);
        }
    }
    
    private JLabel createJLabelForOrder(String text, Color color) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 15));
        label.setForeground(color);
        return label;
    }
    
    public JPanel createDetailBillPanel(String detailBillId) {
        this.getSellBUS().getDetailBillBUS().resetList();
        JPanel detailPanel = new JPanel();
        detailPanel.setBackground(new Color(208, 187, 173));
        detailPanel.setLayout(new BorderLayout());
        detailPanel.setName(detailBillId.trim());
        detailPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        detailPanel.setCursor(new Cursor(HAND_CURSOR));
        detailPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JPanel newDetail = (JPanel) e.getSource();
                ChoiceMenuOfProductGUI edit = new ChoiceMenuOfProductGUI(getSellBUS().getDetailBillBUS().getDetailBillFromId(detailBillId).getProductId(), detailBillId, SellGUI.this);
                edit.getBtnCheck().setActionCommand("Edit");
                        
            }    
        });
        
        //tao nut xoa chi tiet hoa don
        JButton delete = new JButton(new ImageIcon("Resource\\tp_minus.png"));
        delete.setPreferredSize(new Dimension(20, JPanel.HEIGHT));
        delete.setBackground(Color.LIGHT_GRAY);
        delete.setActionCommand(detailBillId);
        delete.setFocusPainted(false);
        delete.setBorder(BorderFactory.createLoweredBevelBorder());
        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(new Color(210, 210, 209));
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                JButton button = (JButton) e.getSource();
                button.setBackground(Color.LIGHT_GRAY);
            }
        });
        delete.addActionListener((ActionEvent e) -> {
            this.getSellBUS().getDetailBillBUS().deleteDetailBill(detailBillId);
            for(JPanel detail: getDetailPanelList()) {
                if(detail.getName().equalsIgnoreCase(detailBillId.trim())) {
                    getDetailPanelList().remove(detail);
                    break;
                }
            }
            this.getpOrderBody().removeAll();
            this.addDetailPanelListToPOrderBody();
            nextCardOrder();
            this.getlToTalResult().setText(this.getSellBUS().getBillBUS().getPriceOfBill(this.getlResultBillId().getText()) + "");
            if(this.getDetailPanelList().isEmpty() && !this.getlResultTableId().getText().equalsIgnoreCase(""))  {
                resetAndNextCardTable();
            }
        });
        
        //Tao panel dang box layout de hien thi thong tin
        JPanel pWest = new JPanel();
        pWest.setLayout(new BoxLayout(pWest, BoxLayout.Y_AXIS));
        pWest.setPreferredSize(new Dimension(JPanel.WIDTH, JPanel.HEIGHT));
        pWest.setBackground(new Color(208, 187, 173));
        pWest.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        //Add cac thanh phan vao detailPanel
        detailPanel.add(delete, BorderLayout.EAST);
        detailPanel.add(pWest, BorderLayout.CENTER);
        
        //Add product name + qty + price
        JPanel pHeaderWest = new JPanel();
        pHeaderWest.setLayout(new BorderLayout());
        pHeaderWest.setBackground(new Color(208, 187, 173));
        
        JLabel jProductName = new JLabel(this.getSellBUS().getProductBUS().getProductFromId(this.getSellBUS().getDetailBillBUS().getDetailBillFromId(detailBillId).getProductId()).getProductName());
        jProductName.setFont(new Font("Arial", Font.BOLD, 15));
        jProductName.setPreferredSize(new Dimension(220, JPanel.HEIGHT));
        
        JLabel jQty = new JLabel("X " + this.getSellBUS().getDetailBillBUS().getQuantity(detailBillId));
        jQty.setFont(new Font("Arial", Font.BOLD, 15));
        
        JLabel jTotalPrice = new JLabel("VND" + this.getSellBUS().getDetailBillBUS().getDetailBillFromId(detailBillId).getUnitPrice());
        jTotalPrice.setFont(new Font("Arial", Font.BOLD, 15));
        jTotalPrice.setPreferredSize(new Dimension(100, JPanel.HEIGHT));
        
        pHeaderWest.add(jProductName, BorderLayout.WEST);
        pHeaderWest.add(jQty, BorderLayout.CENTER);
        pHeaderWest.add(jTotalPrice, BorderLayout.EAST);
        
        
        pWest.add(pHeaderWest);
        
        //Add product size + status
        JPanel pSizeAndStatus = new JPanel();
        pSizeAndStatus.setLayout(new GridLayout(1, 2));
        pSizeAndStatus.setBackground(new Color(208, 187, 173));
        
        JLabel jSize = new JLabel("─ Size: " + this.getSellBUS().getDetailBillBUS().getDetailBillFromId(detailBillId).getProductSize());
        JLabel jStatus = new JLabel("─ Status: " + this.getSellBUS().getDetailBillBUS().getDetailBillFromId(detailBillId).getProducStatus());
        
        pSizeAndStatus.add(jSize);
        pSizeAndStatus.add(jStatus);
        
        pWest.add(pSizeAndStatus);
        
        Vector<BillDetail_ToppingDTO> detailToppingList = this.getSellBUS().getDetailBillToppingBUS().getDetailToppingList(detailBillId);
        detailPanel.setPreferredSize(new Dimension(400, (detailToppingList.size() + 2) * 25));
        
        if(!detailToppingList.isEmpty()) {
            for(BillDetail_ToppingDTO detailTopping: detailToppingList) {
                JPanel pDetailTopping = new JPanel();
                pDetailTopping.setBackground(new Color(208, 187, 173));
                pDetailTopping.setLayout(new BorderLayout());
                
                //Tao JLabel Topping name
                JLabel lToppingName = new JLabel("─ " + this.getSellBUS().getToppingBUS().getToppingFromId(detailTopping.getToppingId()).getToppingName());
                lToppingName.setPreferredSize(new Dimension(220, JPanel.HEIGHT));
                //Tao JLabel topping qty
                JLabel lToppingQty = new JLabel("X " + detailTopping.getQuantity());
                
                //Tao JLabel detailTopping price
                JLabel lDetailToppingPrice = new JLabel("VND" + detailTopping.getPrice());
                lDetailToppingPrice.setPreferredSize(new Dimension(100, JPanel.HEIGHT));
                
                pDetailTopping.add(lToppingName, BorderLayout.WEST);
                pDetailTopping.add(lToppingQty, BorderLayout.CENTER);
                pDetailTopping.add(lDetailToppingPrice, BorderLayout.EAST);
                
                pWest.add(pDetailTopping);
            }
        }
        
        return detailPanel;
    }
    
    public void nextCardOrder() {
        CardLayout cardNew = (CardLayout) this.getpOrderBodyContainer().getLayout();
        cardNew.show(this.getpOrderBodyContainer(), "OrderBodyTemp");
        cardNew.show(this.getpOrderBodyContainer(), "OrderBody");
    }
    
    public void addDetailPanelListToPOrderBody() {
        for(JPanel detail: this.getDetailPanelList()) {
            this.getpOrderBody().add(detail);
        }
    }
    
    public void resetAndNextCardTable() {
        this.resetpTable();
        this.getCard().show(this.getpBodyMenus(), "Temp");
        this.getCard().show(this.getpBodyMenus(), "Table");
    }
    
    public void resetpTable() {
        this.createTablePanelList();
        this.addComponentsInTablePanelListToJPanel(this.getPanelList(), this.getpTable());
    }
    
    private void createpTable() {
        this.getpTable().removeAll();
        this.createTablePanelList();
        this.addComponentsInTablePanelListToJPanel(this.getPanelList(), this.getpTable());
    }
}
